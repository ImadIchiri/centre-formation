package com.codingTech.centreFormation.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private long price;
    private long amountToPay;
    private String bannerPath;
    private String dateDebut;
    private String dateFin;
    private int maxNombreParticipant;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_formateur")
    @JsonBackReference
    private Formateur formateur;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Cours> courses = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Participant> participants = new HashSet<>();

    @OneToMany(mappedBy = "formation")
    private Set<Paiment> paiments = new HashSet<>();
    
    public Formation() {}
    
    public Formation(String title, String description, long price, long amountToPay, String bannerPath, String dateDebut,
            String dateFin, int maxNombreParticipant, Formateur formateur) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.amountToPay = amountToPay;
        this.bannerPath = bannerPath;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.maxNombreParticipant = maxNombreParticipant;
        this.formateur = formateur;
    }
    
    public Formation(int id, String title, String description, long price, long amountToPay, String bannerPath, String dateDebut,
            String dateFin, int maxNombreParticipant, Formateur formateur) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.amountToPay = amountToPay;
        this.bannerPath = bannerPath;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.maxNombreParticipant = maxNombreParticipant;
        this.formateur = formateur;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(long amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getMaxNombreParticipant() {
        return maxNombreParticipant;
    }

    public void setMaxNombreParticipant(int maxNombreParticipant) {
        this.maxNombreParticipant = maxNombreParticipant;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Set<Cours> getCourses() {
        return courses;
    }

    public void setCourses(Set<Cours> courses) {
        this.courses = courses;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }


    public Set<Paiment> getPaiments() {
        return paiments;
    }

    public void setPaiments(Set<Paiment> paiments) {
        this.paiments = paiments;
    }
}
