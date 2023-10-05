package com.codingTech.centreFormation.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User extends Personne {
    @Column(unique = true)
    private String username;
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles")
    private Set<Role> role = new HashSet<>();

    public User () {
        super();
    }
    
    public User(String nom, String prenom, String email, String numeroTel, String username, String password,
            Set<Role> role) {
        super(nom, prenom, email, numeroTel);
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public User(int id, String nom, String prenom, String email, String numeroTel, String username, String password,
            Set<Role> role) {
        super(id, nom, prenom, email, numeroTel);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

}
