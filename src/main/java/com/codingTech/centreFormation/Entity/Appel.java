package com.codingTech.centreFormation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String commentaire;
    @ManyToOne
    private Prospect prospect;
    @ManyToOne
    private Comercial comercial;
    
    public Appel() {}
    
    public Appel(String commentaire, Prospect prospect, Comercial comercial) {
        this.commentaire = commentaire;
        this.prospect = prospect;
        this.comercial = comercial;
    }
    
    public Appel(int id, String commentaire, Prospect prospect, Comercial comercial) {
        this.id = id;
        this.commentaire = commentaire;
        this.prospect = prospect;
        this.comercial = comercial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
