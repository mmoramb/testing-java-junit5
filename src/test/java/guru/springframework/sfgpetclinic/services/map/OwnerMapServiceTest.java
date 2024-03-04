package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("first before each");
    }

    @DisplayName("Verify Zero owners")
    @Test
    void ownersAreZero(){
        int ownerCount = ownerMapService.findAll().size();
        assertEquals(0, ownerCount);
    }

    @DisplayName("Pet Type -")
    @Nested
    class TestCreatePetTypes{
        @BeforeEach
        void setUp(){
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("Nested before each");
        }

        @Test
        void testPetCount(){
            int petTypeCount = petTypeService.findAll().size();
            assertEquals(2, petTypeCount);
        }

        @DisplayName("Save owners test -")
        @Nested
        class SaveOwnersTest{
            @BeforeEach
            void setUp(){
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("saved owners before each");
            }

            @Test
            void saveOwner(){
                Owner owner = new Owner(1L, "Joe", "Buck");

                Owner savedOwner = ownerMapService.save(owner);
                assertNotNull(savedOwner);
            }

            @DisplayName("save owners test - ")
            @Nested
            class FindOwnersTest{
                @DisplayName("Find Owner")
                @Test
                void findOwner(){
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertNotNull(foundOwner);
                }

                @DisplayName("find owner not found")
                @Test
                void findOwnerNotFound(){
                    Owner foundOwner = ownerMapService.findById(2L);
                    assertNull(foundOwner);
                }
            }
        }
    }

    @DisplayName("verify still zero owners")
    @Test
    void ownersAreStillZero(){
        int ownerCount = ownerMapService.findAll().size();
        assertEquals(0, ownerCount);
    }
}