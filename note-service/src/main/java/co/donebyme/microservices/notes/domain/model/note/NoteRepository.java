package co.donebyme.microservices.notes.domain.model.note;

import co.donebyme.microservices.notes.domain.model.user.UserId;

/**
 * @author Aram Mkrtchyan.
 */
public interface NoteRepository {

    Note save(Note note);

    Note ofId(NoteId noteId);

    Iterable<Note> findAll();

    Iterable<Note> notesOfUser(UserId userId);

}
