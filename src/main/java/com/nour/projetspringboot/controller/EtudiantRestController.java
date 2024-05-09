package com.nour.projetspringboot.controller;

import com.nour.projetspringboot.modele.Etudiant;
import com.nour.projetspringboot.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
@AllArgsConstructor
public class EtudiantRestController {
    private final EtudiantService etudiantService;//invertion du controle

    @PostMapping("/createStudent")
    public Etudiant createStudent(@RequestBody Etudiant etudiant){
        return etudiantService.createEtudiant(etudiant);
    }
    @GetMapping("/getAllStudents")
    public List<Etudiant> getAllStudents(){
        return etudiantService.readEtudiant();
    }
    @PutMapping("/updateStudent/{id}")//envoyer l'id comme variable
    public Etudiant updateStudent(@PathVariable Long id,@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        return etudiantService.DeleteEtudiant(id);
    }
}
