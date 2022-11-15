package xyz.beever.demo.dao;

import xyz.beever.demo.model.Paste;

import java.util.List;
import java.util.UUID;

public interface PasteDao {


    int insertPaste(String title, String text);

    List<Paste> selectAllPastes();

    Paste selectPasteById(UUID id);
}
