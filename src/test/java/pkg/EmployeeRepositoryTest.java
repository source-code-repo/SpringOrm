package pkg;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pkg.Main;
import pkg.entity.People;
import pkg.repository.PeopleRepository;

/**
 * Integration test using in memory database validating repository
 * and query implementation {@link PeopleRepository}
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Use ContextConfiguration to stop CommandLineRunner from running 
// automatically in tests
@ContextConfiguration(classes = Main.class, 
    initializers = ConfigFileApplicationContextInitializer.class)
@AutoConfigureTestDatabase
@Sql({"/db-schema.sql", "/db-data.sql"})
public class EmployeeRepositoryTest {
    
    private static final String SCHOOL = "HighSchool";
    private static final String DEPT2 = "Dept2";
    private static final String UNI = "Uni";
    private static final String MONTHLY = "Monthly";
    private static final String DEPT1 = "Dept1";
    private static final String MARKETING = "Marketing";
    @Autowired
    private PeopleRepository employeeRepository;
    
    /**
     * Repository finds results that it should
     */
    @Test
    public void success() {
        Collection<People> people = employeeRepository.findByDeptEduPay(DEPT1, MONTHLY, UNI);
        assertEquals("Expecting 1 Management, Monthly, Degree people", 1, people.size());
        
        people = employeeRepository.findByDeptEduPay(DEPT2, MONTHLY, SCHOOL);
        assertEquals("Expecting 1 DEPT2, Monthly, High School people", 1, people.size());
    }
    
    /**
     * No results where not expected
     */
    @Test
    public void noResults() {
        Collection<People> people = employeeRepository.findByDeptEduPay(DEPT1, MONTHLY, SCHOOL);
        assertEquals("Expecting 0 results", 0, people.size());
        
        people = employeeRepository.findByDeptEduPay(MARKETING, MONTHLY, SCHOOL);
        assertEquals("Expecting 0 results", 0, people.size());
    }
}