package com.codingTech.centreFormation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Repository.RdvRepositoryInter;

@Service
public class RdvServiceImpl implements RdvServiceInter{
    @Autowired
    RdvRepositoryInter rdvRepository;
}
