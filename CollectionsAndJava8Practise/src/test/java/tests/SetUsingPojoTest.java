package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojos.Employee;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class SetUsingPojoTest {
    /**
     * This class uses a set of POJO objects and does traversing, filtering in both conventional way & using streams.
     */
    Set<Employee> employees = new HashSet<>();
    StackTraceElement stackTrace;

    @Before
    public void setup() {
        employees.add(new Employee(42, "Phoebe", "SDET"));
        employees.add(new Employee(42, "Phoebe", "SDET"));
        employees.add(new Employee(42, "Phoebe", "SDET"));
        employees.add(new Employee(43, "Phoebe", "Java"));
        employees.add(new Employee(43, "Phoebo", "Java"));
        employees.add(new Employee(44, "Chandler", "SDET"));
        employees.add(new Employee(44, "Joey", "Java"));
    }

    private void printPosition() {
        stackTrace = new Throwable().getStackTrace()[1];
        System.out.println(stackTrace.getClassName() + " :: " + stackTrace.getMethodName());
    }

    @Test
    public void ConventionalMethod() {
        printPosition();
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " : " + employee.getName() + ", " + employee.getStream());
        }
        assertTrue(true);
    }

    @Test
    public void UsingStreams() {
        printPosition();
        employees.stream().forEach((employee) -> System.out.println(employee.toString()));
        assertTrue(true);
    }

    @Test
    public void filterConventionalMethod() {
        printPosition();
        for (Employee employee : employees) {
            if (employee.getStream().equals("SDET")) {
                System.out.println(employee.getId() + " : " + employee.getName() + ", " + employee.getStream());
            }
        }
        assertTrue(true);
    }

    @Test
    public void filterUsingStreams() {
        printPosition();
        employees.stream().filter(employee -> employee.getStream().equals("SDET")).forEach((employee) -> System.out.println(employee.toString()));
        assertTrue(true);
    }

    @After
    public void teardown() {
        System.out.println("\n----------------------------------");
    }
}
