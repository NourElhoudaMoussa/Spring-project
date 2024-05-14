package com.nour.projetspringboot.controller;

import com.nour.projetspringboot.modele.Enseignant;
import com.nour.projetspringboot.modele.Formation;
import com.nour.projetspringboot.service.EnseignantService;
import com.nour.projetspringboot.service.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/Formation/")
@AllArgsConstructor
public class FormationController {

    private final FormationService formationService;
    private final EnseignantService enseignantService;
    @GetMapping("GetAllFormation")
    public String all(Model model){
        model.addAttribute("formations", formationService.readFormation());
        //pour remplire la liste de filtrage par enseignant
        model.addAttribute("enseignants",enseignantService.readEnseignant());
        return "ListFormation";
    }

    @GetMapping("AddNewFormation")
    public String afficheFormAddEnseignant(Model model) {
        model.addAttribute("enseignants",enseignantService.readEnseignant());
        return "AjoutFormation";
    }

    @PostMapping("SaveNewFormation")
    public String add(Formation formation) {
        formationService.createFormation(formation);
        return "redirect:/mvc/Formation/GetAllFormation";
    }
    @GetMapping("deleteFormation/{id}")
    public String delete(@PathVariable Long id) {
        formationService.DeleteFormation(id);
        return "redirect:/mvc/Formation/GetAllFormation";
    }
    @GetMapping("editFormation/{id}")
    public String editFormation(@PathVariable Long id, Model model) {
        Formation formation = formationService.getFormationById(id);
        model.addAttribute("formation", formation);
        model.addAttribute("enseignants", enseignantService.readEnseignant());
        return "editFormation";
    }
    @PostMapping("updateFormation")
    public String updateFormation(Formation formation) {
        formationService.updateFormation(formation.getId(), formation);
        return "redirect:/mvc/Formation/GetAllFormation";
    }
}
