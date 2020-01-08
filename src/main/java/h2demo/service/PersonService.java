package h2demo.service;

import h2demo.domain.Person;
import h2demo.mapper.PersonDao;

/**
 * Created by machenggong on 2020/1/2.
 */
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(int id, String name) {
        Person person = personDao.getPerson(id);
        if (person == null) {
            return false;
        }

        Person personUpdate = new Person(person.getId(), name);
        return personDao.update(personUpdate);
    }

}
