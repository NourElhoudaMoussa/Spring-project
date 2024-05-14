package com.nour.projetspringboot.controller;


import com.nour.projetspringboot.modele.Enseignant;
import com.nour.projetspringboot.modele.Etudiant;

import com.nour.projetspringboot.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/Etudiant/")
@AllArgsConstructor
public class EtudiantController {
    private final EtudiantService etudiantService;//invertion du controle
    @GetMapping("GetAllEtudiant")
    public String all(Model model){
        model.addAttribute("etudiants", etudiantService.readEtudiant());
        return "ListEtudiant";
    }

    @GetMapping("AddNewEtudiant")
    public String afficheFormAddEtudiant() {
        return "AjoutEtudiant";
    }

    @PostMapping("SaveNewEtudiant")
    public String add(Etudiant etudiant) {
        etudiantService.createEtudiant(etudiant);
        return "redirect:/mvc/Etudiant/GetAllEtudiant";
    }

    @GetMapping("deleteEtudiant/{id}")
    public String delete(@PathVariable Long id) {
        etudiantService.DeleteEtudiant(id);
        return "redirect:/mvc/Etudiant/GetAllEtudiant";
    }
    @GetMapping("editEtudiant/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "editEtudiant";
    }

    @PostMapping("updateEtudiant")
    public String update(Etudiant etudiant) {
        etudiantService.updateEtudiant(etudiant.getId(), etudiant);
        return "redirect:/mvc/Etudiant/GetAllEtudiant";
    }
}
