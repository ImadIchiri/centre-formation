package com.codingTech.centreFormation.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingTech.centreFormation.Entity.Formateur;
import com.codingTech.centreFormation.Entity.Role;
import com.codingTech.centreFormation.Enums.RolesEnum;
import com.codingTech.centreFormation.Service.FormateurServiceImpl;
import com.codingTech.centreFormation.Service.RoleServiceImpl;

@RestController
@RequestMapping("/dashboard/formateurs")
public class DashboardFormateurController {
    @Autowired
    FormateurServiceImpl formateurService;
    
    @Autowired
    RoleServiceImpl roleServiceImple;

    @GetMapping("")
    public List<Formateur> getAllFormateurs() {
        return formateurService.findAllFormateurs();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable("id") int id) {
        Optional<Formateur> optFormateur = formateurService.findFormateurById(id);

        if (optFormateur.isPresent()) {
            return new ResponseEntity<>(optFormateur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/add")
    public Formateur addFormateur(@RequestBody Formateur formateur) {
        Set<Role> roles = new HashSet<>();

        Role formateurRole = roleServiceImple.findByRole(RolesEnum.FORMATEUR.name());

        roles.add(formateurRole);

        formateur.setRole(roles);

        return formateurService.addFormateur(formateur);
    }

    @PutMapping("/{id}/edit")
    public Formateur editFormateur(@PathVariable int id, @RequestBody Formateur formateur) {
        return formateurService.updateFormateur(formateur);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Formateur> deleteFormateur(@PathVariable(name = "id", required = true) int id) {
        Optional<Formateur> optFormateur = formateurService.findFormateurById(id);

        if (optFormateur.isPresent()) {
            Formateur formateur = optFormateur.get();

            formateurService.removeFormateur(formateur);
            return new ResponseEntity<>(formateur, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
