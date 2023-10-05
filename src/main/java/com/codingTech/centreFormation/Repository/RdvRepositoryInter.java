package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Rdv;

@Repository
public interface RdvRepositoryInter extends JpaRepository<Rdv, Integer> {
    
}
