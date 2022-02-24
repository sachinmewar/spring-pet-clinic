package com.sachin.petclinic.bootstrap;

import com.sachin.petclinic.model.Owner;
import com.sachin.petclinic.model.Vet;
import com.sachin.petclinic.service.map.OwnerServiceMap;
import com.sachin.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;

    public DataLoader() {
        ownerServiceMap = new OwnerServiceMap();
        vetServiceMap = new VetServiceMap();
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sachin");
        owner1.setLastName("Mewar");

        ownerServiceMap.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("James");
        owner2.setLastName("Gosling");

        ownerServiceMap.save(owner2);

        System.out.println("Bootstrapped owner....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ankit");
        vet1.setLastName("Mehra");

        vetServiceMap.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ayush");
        vet2.setLastName("Bijalwan");

        vetServiceMap.save(vet2);

        System.out.println("Bootstrapped vet....");
    }
}
