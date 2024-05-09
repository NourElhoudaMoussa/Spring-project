package com.nour.projetspringboot.repository;

import com.nour.projetspringboot.modele.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
