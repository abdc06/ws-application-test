package me.abdc.junit5gettingstarted;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AssertionTest {

    @Test
    void create_new_study() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = illegalArgumentException.getMessage();

        assertEquals("limit은 0보다 커야 합니다.", message);

        Study study = new Study();

        assertAll(
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값은 " + StudyStatus.DRAFT + " 여야 한다."),
                () -> assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 인원은 0보다 커야 한다."),
                () -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> { // TODO ThreadLocal
                    Thread.sleep(10000);
                    new Study();
                })
        );
    }
}
