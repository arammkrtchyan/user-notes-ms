package co.donebyme.microservices.notes.domain.model.note;

import co.donebyme.microservices.notes.domain.model.author.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
public interface NoteRepository {

    Note save(Note note);

    Optional<Note> ofId(NoteId noteId);

    List<Note> notesOfUser(Author author);

}
