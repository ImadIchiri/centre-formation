package com.codingTech.centreFormation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    @ManyToOne
    private Prospect prospect;
    @ManyToOne
    private Comercial comercial;
    
    public Rdv() {}
    
    public Rdv(String date, Prospect prospect, Comercial comercial) {
        this.date = date;
        this.prospect = prospect;
        this.comercial = comercial;
    }
    
    public Rdv(int id, String date, Prospect prospect, Comercial comercial) {
        this.id = id;
        this.date = date;
        this.prospect = prospect;
        this.comercial = comercial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public Comercial getComercial() {
        return comercial;
    }

    public void setComercial(Comercial comercial) {
        this.comercial = comercial;
    }
    
}
