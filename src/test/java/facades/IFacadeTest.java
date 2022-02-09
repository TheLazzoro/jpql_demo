package facades;

import entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeTest {

    IFacade facade = new Facade();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllEmployees() {
        System.out.println("Get all employees");
        int actual = facade.getAllEmployees().size();
        int expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    void getHighestPaid() {
        System.out.println("Get highest paid");
        Employee expected = facade.getHighestPaid();
        Employee actual = new Employee();
        actual.setName("Hallur");
        actual.setSalery(19000);

        assertTrue(expected.equals(actual));
    }

    @Test
    void getAverageSalery() {
    }

    @Test
    void getAllBelowAverage() {
    }

    @Test
    void getWithMostEmployees() {
    }

    @Test
    void getMostExpensiveSalarySum() {
    }

    @Test
    void getDepartmentsWithEmpNamed() {
    }
}