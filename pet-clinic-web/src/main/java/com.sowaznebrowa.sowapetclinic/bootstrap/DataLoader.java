package com.sowaznebrowa.sowapetclinic.bootstrap;

import com.sowaznebrowa.sowapetclinic.model.*;
import com.sowaznebrowa.sowapetclinic.services.OwnerService;
import com.sowaznebrowa.sowapetclinic.services.PetTypeService;
import com.sowaznebrowa.sowapetclinic.services.SpecialityService;
import com.sowaznebrowa.sowapetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0 ) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName( "Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Load PetTypes....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);
        System.out.println("Load Specialities....");


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType((savedDogPetType));
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        mikesPet.setName("Reksio");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gienanme");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasPet = new Pet();
        fionasPet.setPetType((savedCatPetType));
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setOwner(owner2);
        fionasPet.setName("Fuks");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Load Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mariano");
        vet2.setLastName("Veterinario");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Load Vets....");
    }
}
