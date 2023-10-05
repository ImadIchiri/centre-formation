package com.codingTech.centreFormation.Service;

import java.util.List;
import java.util.Optional;

import com.codingTech.centreFormation.Entity.Formateur;

public interface FormateurServiceInter {
    
    public List<Formateur> findAllFormateurs();

    public Optional<Formateur> findFormateurById(int id);

    public Formateur addFormateur(Formateur formateur);

    public Formateur updateFormateur(Formateur formateur);

    public void removeFormateur(Formateur formateur);

}
