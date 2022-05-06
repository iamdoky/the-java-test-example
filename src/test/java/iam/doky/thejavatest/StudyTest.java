package iam.doky.thejavatest;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// @ExtendWith(FindSlowTestExtension.class)        // 선언적으로 사용
class StudyTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @FastTest
    void create_new_study() {
        Study actual = new Study(100);
        assertThat( actual.limit()).isGreaterThan(0);
    }

    @SlowTest
    @DisplayName("두번쨰 테스트 slow ")
    //@Tag("slow")
    //@Disabled
    void create_new_study_01() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("Create1");
    }

    @DisplayName("스터디 만들기")
    @RepeatedTest( value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}" )
    void create_study( RepetitionInfo repetitionInfo ) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions() );
    }

    @DisplayName("스터디 만들기2")
    @ParameterizedTest( name = "{index} {displayName} message {0}" )
    @ValueSource( strings = {"날씨가", "많이", "추워지고", "있다." } )
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @DisplayName("스터디 만들기3")
    @ParameterizedTest( name = "{index} {displayName} message {0}" )
    //@ValueSource( ints = {10, 20, 40})
    @CsvSource({"10, '자바'", "20, '스프링'", "40,'파이썬'"})
    /*void parameterTest(@ConvertWith(StudyConvertor.class) Study study ) {*/
    /*void parameterTest(Integer limit, String name  ) {*/
    /*void parameterTest(ArgumentsAccessor argumentsAccessor ) {*/
    void parameterTest( @AggregateWith(StudyAggregator.class) Study study ) {
        /*Study study = new Study(argumentsAccessor.getInteger(0),argumentsAccessor.getString(1));*/
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0),argumentsAccessor.getString(1));
        }
    }

    // 하나의 Agurmernt 를 받알때
    static class StudyConvertor extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targerType) throws ArgumentConversionException {
            assertEquals("Can only covert to Study", Study.class, targerType);
            return new Study(Integer.parseInt(source.toString()));
        }
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