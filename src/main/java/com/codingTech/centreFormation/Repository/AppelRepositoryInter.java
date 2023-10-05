package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Appel;

@Repository
public interface AppelRepositoryInter extends JpaRepository<Appel, Integer> {
    
}