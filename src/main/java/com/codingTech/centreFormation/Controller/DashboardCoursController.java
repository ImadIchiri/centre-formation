package com.codingTech.centreFormation.Controller;

import com.codingTech.centreFormation.Entity.Cours;
import com.codingTech.centreFormation.Entity.Formateur;
import com.codingTech.centreFormation.Entity.Role;
import com.codingTech.centreFormation.Enums.RolesEnum;
import com.codingTech.centreFormation.Service.CoursServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/dashboard/cours")
public class DashboardCoursController {
    @Autowired
    CoursServiceInter coursService;

    @GetMapping("")
    public List<Cours> getAllCourses() {
        return coursService.findAllCours();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@RequestParam(name = "id", required = true) int id) {
        Optional<Cours> optCours = coursService.findCoursById(id);

        return optCours.map(cours -> new ResponseEntity<>(cours, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours) {
        // Path Format: 'main_path/formateur_name/cours_name/cours_id'

        return coursService.addCours(cours);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Cours> editCours(@PathVariable int id, @RequestBody Cours cours) {
        Optional<Cours> optCours = coursService.findCoursById((id));

        if (optCours.isPresent()) {
            if (optCours.get().getId() == cours.getId()) {
                coursService.updateCours(cours);
                return new ResponseEntity<>(cours, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Cours> deleteCour(@PathVariable(name = "id", required = true) int id) {
        Optional<Cours> optCours = coursService.findCoursById(id);

        if (optCours.isPresent()) {
            Cours cours = optCours.get();

            coursService.removeCours(cours);
            return new ResponseEntity<>(cours, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
