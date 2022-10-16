package me.abdc.junit5gettingstarted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NamingTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        System.out.println("create_new_study");
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    @DisplayName("또 다른 스터디 만들기")
    void create_new_another_study() {
        System.out.println("create_new_another_study");
        Study study = new Study();
        assertNotNull(study);
    }

}
