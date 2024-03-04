package guru.springframework.sfgpetclinic.model;

import guru.springframework.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests{
    @Test
    void grouppedAssertions(){
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void grouppedAssertionsMsgs(){
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe", "first name failed"),
                () -> assertEquals(person.getLastName(), "Buck", "las name failed"));
    }


}