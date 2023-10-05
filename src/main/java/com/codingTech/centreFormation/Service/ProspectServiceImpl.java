package com.codingTech.centreFormation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Repository.ProspectRepositoryInter;

@Service
public class ProspectServiceImpl implements ProspectServiceInter {
    @Autowired
    ProspectRepositoryInter prospectRepository;
}
