package h2demo.mapper;

import h2demo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by machenggong on 2020/1/2.
 */
@Mapper
@Component
public interface PersonDao {

    Person getPerson(@Param("id") int id);

    boolean update(Person person);

}
