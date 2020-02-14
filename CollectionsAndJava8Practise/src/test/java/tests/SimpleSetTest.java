package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class SimpleSetTest {
    /**
     * This class uses a simple set and does traversing in both conventional way and using streams.
     */
    Set<String> cities = new HashSet<>();
    StackTraceElement stackTrace;

    @Before
    public void setup() {
        String[] cityNames = {"New York", "Vancouver", "Paris", "Milan", "London", "Amsterdam", "Vancouver", "Toronto"};
        cities.addAll(Arrays.asList(cityNames));
    }

    private void printPosition() {
        stackTrace = new Throwable().getStackTrace()[1];
        System.out.println(stackTrace.getClassName() + " :: " + stackTrace.getMethodName());
    }

    @Test
    public void conventionalMethod() {
        printPosition();
        for (String city : cities) {
            System.out.print(city + " \\ ");
        }
        assertTrue(true);
    }

    @Test
    public void usingStreams() {
        printPosition();
        cities.stream().forEach((city) -> System.out.print(city + " / "));
        assertTrue(true);
    }

    @After
    public void teardown() {
        System.out.println("\n----------------------------------");
    }
}
