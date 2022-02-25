package com.sachin.petclinic.bootstrap;

import com.sachin.petclinic.model.Owner;
import com.sachin.petclinic.model.Vet;
import com.sachin.petclinic.service.OwnerService;
import com.sachin.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Qualifier;
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
        owner1.setFirstName("Sachin");
        owner1.setLastName("Mewar");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("James");
        owner2.setLastName("Gosling");

        ownerService.save(owner2);

        System.out.println("Bootstrapped owner....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ankit");
        vet1.setLastName("Mehra");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ayush");
        vet2.setLastName("Bijalwan");

        vetService.save(vet2);

        System.out.println("Bootstrapped vet....");
    }
}
