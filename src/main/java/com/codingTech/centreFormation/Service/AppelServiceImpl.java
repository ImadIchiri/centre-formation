package com.codingTech.centreFormation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Repository.AppelRepositoryInter;

@Service
public class AppelServiceImpl implements AppelServiceInter{
    @Autowired
    AppelRepositoryInter appelRepository;
}
