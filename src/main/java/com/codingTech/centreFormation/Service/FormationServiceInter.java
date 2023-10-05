package com.codingTech.centreFormation.Service;

import java.util.List;
import java.util.Optional;

import com.codingTech.centreFormation.Entity.Formation;

public interface FormationServiceInter {

    public List<Formation> findAllFormations();

    public Optional<Formation> findFormationById(int id);

    public Formation addFormation(Formation formation);

    public Formation updateFormation(Formation formation);

    public void removeFormation(Formation formation);
    
}
