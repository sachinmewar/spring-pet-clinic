package com.sachin.petclinic.service;


import com.sachin.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}
