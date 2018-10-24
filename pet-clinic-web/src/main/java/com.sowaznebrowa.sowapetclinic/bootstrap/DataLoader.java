package com.sowaznebrowa.sowapetclinic.bootstrap;

import com.sowaznebrowa.sowapetclinic.model.Owner;
import com.sowaznebrowa.sowapetclinic.model.PetType;
import com.sowaznebrowa.sowapetclinic.model.Vet;
import com.sowaznebrowa.sowapetclinic.services.OwnerService;
import com.sowaznebrowa.sowapetclinic.services.PetTypeService;
import com.sowaznebrowa.sowapetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName( "Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Load PetTypes....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gienanme");
        ownerService.save(owner2);

        System.out.println("Load Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mariano");
        vet2.setLastName("Veterinario");
        vetService.save(vet2);

        System.out.println("Load Vets....");
    }
}
