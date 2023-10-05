package com.codingTech.centreFormation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Repository.ParticipantRepositoryInter;

@Service
public class ParticipantServiceImpl implements ParticipantServiceInter {
    @Autowired
    ParticipantRepositoryInter participantRepository;
}
