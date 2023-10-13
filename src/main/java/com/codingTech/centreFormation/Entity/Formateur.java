package com.codingTech.centreFormation.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Formateur extends User {
    @JsonManagedReference
    @OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Formation> formations = new HashSet<>();

    public Formateur() {
        super();
    }

    public Formateur(String nom, String prenom, String email, String numeroTel, String username, String password,
    Set<Role> role) {
        super(nom, prenom, email, numeroTel, username, password, role);
    }

    public Formateur(int id, String nom, String prenom, String email, String numeroTel, String username, String password,
    Set<Role> role) {
         super(id, nom, prenom, email, numeroTel, username, password, role);
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

}
