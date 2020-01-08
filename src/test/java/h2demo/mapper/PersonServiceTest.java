package h2demo.mapper;

import h2demo.domain.Person;
import h2demo.service.PersonService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * Created by machenggong on 2020/1/2.
 */
public class PersonServiceTest {

    private PersonDao mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.getPerson(2)).thenReturn(new Person(2, "Person1"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(1, "new name");
        assertTrue("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, times(1)).update(isA(Person.class));
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = personService.update(2, "new name");
        assertFalse("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));
    }
}
