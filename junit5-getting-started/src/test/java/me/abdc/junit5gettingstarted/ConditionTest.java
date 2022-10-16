package me.abdc.junit5gettingstarted;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ConditionTest {

    @Test
    void create1() {
        System.out.println("create1");
        String environment = System.getenv("Environment");

        assumeTrue("local".equalsIgnoreCase(environment));
        assertThrows(IllegalArgumentException.class, () -> new Study(-10));
    }

    @Test
    void create2() {
        System.out.println("create2");
        String environment = System.getenv("Environment");

        assumingThat("local".equalsIgnoreCase(environment), () -> {
            System.out.println("local");
            assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        });

        assumingThat("dev".equalsIgnoreCase(environment), () -> {
            System.out.println("dev");
            assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        });
    }
    
    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_11})
    void create3() {
        System.out.println("create3");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "Environment", matches = "local")
    void create4() {
        System.out.println("create4");
    }
}
