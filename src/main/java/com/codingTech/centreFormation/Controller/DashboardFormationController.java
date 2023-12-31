package com.codingTech.centreFormation.Controller;

import java.util.List;
import java.util.Optional;

import com.codingTech.centreFormation.Entity.Cours;
import com.codingTech.centreFormation.Service.CoursServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingTech.centreFormation.Entity.Formateur;
import com.codingTech.centreFormation.Entity.Formation;
import com.codingTech.centreFormation.Service.FormateurServiceInter;
import com.codingTech.centreFormation.Service.FormationServiceInter;

@RestController
@RequestMapping("/dashboard/formations")
public class DashboardFormationController {
    @Autowired
    FormationServiceInter formationService;

    @Autowired
    CoursServiceInter coursService;

    @Autowired
    FormateurServiceInter formateurService;

    @GetMapping("")
    public List<Formation> getAllFormations() {
        return formationService.findAllFormations();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable("id") int id) {
        Optional<Formation> optFormation = formationService.findFormationById(id);

        if (optFormation.isPresent()) {
            // System.out.println(optFormation.get());
            return new ResponseEntity<>(optFormation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/add")
    public Formation addFormation(@RequestBody Formation formation) {

        return formationService.addFormation(formation);
    }

    @PutMapping("/{id}/edit")
    public Formation editFormation(@PathVariable int id, @RequestBody Formation formation) {
        return formationService.updateFormation(formation);
    }

    @PatchMapping("/{id_formation}/affect/formateur/{id_formateur}")
    public ResponseEntity<Formation> affectFormateurToFormation(
        @PathVariable(name = "id_formation", required = true) int idFormation,
        @PathVariable(name = "id_formateur", required = true) int idFormateur) {
            
            Optional<Formation> optFormation = formationService.findFormationById(idFormation); 
            Optional<Formateur> optFormateur = formateurService.findFormateurById(idFormateur);

            if (optFormation.isPresent() && optFormateur.isPresent()) {
                Formation formation = optFormation.get();
                Formateur formateur = optFormateur.get();

                formation.setFormateur(formateur);

                formationService.updateFormation(formation);

                return new ResponseEntity<>(formation, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("{id_formation}/affect/cours/{id_cours}")
    public ResponseEntity<Formation> affectCoursToFormation(
            @PathVariable(name = "id_formation", required = true) int idFormation,
            @PathVariable(name = "id_cours", required = true) int idCours
    ) {
        Optional<Cours> optCours = coursService.findCoursById(idCours);
        Optional<Formation> optFormation = formationService.findFormationById(idFormation);

        if (optCours.isPresent() && optFormation.isPresent()) {
            Cours cours = optCours.get();
            Formation formation = optFormation.get();

            boolean isCoursExist = cours.getFormations().stream()
                    .anyMatch(item -> item.getId() == cours.getId());

            if (!isCoursExist) {
                cours.getFormations().add(formation);
                coursService.updateCours(cours);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Formation> deleteFormation(@PathVariable(name = "id", required = true) int id) {
        Optional<Formation> optFormation = formationService.findFormationById(id);

        if (optFormation.isPresent()) {
            Formation formation = optFormation.get();

            formationService.removeFormation(formation);
            return new ResponseEntity<>(formation, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
