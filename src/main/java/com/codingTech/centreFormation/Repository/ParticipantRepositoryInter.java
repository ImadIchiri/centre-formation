package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Participant;

@Repository
public interface ParticipantRepositoryInter extends JpaRepository<Participant, Integer>{
    
}
