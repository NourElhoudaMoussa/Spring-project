package com.nour.projetspringboot.service.implementation;

import com.nour.projetspringboot.modele.Formation;
import com.nour.projetspringboot.repository.FormtionRepository;
import com.nour.projetspringboot.service.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FormationServiceImp implements FormationService {
    private final FormtionRepository formtionRepository;//injection des dependances

    @Override
    public Formation createFormation(Formation formation) {
        return formtionRepository.save(formation);
    }
    @Override
    public List<Formation> readFormation() {
        return formtionRepository.findAll();
    }

    @Override
    public Formation updateFormation(Long id, Formation formation) {

        return formtionRepository.findById(id)
                .map(f->{
                    f.setTitre(formation.getTitre());
                    f.setDescription(formation.getDescription());
                    f.setPrix(formation.getPrix());
                    f.setNbrHeures(formation.getNbrHeures());
                    f.setEnseignant(formation.getEnseignant());
                    return formtionRepository.save(f);
                }).orElseThrow(()->new RuntimeException("Formation non trouvé!!"));

    }

    @Override
    public String DeleteFormation(Long id) {

        formtionRepository.deleteById(id);
        return "Formation supprimé avec succées";
    }
}
