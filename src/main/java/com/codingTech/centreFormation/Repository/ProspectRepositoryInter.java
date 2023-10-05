package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Prospect;

@Repository
public interface ProspectRepositoryInter extends JpaRepository<Prospect, Integer> {
    
}
