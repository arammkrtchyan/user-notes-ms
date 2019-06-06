package co.donebyme.microservices.notes.port.adapter.persistence;

import co.donebyme.microservices.notes.domain.model.note.Note;
import co.donebyme.microservices.notes.domain.model.note.NoteId;
import co.donebyme.microservices.notes.domain.model.note.NoteRepository;
import co.donebyme.microservices.notes.domain.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
public interface JpaNoteRepository extends NoteRepository, JpaRepository<Note, NoteId> {

    @Override
    default Optional<Note> ofId(NoteId noteId) {
        return findById(noteId);
    }

    List<Note> findByAuthor(Author author);

    @Override
    default List<Note> notesOfUser(Author author) {
        return findByAuthor(author);
    }
}
