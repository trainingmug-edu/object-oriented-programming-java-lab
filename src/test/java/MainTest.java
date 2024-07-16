import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {

    @Test
    @Order(1)
    void testEmployeeClassAllArgsConstructor() {
        Employee emp = new Employee(1L, "John Doe", "Software Engineer", 100000L, 5000L, 10000L, 5000L);
        assertEquals(1L, emp.empId);
        assertEquals("John Doe", emp.name);
        assertEquals("Software Engineer", emp.designation);
        assertEquals(100000L, emp.grossSalary);
        assertEquals(5000L, emp.travellingAllowances);
        assertEquals(10000L, emp.federalTax);
        assertEquals(5000L, emp.stateTax);
    }

    @Test
    @Order(2)
    void testEmployeeClassNoArgsConstructor() {
        Employee emp = new Employee();
        assertEquals(0L, emp.empId);
        assertNull(emp.name);
        assertNull(emp.designation);
        assertEquals(0L, emp.grossSalary);
        assertEquals(0L, emp.travellingAllowances);
        assertEquals(0L, emp.federalTax);
        assertEquals(0L, emp.stateTax);
    }

    @Test
    @Order(2)
    void testEmployeeClassSettersAndGetters() {
        Employee emp = new Employee(1L, "John Doe", "Software Engineer", 100000L, 5000L, 10000L, 5000L);
        emp.empId = 2L;
        emp.name = "Jane Doe";
        emp.designation = "Senior Software Engineer";
        emp.grossSalary = 120000L;
        emp.travellingAllowances = 6000L;
        emp.federalTax = 12000L;
        emp.stateTax = 6000L;
        assertEquals(2L, emp.empId);
        assertEquals("Jane Doe", emp.name);
        assertEquals("Senior Software Engineer", emp.designation);
        assertEquals(120000L, emp.grossSalary);
        assertEquals(6000L, emp.travellingAllowances);
        assertEquals(12000L, emp.federalTax);
        assertEquals(6000L, emp.stateTax);
    }

    @Test
    @Order(3)
    void testIncrementSalary() {
        Employee emp = new Employee(1L, "John Doe", "Software Engineer", 100000L, 5000L, 10000L, 5000L);
        emp.incrementSalary(10L);
        assertEquals(110000L, emp.grossSalary);
    }

    @Test
    @Order(4)
    void testCreateEmployee() {
        Main main = new Main();
        Employee emp = main.createEmployee(1L, "John Doe", "Software Engineer", 100000L, 5000L, 10000L, 5000L);
        assertEquals(1L, emp.empId);
        assertEquals("John Doe", emp.name);
        assertEquals("Software Engineer", emp.designation);
        assertEquals(100000L, emp.grossSalary);
        assertEquals(5000L, emp.travellingAllowances);
        assertEquals(10000L, emp.federalTax);
        assertEquals(5000L, emp.stateTax);
        assertEquals(1, Employee.employeeCount);

        // creating 2nd employee
        Employee emp2 = main.createEmployee(2L, "Jane Doe", "Senior Software Engineer", 120000L, 6000L, 12000L, 6000L);
        assertEquals(2L, emp2.empId);
        assertEquals("Jane Doe", emp2.name);
        assertEquals("Senior Software Engineer", emp2.designation);
        assertEquals(120000L, emp2.grossSalary);
        assertEquals(6000L, emp2.travellingAllowances);
        assertEquals(12000L, emp2.federalTax);
        assertEquals(6000L, emp2.stateTax);
        assertEquals(2, Employee.employeeCount);
    }

    @Test
    @Order(5)
    void testDisplayCompanyName() {
        Employee.companyName = "TrainingMug";
        assertEquals("TrainingMug", Employee.companyName);
    }

    @Test
    @Order(6)
    void testDisplayProfile() {
        Employee emp = new Employee(1L, "John Doe", "Software Engineer", 100000L, 5000L, 10000L, 5000L);
        emp.displayProfile();
    }

    @Test
    @Order(7)
    void testDisplayCompanyInfo() {
        Employee.companyName = "TrainingMug";
        Employee.companyContactNo = "1234567890";
        Employee.employeeCount = 2;
        Employee.displayCompanyInfo();
    }

}
