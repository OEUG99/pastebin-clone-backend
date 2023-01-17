package xyz.beever.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.UUID;

@Entity
public class Paste {

    @javax.persistence.Id
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "String",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;

    @Column(columnDefinition="VARCHAR(15)")
    private String title;

    @Column(columnDefinition="TEXT")
    private String contents;

    @Column(columnDefinition="boolean")
    boolean syntaxHighlights;

    public Paste(String name, String contents, boolean syntaxHighlights) {
        this.title = name;
        this.contents = contents;
        this.syntaxHighlights = syntaxHighlights;
    }

    public Paste() {

    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public UUID getId() {
        return Id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){this.title = title;}

    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents=contents; }

}
