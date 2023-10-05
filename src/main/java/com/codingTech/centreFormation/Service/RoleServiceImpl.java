package com.codingTech.centreFormation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Entity.Role;
import com.codingTech.centreFormation.Enums.RolesEnum;
import com.codingTech.centreFormation.Repository.RoleRepository;

@Service
public class RoleServiceImpl implements  RoleServiceInter{
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles () {
        return roleRepository.findAll();
    }

    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
