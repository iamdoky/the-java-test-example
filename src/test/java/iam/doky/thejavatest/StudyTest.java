package iam.doky.thejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 테스트")
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("Create");
    }

    @Test
    @DisplayName("두번쨰 테스트")
    void create_new_study_01() {
        System.out.println("Create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after Each");
    }

}