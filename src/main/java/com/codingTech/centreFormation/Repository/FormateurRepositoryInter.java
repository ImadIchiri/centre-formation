package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Formateur;

@Repository
public interface FormateurRepositoryInter extends JpaRepository<Formateur, Integer> {
    
}
