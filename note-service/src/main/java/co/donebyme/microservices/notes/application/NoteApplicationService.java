package co.donebyme.microservices.notes.application;

import co.donebyme.microservices.notes.application.command.SubmitNoteCommand;
import co.donebyme.microservices.notes.application.exception.NoteAccessDeniedException;
import co.donebyme.microservices.notes.application.exception.NoteNotFoundException;
import co.donebyme.microservices.notes.application.exception.UserNotFoundException;
import co.donebyme.microservices.notes.domain.model.author.Author;
import co.donebyme.microservices.notes.domain.model.author.CollaboratorService;
import co.donebyme.microservices.notes.domain.model.note.Note;
import co.donebyme.microservices.notes.domain.model.note.NoteId;
import co.donebyme.microservices.notes.domain.model.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
@Service
public class NoteApplicationService {


    private final NoteRepository noteRepository;

    private final CollaboratorService collaboratorService;

    @Autowired
    public NoteApplicationService(NoteRepository noteRepository, CollaboratorService collaboratorService) {
        this.noteRepository = noteRepository;
        this.collaboratorService = collaboratorService;
    }

    public Note submitNote(SubmitNoteCommand command) {
        String userId = command.getUserId();
        Author author = collaboratorService.authorFrom(userId);
        Note note = Note.submitNote(command.getTitle(), command.getNote(), author);
        return noteRepository.save(note);
    }

    public List<Note> notesOfAuthor(String userId) {
        Author author = collaboratorService.authorFrom(userId);
        if (author == null) {
            throw new UserNotFoundException(String.format("No user with specified id: %s", userId));
        }

        return noteRepository.notesOfUser(author);

    }

    public Note findById(String userId, String identity) {
        Author author = collaboratorService.authorFrom(userId);
        if (author == null) {
            throw new UserNotFoundException(String.format("No user with specified id: %s", userId));
        }

        Optional<Note> note = noteRepository.ofId(NoteId.fromExisting(identity));


        return note.map(n -> {
            if (!Objects.equals(userId, n.getAuthor().getAuthorId().getId())) {
                throw new NoteAccessDeniedException("No access to the notes of the others.");
            }
            return n;
        }).orElseThrow(() ->
                new NoteNotFoundException("Couldn't find note with specified identity.")
        );

    }

}
