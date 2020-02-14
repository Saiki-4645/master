package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MapTest {
    /**
     * This class uses a map and does traversing in both conventional way & using streams.
     */
    Map<String, Integer> fruits = new HashMap<String, Integer>();
    StackTraceElement stackTrace;

    @Before
    public void setup() {
        fruits.put("Apple", 15);
        fruits.put("Mango", 12);
        fruits.put("Orange", 10);
        fruits.put("Kiwi", 18);
        fruits.put("Strawberry", 16);
    }

    private void printPosition() {
        stackTrace = new Throwable().getStackTrace()[1];
        System.out.println(stackTrace.getClassName() + " :: " + stackTrace.getMethodName());
    }

    @Test
    public void conventionalMethod() {
        printPosition();
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            System.out.println(fruit.getKey() + ": " + fruit.getValue() + "/-");
        }
        assertTrue(true);
    }

    @Test
    public void usingStreams() {
        printPosition();
        fruits.entrySet().stream().forEach((fruit) -> System.out.println(fruit.getKey() + ": Rs." + fruit.getValue()));
        assertTrue(true);
    }

    @After
    public void teardown() {
        System.out.println("----------------------------------");
    }
}
