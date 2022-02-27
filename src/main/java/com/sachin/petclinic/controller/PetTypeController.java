package com.sachin.petclinic.controller;

import com.sachin.petclinic.model.PetType;
import com.sachin.petclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping("/petType")
@Controller
public class PetTypeController {

    private final PetTypeService petTypeService;

    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @GetMapping({ "" , "/"})
    @ResponseBody
    public Set<PetType> getPetType(){
        return petTypeService.findAll();
    }
}
