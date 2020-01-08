package h2demo.mapper;

import h2demo.domain.Person;

/**
 * Created by machenggong on 2020/1/2.
 */
public interface PersonDao {

    Person getPerson(int id);

    boolean update(Person person);

}
