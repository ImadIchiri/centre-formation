package com.codingTech.centreFormation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingTech.centreFormation.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRole(String role);
}
