package com.sachin.petclinic.bootstrap;

import com.sachin.petclinic.model.*;
import com.sachin.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        Speciality surgeon = new Speciality();
        surgeon.setDescription("Surgeon");
        Speciality savedSurgeon = specialityService.save(surgeon);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("....Bootstrapped PetType....");

        PetType petType1 = new PetType();
        petType1.setName("Dog");

        petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Bird");

        petTypeService.save(petType2);


        System.out.println("....Bootstrapped owner....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Sachin");
        owner1.setLastName("Mewar");
        owner1.setAddress("Near Gas Godam, Srikot");
        owner1.setCity("Srinagar");

        Pet pet1 = new Pet();
        pet1.setPetType(petType1);
        pet1.setOwner(owner1);
        pet1.setPetType(petType1);
        pet1.setName("Simba");
        Pet savedPet1 = petService.save(pet1);

        owner1.getPets().add(savedPet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("James");
        owner2.setLastName("Gosling");
        owner2.setAddress("Madhur Vihar, Phase 1 Lane 5 near Beangali Kothi, Ajabpur");
        owner2.setCity("Dehradun");

        Pet pet2 = new Pet();
        pet2.setPetType(petType2);
        pet2.setOwner(owner2);
        pet2.setPetType(petType2);
        pet2.setName("Mithu");
        Pet savedPet2 = petService.save(pet2);
        owner2.getPets().add(savedPet2);

        ownerService.save(owner2);

        System.out.println("....Bootstrapped vet....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ankit");
        vet1.setLastName("Mehra");
        vet1.getSpecialities().add(savedSurgeon);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ayush");
        vet2.setLastName("Bijalwan");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);
    }
}
