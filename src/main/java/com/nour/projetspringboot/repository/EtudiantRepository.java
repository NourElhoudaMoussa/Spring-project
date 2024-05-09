package com.nour.projetspringboot.repository;

import com.nour.projetspringboot.modele.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
