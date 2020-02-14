package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SimpleListTest {
    /**
     * This class uses a simple list and does filtering, traversing in both conventional way and using streams.
     */
    List<Integer> ages = new LinkedList<>();
    StackTraceElement stackTrace;

    @Before
    public void setup() {
        Integer[] numbers = new Integer[]{12, 18, 21, 42, 21, 17, 16, 30};
        ages.addAll(Arrays.asList(numbers));
    }

    private void printLocation() {
        stackTrace = new Throwable().getStackTrace()[1];
        System.out.println(stackTrace.getClassName() + " :: " + stackTrace.getMethodName());
    }

    @Test
    public void ConventionalMethod() {
        printLocation();
        for (int age : ages) {
            System.out.print(age + ", ");
        }
        assertTrue(true);
    }

    @Test
    public void UsingStreams() {
        printLocation();
        ages.stream().forEach((age) -> System.out.print(age + ", "));
        assertTrue(true);
    }

    @Test
    public void filterConventionalMethod() {
        printLocation();
        for (int age : ages) {
            if (age >= 18) {
                System.out.print(age + ", ");
            }
        }
        assertTrue(true);
    }

    @Test
    public void filterUsingStreams() {
        printLocation();
        ages.stream().filter(age -> age >= 18).forEach((age) -> System.out.print(age + ", "));
        assertTrue(true);
    }

    @After
    public void teardown() {
        System.out.println("\n----------------------------------");
    }
}
