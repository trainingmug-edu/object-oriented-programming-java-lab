package com.trainingmug.ecommerce;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTest {

    Employee employee;
    Employee employee1;
    Employee employee2;
    Employee employee3;
    Employee employee4;
    Employee employee5;
    Employee employee6;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee1 = new Employee(111,"Andrew Fuller","Senior Software Engineer",5208.33f,300.0f,611.86f,359.24f);
        employee2 = new Employee(1, "John Doe", "Developer", 75000.00f, 5000.00f, 15000.00f, 3000.00f);
        employee3 = new Employee(2, "Jane Doe", "Manager", 85000.00f, 6000.00f, 17000.00f, 4000.00f);
        employee4 = new Employee(3, "Bob Smith", "Tester", 60000.00f, 3000.00f, 12000.00f, 2000.00f);
        employee5 = new Employee(4, "Alice Johnson", "Analyst", 50000.00f, 2500.00f, 10000.00f, 1500.00f);
        employee6 = new Employee(5, "Charlie Brown", "Consultant", 0.00f, 0.00f, 0.00f, 0.00f);

    }

    @AfterEach
    public void tearDown() {
        employee = null;
        employee1 = null;
        employee2 = null;
        employee3 = null;
        employee4 = null;
        employee5 = null;
        employee6 = null;
        Employee.employeeCount = 0;

    }
    @Test
    @Order(1)
    @DisplayName("Should Create Employee class in com.trainingmug.ecommerce package")
    public void testEmployeeClassExists() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Should create the fields in Employee class with the appropriate Type")
    void testVariablesInEmployeeShouldBePresent() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            assertFieldIsPublic(employeeClass, "id", long.class);
            assertFieldIsPublic(employeeClass, "name", String.class);
            assertFieldIsPublic(employeeClass, "designation", String.class);
            assertFieldIsPublic(employeeClass, "grossSalary", float.class);
            assertFieldIsPublic(employeeClass, "travellingAllowances", float.class);
            assertFieldIsPublic(employeeClass, "federalTax", float.class);
            assertFieldIsPublic(employeeClass, "stateTax", float.class);

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        }
    }

    private void assertFieldIsPublic(Class<?> clazz, String fieldName, Class<?> fieldType) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertEquals(fieldType, field.getType(), "Field " + fieldName + " should be of type " + fieldType.getSimpleName());
            assertTrue(Modifier.isPublic(field.getModifiers()), "Field " + fieldName + " should be public");
        } catch (NoSuchFieldException e) {
            fail("Field " + fieldName + " should be present in the class " + clazz.getSimpleName());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should have Employee() no-arg constructor")
    public void testEmployeeConstructor() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
            assertNotNull(noArgConstructor, "Employee() No-arg constructor should be present");
            assertTrue(Modifier.isPublic(noArgConstructor.getModifiers()), "No-arg constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee() No-arg constructor not found in class " + className);
        }
    }

    @Test
    @Order(4)
    @DisplayName("Should be able to create Employee Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeConstructorAndInitializeProperties() {

        float delta = 0.01f;
        // Assertions to verify the values
        assertEquals(1111, employee.id, "Employee id should be 111");
        assertEquals("Andrew Fuller", employee.name, "Employee name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Employee designation should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary,delta, "Employee grossSalary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances,delta, "Employee travellingAllowances should be 300.0f");
        assertEquals(611.86, employee.federalTax,delta, "Employee federalTax should be 611.86");
        assertEquals(359.24, employee.stateTax,delta, "Employee stateTax should be 359.24");
    }
    @Test
    @Order(5)
    @DisplayName("Should create Employee All Args Constructor")
    public void testEmployeeAllArgsConstructor() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(long.class, String.class, String.class, float.class, float.class, float.class, float.class);

            // Check if the constructor is public
            assertNotNull(constructor, "Employee All Args Constructor should be present");
            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {

            fail("Employee All Args Constructor is not found in class  " + className);
        }
    }

    @Test
    @Order(5)
    @DisplayName("Should be able to create Employee Arg Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeArgConstructorAndInitializeProperties() {
        float delta = 0.01f;
        assertEquals(111, employee1.id, "Id value should be 111");
        assertEquals("Andrew Fuller", employee1.name, "Name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee1.designation, "Department should be Senior Software Engineer");
        assertEquals(5208.33, employee1.grossSalary, delta,"Gross Salary should be 5208.33");
        assertEquals(300.0, employee1.travellingAllowances, delta,"Gross Salary should be 5208.33");
        assertEquals(611.86, employee1.federalTax, delta, "TravellingAllowances should be 300.0");
        assertEquals(359.24, employee1.stateTax, delta,"StateTax should be 611.86");
    }

    @Test
    @Order(6)
    @DisplayName("Test DisplayProfile method should exist")
    public void testDisplayProfileMethodExists() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getMethod("displayProfile");
            Parameter[] parameters = method.getParameters();
            assertEquals(0,parameters.length,"Method displayProfile should not take parameter");
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Method displayProfile() should be present in Employee class");
        }
    }
    @Test
    @Order(7)
    @DisplayName("Test DisplayProfile Output ")
    public void testDisplayProfileOutput() {
        Employee employee = new Employee();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        employee.displayProfile();

        System.setOut(originalOut);

        // Expected output with platform-specific newlines
        String expectedOutput = "Id: 1111" + System.lineSeparator() +
                "Name: Andrew Fuller" + System.lineSeparator() +
                "Designation: Senior Software Engineer" + System.lineSeparator() +
                "Gross Salary: 5208.33" + System.lineSeparator() +
                "Travelling Allowances: 300.0" + System.lineSeparator() +
                "Federal Tax: 611.86" + System.lineSeparator() +
                "State Tax: 359.24" + System.lineSeparator() ;

        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput, "The displayProfile method should print the correct output");
    }

    @Test
    @Order(8)
    @DisplayName("Test method IncrementSalary Should be present")
    public void testIncrementSalaryMethodExists() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            employeeClass.getMethod("incrementSalary", float.class);
        } catch (NoSuchMethodException e) {
            fail("Method incrementSalary(float) should be present in Employee class");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(9)
    @DisplayName("Test IncrementSalary method parameter Should be present")
    public void testIncrementSalaryMethodParameters() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getMethod("incrementSalary", float.class);
            Parameter[] parameters = method.getParameters();
            assertEquals(1, parameters.length, "Method incrementSalary should take exactly one parameter");
            assertEquals(float.class, parameters[0].getType(), "Parameter type should be float");
        } catch (NoSuchMethodException e) {
            fail("Method incrementSalary(float) should be present in Employee class");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(10)
    @DisplayName("test incrementSalary() method normal scenario")
    public void testIncrementSalaryNormalScenario() {
         float expectedSalary = 75000.00f + 7500.00f; // 10% of 75000
        assertEquals(expectedSalary, employee2.incrementSalary(10.0f));
    }

    @Test
    @Order(11)
    @DisplayName("test incrementSalary() with zero percentage")
    public void testIncrementSalaryZeroPercentage() {
        float expectedSalary = 85000.00f; // 0% increment
        assertEquals(expectedSalary, employee3.incrementSalary(0.0f));
    }

    @Test
    @Order(12)
    @DisplayName("test incrementSalary() with negative percentage")
    public void testIncrementSalaryNegativePercentage() {
        float expectedSalary = 60000.00f - 3000.00f; // -5% of 60000
        assertEquals(expectedSalary, employee4.incrementSalary(-5.0f));
    }

    @Test
    @Order(14)
    @DisplayName("test incrementSalary with High percentage")
    public void testIncrementSalaryHighPercentage() {
        float expectedSalary = 50000.00f + 100000.00f; // 200% of 50000
        assertEquals(expectedSalary, employee5.incrementSalary(200.0f));
    }

    @Test
    @Order(15)
    @DisplayName("test incrementSalary with zero salary")
    public void testIncrementSalaryEdgeCaseZeroSalary() {
        float expectedSalary = 0.00f; // 10% of 0
        assertEquals(expectedSalary, employee6.incrementSalary(10.0f));
    }

    @Test
    @Order(16)
    @DisplayName("Should create the static fields in Employee class with the appropriate Type and Initialization")
    void testStaticVariablesInEmployeeShouldBePresentAndInitialized() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");

            assertStaticFieldIsPublic(employeeClass, "companyName", String.class);
            assertStaticFieldIsPublic(employeeClass, "companyContactNo", String.class);
            assertStaticFieldIsPublic(employeeClass, "employeeCount", long.class);
            assertStaticFieldIsInitialized(employeeClass, "companyName", "Digi-Safari Pvt Ltd");
            assertStaticFieldIsInitialized(employeeClass, "companyContactNo", "+1-111-222-333");
            assertStaticFieldIsInitialized(employeeClass, "employeeCount", 7L);

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        }
    }

    private void assertStaticFieldIsPublic(Class<?> clazz, String fieldName, Class<?> fieldType) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertEquals(fieldType, field.getType(), "Field " + fieldName + " should be of type " + fieldType.getSimpleName());
            assertTrue(Modifier.isPublic(field.getModifiers()), "Field " + fieldName + " should be public");
            assertTrue(Modifier.isStatic(field.getModifiers()), "Field " + fieldName + " should be static");
        } catch (NoSuchFieldException e) {
            fail("Field " + fieldName + " should be present in the class " + clazz.getSimpleName());
        }
    }

    private void assertStaticFieldIsInitialized(Class<?> clazz, String fieldName, Object expectedValue) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(null); // null because it's a static field
            assertEquals(expectedValue, value, "Field " + fieldName + " should be initialized to " + expectedValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Field " + fieldName + " should be present and accessible in the class " + clazz.getSimpleName());
        }
    }

    @Test
    @Order(17)
    @DisplayName("Should create the displayCompanyInfo method in Employee class with the appropriate signature")
    void testDisplayCompanyInfoMethodSignature() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getDeclaredMethod("displayCompanyInfo");
            assertTrue(Modifier.isPublic(method.getModifiers()), "Method displayCompanyInfo should be public");
            assertTrue(Modifier.isStatic(method.getModifiers()), "Method displayCompanyInfo should be static");
            assertEquals(void.class, method.getReturnType(), "Method displayCompanyInfo should return void");
            assertEquals(0, method.getParameterCount(), "Method displayCompanyInfo should take no arguments");

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        } catch (NoSuchMethodException e) {
            fail("Method displayCompanyInfo should be present in the Employee class");
        }
    }

    @Test
    @Order(18)
    @DisplayName("should increment the employee count evvery time the employee object is created")
    void testIncrementEmployeeCountEveryTime() {

        assertEquals(7, Employee.employeeCount,"Employee count is mismatching, count should be 4");

    }

    


}
