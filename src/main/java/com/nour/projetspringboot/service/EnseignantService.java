package com.nour.projetspringboot.service;



import com.nour.projetspringboot.modele.Enseignant;

import java.util.List;

public interface EnseignantService {
    Enseignant createEnseignant(Enseignant enseignant);
    List<Enseignant> readEnseignant();
    Enseignant updateEnseignant(Long id,Enseignant enseignant);
    String DeleteEnseignant(Long id);
}
