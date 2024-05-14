package com.nour.projetspringboot.service.implementation;

import com.nour.projetspringboot.modele.Enseignant;
import com.nour.projetspringboot.modele.Etudiant;
import com.nour.projetspringboot.repository.EtudiantRepository;
import com.nour.projetspringboot.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EtudiantServiceImp implements EtudiantService {
    private final EtudiantRepository etudiantRepository;//injection des dependances
    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> readEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        return etudiantRepository.findById(id)
                .map(e->{
                    e.setPrenom(etudiant.getPrenom());
                    e.setNom(etudiant.getNom());
                    e.setAdr(etudiant.getAdr());
                    e.setEmail(etudiant.getEmail());
                    e.setTel(etudiant.getTel());
                    return etudiantRepository.save(e);
        }).orElseThrow(()->new RuntimeException("Etudiant non trouvé!!"));
    }
    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé!!"));
    }
    @Override
    public String DeleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
        return "Etudiant supprimé avec succées";
    }
}
