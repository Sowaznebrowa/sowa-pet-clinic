package com.sowaznebrowa.sowapetclinic.bootstrap;

import com.sowaznebrowa.sowapetclinic.model.Owner;
import com.sowaznebrowa.sowapetclinic.model.Vet;
import com.sowaznebrowa.sowapetclinic.services.OwnerService;
import com.sowaznebrowa.sowapetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gienanme");
        ownerService.save(owner2);

        System.out.println("Load Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mariano");
        vet2.setLastName("Veterinario");
        vetService.save(vet2);

        System.out.println("Load Vets....");
    }
}
