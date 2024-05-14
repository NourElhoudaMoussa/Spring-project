package com.nour.projetspringboot.service;


import com.nour.projetspringboot.modele.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant createEtudiant(Etudiant etudiant);
    List<Etudiant> readEtudiant();
    Etudiant updateEtudiant(Long id,Etudiant etudiant);
    String DeleteEtudiant(Long id);
    Etudiant getEtudiantById(Long id);
}
