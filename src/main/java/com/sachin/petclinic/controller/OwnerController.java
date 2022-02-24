package com.sachin.petclinic.controller;

import com.sachin.petclinic.model.Owner;
import com.sachin.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        Set<Owner> ownerList = ownerService.findAll();
        model.addAttribute("owner", ownerList);
        return "owners/index";
    }
}
