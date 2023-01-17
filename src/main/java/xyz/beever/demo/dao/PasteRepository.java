package xyz.beever.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.beever.demo.model.Paste;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PasteDataAccess")
public interface PasteRepository extends CrudRepository<Paste,String> {
}
