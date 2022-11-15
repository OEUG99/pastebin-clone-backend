package xyz.beever.demo.model;

import java.util.UUID;

public class Paste {

    private final UUID id;

    private final String name;

    private String contents;



    public Paste(UUID id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContents() { return contents; }

}
