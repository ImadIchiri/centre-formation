package com.codingTech.centreFormation.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Comercial extends User {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comercial")
    private Set<Appel> appels = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Rdv> rdvs = new HashSet<>();

    public Comercial() {
        super();
    }

    public Comercial(String nom, String prenom, String email, String numeroTel, String username, String password,
    Set<Role> role) {
        super(nom, prenom, email, numeroTel, username, password, role);
    }

    public Comercial(int id, String nom, String prenom, String email, String numeroTel, String username, String password,
        Set<Role> role) {
         super(id, nom, prenom, email, numeroTel, username, password, role);
    }

    public Set<Appel> getAppels() {
        return appels;
    }

    public void setAppels(Set<Appel> appels) {
        this.appels = appels;
    }

    public Set<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(Set<Rdv> rdvs) {
        this.rdvs = rdvs;
    }
    
    
}
