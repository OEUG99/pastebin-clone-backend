package xyz.beever.demo.dao;

import org.springframework.stereotype.Repository;
import xyz.beever.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// using @repository annotation creates bean that can be dependency injected
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
// DAO Implementation class will interact with the database.

    private static List<Person> DB = new ArrayList<>();


    @Override
    public int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB.stream().toList();
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personSearchResult = selectPersonById(id);


        int[] test = {0,1,2,3};

        if (personSearchResult.isEmpty()){
            return 0;
        } else {
            DB.remove(personSearchResult.get());
            return 1;
        }

    }

    @Override
    public int updatePersonById(UUID id, Person personToUpdate) { // searching by id, put providing a Person obj to use as an update
        return selectPersonById(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, personToUpdate.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }


}
