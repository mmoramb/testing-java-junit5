package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.exception.ValueNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.jar.JarEntry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {
    IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    //@DisplayName("Test proper view name is returned for index page")
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(),() -> "Another expensive message "
        +"make me only if you have to");
        //using assertjc
        assertThat(indexController.index()).isEqualTo("index");
    }
    @DisplayName("Test exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oupsHandler();
        });
    }
    @Disabled
    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got herencaksnck");
        });
    }
    @Test
    @Disabled
    void setTimeoutPremp(){
        assertTimeoutPreemptively(Duration.ofMillis(100), ()->{
            Thread.sleep(2000);
            System.out.println("I got here will be printed?");
        });
    }

    @Test
    @Disabled
    void testAssumptionTrue(){
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAsAssumptionTure(){
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMAxOS(){

    }
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows(){

    }
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8(){

    }
    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11(){

    }
    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "mmorabautista")
    void testIfUserJT(){

    }
    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "mike")
    void testIfUserFred(){

    }

}