package guru.springframework.sfgpetclinic.model;

import guru.springframework.ModelTests;
import guru.springframework.sfgpetclinic.ModelRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTests implements ModelRepeatedTest {
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} : {totalRepetitions}")
    @DisplayName("My repeated test")
    void myRepeatedTest(){
        //
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+ " : "+repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("my custom test")
    void myCustomRepeatedTest(){

    }
}
