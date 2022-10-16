package me.abdc.junit5gettingstarted;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * 기본 전략은 각각의 메소드 단위의 테스트 별로 인스턴스를 생성하여 테스트함
 * 별도 옵션을 통해 클래스 단위의 인스턴스 하나로 설정이 가능
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InstanceTest {

    int value = 1;

    @Test
    void create1() {
        System.out.println(this);
        System.out.println(value++);
    }

    @Test
    void create2() {
        System.out.println(this);
        System.out.println(value++);
    }

    @Test
    void create3() {
        System.out.println(this);
        System.out.println(value++);
    }

    @Test
    void create4() {
        System.out.println(this);
        System.out.println(value++);
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    void afterAll() {
        System.out.println("afterAll");
    }
}
