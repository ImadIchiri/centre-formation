package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Paiment;

@Repository
public interface PaimentRepositoryInter extends JpaRepository<Paiment, Integer> {
    
}
