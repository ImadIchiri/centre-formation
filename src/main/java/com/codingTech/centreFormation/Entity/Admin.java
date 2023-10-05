package com.codingTech.centreFormation.Entity;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
    public Admin(String nom, String prenom, String email, String numeroTel, String username, String password,
    Set<Role> role) {
        super(nom, prenom, email, numeroTel, username, password, role);
    }

    public Admin(int id, String nom, String prenom, String email, String numeroTel, String username, String password,
        Set<Role> role) {
         super(id, nom, prenom, email, numeroTel, username, password, role);
    }
}
