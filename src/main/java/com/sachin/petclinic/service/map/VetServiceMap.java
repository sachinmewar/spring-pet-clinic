package com.sachin.petclinic.service.map;


import com.sachin.petclinic.model.Speciality;
import com.sachin.petclinic.model.Vet;
import com.sachin.petclinic.service.SpecialityService;
import com.sachin.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialities().size() >= 0 ){
                object.getSpecialities().forEach( speciality -> {
                    if(speciality.getId() == null){
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        }
        return null;
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
