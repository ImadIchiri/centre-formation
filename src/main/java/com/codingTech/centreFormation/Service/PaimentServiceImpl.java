package com.codingTech.centreFormation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Repository.PaimentRepositoryInter;

@Service
public class PaimentServiceImpl implements PaimentServiceInter {
    @Autowired
    PaimentRepositoryInter paimentRepository;
}
