package com.codingTech.centreFormation.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String path;

    @JsonManagedReference
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Formation> formations = new HashSet<>();

    public Cours() {}
   
    public Cours(String title, String description, String path) {
        this.title = title;
        this.description = description;
        this.path = path;
    }
    
    public Cours(int id, String title, String description, String path) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.path = path;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
    public Set<Formation> getFormations() {
        return formations;
    }
    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

}
