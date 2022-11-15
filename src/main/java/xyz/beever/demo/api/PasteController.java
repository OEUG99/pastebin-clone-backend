package xyz.beever.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.beever.demo.model.Paste;
import xyz.beever.demo.service.PasteService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/paste")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PasteController {

    private final PasteService pasteService;

    @Autowired
    public PasteController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @PostMapping
    public void addPaste(String title, String text)
    {
        pasteService.addPaste(title, text);
    }

    @GetMapping
    public List<Paste> getAllPastes(){
        return pasteService.getAllPastes();
    }

    @GetMapping(path = "{id}")
    public Paste getPasteById(@PathVariable("id") UUID id){
        return pasteService.getPastesById(id);
    }

}
