package xyz.beever.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.beever.demo.dao.PasteRepository;
import xyz.beever.demo.model.Paste;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/paste")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PasteController {

    @Autowired
    private PasteRepository pasteRepository;

    @PostMapping
    public UUID addPaste(@RequestBody @Validated Paste paste) {
        pasteRepository.save(paste);

        System.out.println(paste.getId());
        return paste.getId();

    }

    @GetMapping(path = "all/")
    public List<Paste> getAllPastes(){
        return (List<Paste>) pasteRepository.findAll();
    }

    @GetMapping(path="count/{count}")
    public List<Paste> getPastes(int count){
        // trim the results to count
       List<Paste> result = (List<Paste>) pasteRepository.findAll();
       return result.subList(0, count);
     }

    @GetMapping("/{id}")
    public ResponseEntity<Paste> findUserById(@PathVariable(value = "id") UUID id) {
        Optional<Paste> paste = pasteRepository.findById(id);

        return paste.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
