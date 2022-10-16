package me.abdc.junit5gettingstarted;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BasicTest {

    @Test
    void create() {
        System.out.println("create");
        Basic study = new Basic();
        assertNotNull(study);
    }

    @Test
    void anotherCreate() {
        System.out.println("anotherCreate");
    }

    @Test
    @Disabled   //테스트를 실행하지 않음
    void disabled() {
        System.out.println("disabled");
    }

    /**
     * 모든 테스트가 시작되기 전 한 번 실행
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    /**
     * 모든 테스트가 시작된 후 한 번 실행
     */
    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    /**
     * 각각의 모든 테스트가 시작되기 전 싫행
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    /**
     * 각각의 모든 테스트가 시작된 후 싫행
     */
    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}