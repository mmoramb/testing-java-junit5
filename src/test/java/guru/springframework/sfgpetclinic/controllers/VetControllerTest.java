package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import guru.springframework.sfgpetclinic.services.springdatajpa.VetSDJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {
    private VetController vetController;
    private SpecialtyService specialtyService;
    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        VetService vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet = new Vet(1l, "mike", "mora", null);
        Vet vet2 = new Vet(2l, "john", "doe", null);

        vetService.save(vet);
        vetService.save(vet2);
    }
    @Test
    void validateReturnTheCorrectView() {
        Model model = new ModelImpl();
        assertEquals("vets/index", vetController.listVets(model));

        Set moduleAtt = (Set) ((ModelImpl) model).getMap().get("vets");
        assertEquals(2, moduleAtt.size());
    }
}