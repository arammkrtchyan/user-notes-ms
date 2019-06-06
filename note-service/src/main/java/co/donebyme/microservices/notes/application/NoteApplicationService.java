package co.donebyme.microservices.notes.application;

import co.donebyme.microservices.notes.application.command.SubmitUsersNoteCommand;
import co.donebyme.microservices.notes.application.exception.UserNoteFoundException;
import co.donebyme.microservices.notes.domain.model.author.Author;
import co.donebyme.microservices.notes.domain.model.author.CollaboratorService;
import co.donebyme.microservices.notes.domain.model.note.Note;
import co.donebyme.microservices.notes.domain.model.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Note submitUsersNote(SubmitUsersNoteCommand command) {
        String userId = command.getUserId();
        Author author = collaboratorService.authorFrom(userId);
        Note note = Note.submitNote(command.getTitle(), command.getNote(), author);
        return noteRepository.save(note);
    }

    public List<Note> notesOfAuthor(String userId) {
        Author author = collaboratorService.authorFrom(userId);
        if (author == null) {
            throw new UserNoteFoundException(String.format("No user with specified id: ", userId));
        }

        return noteRepository.notesOfUser(author);

    }

}
