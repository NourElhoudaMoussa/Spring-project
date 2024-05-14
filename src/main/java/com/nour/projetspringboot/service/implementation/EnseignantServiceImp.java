package com.nour.projetspringboot.service.implementation;

import com.nour.projetspringboot.modele.Enseignant;
import com.nour.projetspringboot.repository.EnseignantRepository;
import com.nour.projetspringboot.repository.EtudiantRepository;
import com.nour.projetspringboot.service.EnseignantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EnseignantServiceImp implements EnseignantService {
    private final EnseignantRepository enseignantRepository;//injection des dependances
    @Override
    public Enseignant createEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public List<Enseignant> readEnseignant() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant updateEnseignant(Long id, Enseignant enseignant) {

        return enseignantRepository.findById(id)
                .map(ens->{
                    ens.setPrenom(enseignant.getPrenom());
                    ens.setNom(enseignant.getNom());
                    ens.setEmail(enseignant.getEmail());
                    ens.setTel(enseignant.getTel());
                    return enseignantRepository.save(ens);
                }).orElseThrow(()->new RuntimeException("Enseignant non trouvé!!"));
    }
    @Override
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé!!"));
    }


    @Override
    public String DeleteEnseignant(Long id){
        enseignantRepository.deleteById(id);
        return "Enseignant supprimé avec succées";
    }
}
