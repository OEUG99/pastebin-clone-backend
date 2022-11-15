package xyz.beever.demo.dao;

import org.springframework.stereotype.Repository;
import xyz.beever.demo.model.Paste;

import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

@Repository("PasteDao")
public class PasteDataAccessService implements PasteDao{

    Hashtable<UUID, Paste> DB = new Hashtable<UUID, Paste>();

    @Override
    public int insertPaste(String title, String text) {
        UUID id = UUID.randomUUID();
        DB.put(id, new Paste(UUID.randomUUID(), title, text));
        return 1;
    }

    @Override
    public List<Paste> selectAllPastes() {
        return DB.values().stream().toList();
    }

    @Override
    public Paste selectPasteById(UUID id) {
        return DB.get(id);
    }
}
