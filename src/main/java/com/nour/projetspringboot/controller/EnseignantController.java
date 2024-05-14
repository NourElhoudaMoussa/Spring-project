package com.nour.projetspringboot.controller;

import com.nour.projetspringboot.modele.Enseignant;
import com.nour.projetspringboot.service.EnseignantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/Enseignant/")
@AllArgsConstructor
public class EnseignantController {
    private final EnseignantService enseignantService;//invertion du controle
    @GetMapping("GetAllEnseignant")
    public String all(Model model){
        model.addAttribute("enseignants", enseignantService.readEnseignant());
        return "ListEnseignant";
    }

    @GetMapping("AddNewEnseignant")
    public String afficheFormAddEnseignant() {
        return "AjoutEnseignant";
    }

    @PostMapping("SaveNewEnseignant")
    public String add(Enseignant enseignant) {
        enseignantService.createEnseignant(enseignant);
        return "redirect:/mvc/Enseignant/GetAllEnseignant";
    }



    @GetMapping("deleteEnseignant/{id}")
    public String delete(@PathVariable Long id) {
        enseignantService.DeleteEnseignant(id);
        return "redirect:/mvc/Enseignant/GetAllEnseignant";
    }

    @GetMapping("editEnseignant/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        model.addAttribute("enseignant", enseignant);
        return "editEnseignant";
    }

    @PostMapping("updateEnseignant")
    public String update(Enseignant enseignant) {
        enseignantService.updateEnseignant(enseignant.getId(), enseignant);
        return "redirect:/mvc/Enseignant/GetAllEnseignant";
    }
}
