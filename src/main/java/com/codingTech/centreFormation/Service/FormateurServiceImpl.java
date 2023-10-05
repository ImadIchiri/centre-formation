package com.codingTech.centreFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Entity.Formateur;
import com.codingTech.centreFormation.Repository.FormateurRepositoryInter;

@Service
public class FormateurServiceImpl implements FormateurServiceInter {
    @Autowired
    FormateurRepositoryInter formateurRepository;

    public List<Formateur> findAllFormateurs() {
        return formateurRepository.findAll();
    }

    public Optional<Formateur> findFormateurById(int id) {
        return formateurRepository.findById(id);
    }

    public Formateur addFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public Formateur updateFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public void removeFormateur(Formateur formateur) {
        formateurRepository.delete(formateur);
    }


}
