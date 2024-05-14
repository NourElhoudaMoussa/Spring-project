package com.nour.projetspringboot.service;



import com.nour.projetspringboot.modele.Formation;

import java.util.List;

public interface FormationService {

    Formation createFormation(Formation formation);
    List<Formation> readFormation();
    Formation updateFormation(Long id,Formation formation);
    String DeleteFormation(Long id);
    Formation getFormationById(Long id);
}
