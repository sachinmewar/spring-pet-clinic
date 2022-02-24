package com.sachin.petclinic.controller;

import com.sachin.petclinic.model.Vet;
import com.sachin.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/vets")
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"", "/", "/index", "/index.html" })
    public String listVets(Model model){
        Set<Vet> vetList = vetService.findAll();
        model.addAttribute("vet", vetList);
        return "vets/index";
    }
}
