package com.sachin.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

    private String name;
    private PetType petType;
    private LocalDate birthData;
    private Owner owner;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthData() {
        return birthData;
    }

    public void setBirthData(LocalDate birthData) {
        this.birthData = birthData;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
