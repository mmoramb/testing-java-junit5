package guru.springframework.sfgpetclinic.model;

import guru.springframework.ModelTests;
import guru.springframework.sfgpetclinic.CustomArgsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class OwnerTest implements ModelTests {
    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                ()->
                    assertAll("Person Properties",
                            () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                            () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(),"City did not match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));
        //not loading hamcrest objects
        //assertThat(owner.getCity(), is("Key West"));
    }
    @DisplayName("value source test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring","Framework","Guru"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("Enum source test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("CSV input test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,1,1"
    })
    void csvInputTest(String name, int val1, int val2){
        System.out.println(name +" = "+val1+" : "+ val2);
    }

    @DisplayName("CSV file test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvTestFromFile(String name, int val1, int val2){
        System.out.println(name +" = "+val1+" : "+ val2);
    }

    @DisplayName("CSV file test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getargs")
    void fromMethodTest(String name, int val1, int val2){
        System.out.println(name +" = "+val1+" : "+ val2);
    }
    static Stream<Arguments> getargs(){
        return Stream.of(Arguments.of("FL",1,1),
                Arguments.of("OH",2,2),
                Arguments.of("MI",1,1));
    }

    @DisplayName("Custom Provider test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void customProviderTest(String name, int val1, int val2){
        System.out.println(name +" = "+val1+" : "+ val2);
    }
}