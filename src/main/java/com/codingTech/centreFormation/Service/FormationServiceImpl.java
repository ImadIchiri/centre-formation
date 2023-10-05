package com.codingTech.centreFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Entity.Formation;
import com.codingTech.centreFormation.Repository.FormationRepositoryInter;

@Service
public class FormationServiceImpl implements FormationServiceInter {
    @Autowired
    FormationRepositoryInter formationRepository;

    public List<Formation> findAllFormations() {
        return formationRepository.findAll();
    }

    public Optional<Formation> findFormationById(int id) {
        return formationRepository.findById(id);
    }

    public Formation addFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public Formation updateFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public void removeFormation(Formation formation) {
        formationRepository.delete(formation);
    }

}
