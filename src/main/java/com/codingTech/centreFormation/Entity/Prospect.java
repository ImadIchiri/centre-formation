package com.codingTech.centreFormation.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Prospect extends Personne {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prospect")
    private Set<Appel> appels = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prospect")
    private Set<Rdv> rdvs = new HashSet<>();

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
