package xyz.beever.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import xyz.beever.demo.dao.PasteDao;
import xyz.beever.demo.model.Paste;

import java.util.List;
import java.util.UUID;

@Service
public class PasteService {


    private final PasteDao pasteDao;

    @Autowired // autowired dependency injected "fakeDao" aka the PersonDao implementation:
    public PasteService( @Qualifier("PasteDao") PasteDao pasteDao) {
        this.pasteDao = pasteDao;
    }


    public int addPaste(String title, String text) {
        return pasteDao.insertPaste(title, text);
    }

    public List<Paste> getAllPastes() {
        return pasteDao.selectAllPastes();
    }

    public Paste getPastesById(UUID id) {
        return pasteDao.selectPasteById(id);
    }
}
