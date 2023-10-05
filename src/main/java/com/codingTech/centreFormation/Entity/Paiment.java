package com.codingTech.centreFormation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long amount;

    @ManyToOne
    private Formation formation;

    @ManyToOne
    private Participant participant;
    
    public Paiment() {}
    
    public Paiment(long amount, Formation formation) {
        this.amount = amount;
        this.formation = formation;
    }
    
    public Paiment(int id, long amount, Formation formation) {
        this.id = id;
        this.amount = amount;
        this.formation = formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
    
}
