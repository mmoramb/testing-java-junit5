package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controllers")
public interface ControllerTests{
    @BeforeAll
    default void beforeAll(){
        System.out.println("lets do something here");
    }


}
