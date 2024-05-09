package com.nour.projetspringboot.controller;

import com.nour.projetspringboot.modele.Enseignant;
import com.nour.projetspringboot.service.EnseignantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Enseignant")
@AllArgsConstructor
public class EnseignantRestController {
    private final EnseignantService enseignantService;//invertion du controle

    @PostMapping("/createTeacher")
    public Enseignant createTeacher(@RequestBody Enseignant enseignant){
        return enseignantService.createEnseignant(enseignant);
    }

    @GetMapping("/getAllTeachers")
    public List<Enseignant> getAllTeachers(){
        return enseignantService.readEnseignant();
    }

    @PutMapping("/updateTeacher/{id}")//envoyer l'id comme variable
    public Enseignant updateTeacher(@PathVariable Long id,@RequestBody Enseignant enseignant){
        return enseignantService.updateEnseignant(id,enseignant);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable Long id){
        return enseignantService.DeleteEnseignant(id);
    }
}
