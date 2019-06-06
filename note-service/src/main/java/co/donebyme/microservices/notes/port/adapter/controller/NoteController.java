package co.donebyme.microservices.notes.port.adapter.controller;

import co.donebyme.microservices.notes.application.NoteApplicationService;
import co.donebyme.microservices.notes.application.command.ModifyNoteCommand;
import co.donebyme.microservices.notes.application.command.SubmitNoteCommand;
import co.donebyme.microservices.notes.domain.model.note.Note;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aram Mkrtchyan.
 */
@RestController
@RequestMapping("/notes")
public class NoteController {


    private final NoteApplicationService noteApplicationService;

    public NoteController(NoteApplicationService noteApplicationService) {
        this.noteApplicationService = noteApplicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Note submitNote(@RequestBody SubmitNoteCommand command) {
        return noteApplicationService.submitNote(command);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/{id}")
    public NoteView findNote(@PathVariable String id) {
        String userId = null;
        return noteView(noteApplicationService.findById(userId, id));
    }


    @RequestMapping(
            method = RequestMethod.GET,
            params = "userId"
    )
    public List<NoteView> notesOfUser(@RequestParam(name = "userId") String userId) {
        return noteApplicationService.notesOfAuthor(userId).stream()
                .map(this::noteView).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public NoteView modifyNote(@RequestBody ModifyNoteCommand command) {
        return noteView(noteApplicationService.modifyNote(command));
    }

    private NoteView noteView(Note note) {
        return new NoteView(
                note.getAuthor().getEmail(),
                note.getNote(),
                note.getTitle(),
                note.getNoteId().getId()
        );
    }

}
