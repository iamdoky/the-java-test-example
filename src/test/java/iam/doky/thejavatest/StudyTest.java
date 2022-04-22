package iam.doky.thejavatest;

import org.junit.jupiter.api.*;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 테스트")
    void create_new_study() {
        Study study = new Study( -10 );
        assertNotNull(study);
        assertEquals( StudyStatus.DRAFT,study.getStatus(),
                () -> "스터디를 처음 만들면 상태값은" + StudyStatus.DRAFT +  "여야 한다." );
        assertTrue( study.limit() > 0 , "스터디 최대 참석 인원은 0보다 커야 한데.. 왜..? ");
        // assertEquals( StudyStatus.DRAFT,study.getStatus(), () -> "스터디를 처음 만들면 상태값은 DRAFT 여야 한다." );      -->  람다를 사용

        /*
        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {     --> Supplier 를 사용함 -> () 람다형태로 변형가능
            @Override
            public String get() {
                return "스터디를 처음 만들면 상태값은 DRAFT 여야 한다.";
            }
        });
        */

        // System.out.println("Create");
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