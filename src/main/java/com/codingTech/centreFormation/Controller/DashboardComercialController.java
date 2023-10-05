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

import com.codingTech.centreFormation.Entity.Comercial;
import com.codingTech.centreFormation.Entity.Role;
import com.codingTech.centreFormation.Enums.RolesEnum;
import com.codingTech.centreFormation.Service.ComercialServiceImpl;
import com.codingTech.centreFormation.Service.RoleServiceImpl;

@RestController
@RequestMapping("/dashboard/comerciaux")
public class DashboardComercialController {
    @Autowired
    ComercialServiceImpl comercialService;
    
    @Autowired
    RoleServiceImpl roleServiceImple;

    @GetMapping("")
    public List<Comercial> getAllComercials() {
        return comercialService.findAllComercials();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Comercial> getComercialById(@PathVariable("id") int id) {
        Optional<Comercial> optComercial = comercialService.findComercialById(id);

        if (optComercial.isPresent()) {
            return new ResponseEntity<>(optComercial.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/add")
    public Comercial addComercial(@RequestBody Comercial comercial) {
        Set<Role> roles = new HashSet<>();

        Role ComercialRole = roleServiceImple.findByRole(RolesEnum.COMERCIAL.name());

        roles.add(ComercialRole);

        comercial.setRole(roles);

        return comercialService.addComercial(comercial);
    }

    @PutMapping("/{id}/edit")
    public Comercial editComercial(@PathVariable int id, @RequestBody Comercial comercial) {
        return comercialService.updateComercial(comercial);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Comercial> deleteCoimercial(@PathVariable(name = "id", required = true) int id) {
        Optional<Comercial> optComercial = comercialService.findComercialById(id);

        if (optComercial.isPresent()) {
            Comercial comercial = optComercial.get();

            comercialService.removeComercial(comercial);
            return new ResponseEntity<>(comercial, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
