package com.nour.projetspringboot.controller;


import com.nour.projetspringboot.modele.Formation;
import com.nour.projetspringboot.service.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Formation")
@AllArgsConstructor
public class FormationRestController {
    private final FormationService formationService;//invertion du controle

    @PostMapping("/createCourse")
    public Formation createCourse(@RequestBody Formation formation){
        return formationService.createFormation(formation);
    }
    @GetMapping("/getAllCourses")
    public List<Formation> getAllCourses(){
        return formationService.readFormation();
    }

    @PutMapping("/updateCourse/{id}")//envoyer l'id comme variable
    public Formation updateCourse(@PathVariable Long id,@RequestBody Formation formation){
        return formationService.updateFormation(id,formation);
    }
    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id){
        return formationService.DeleteFormation(id);
    }
}
