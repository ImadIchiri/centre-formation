package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Cours;

@Repository
public interface CoursRepositoryInter extends JpaRepository<Cours, Integer>{
    
}