package me.abdc.junit5gettingstarted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NamingTest {

    @Test
    @DisplayName("샘플 만들기")
    void create_new_sample() {
        System.out.println("create_new_basic");
        Sample sample = new Sample();
        assertNotNull(sample);
    }

    @Test
    @DisplayName("또 다른 샘플 만들기")
    void create_new_another_sample() {
        System.out.println("create_new_another_basic");
        Sample sample = new Sample();
        assertNotNull(sample);
    }

}
