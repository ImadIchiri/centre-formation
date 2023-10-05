package com.codingTech.centreFormation.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Participant extends User {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Formation> formations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "paiments")
    private Set<Paiment> paiments = new HashSet<>();

    public Participant(String nom, String prenom, String email, String numeroTel, String username, String password,
    Set<Role> role) {
        super(nom, prenom, email, numeroTel, username, password, role);
    }

    public Participant(int id, String nom, String prenom, String email, String numeroTel, String username, String password,
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
