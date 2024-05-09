package com.nour.projetspringboot.repository;

import com.nour.projetspringboot.modele.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormtionRepository extends JpaRepository<Formation, Long> {
}
