package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Formation;

@Repository
public interface FormationRepositoryInter extends JpaRepository<Formation, Integer> {
    
}