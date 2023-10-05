package com.codingTech.centreFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Entity.Comercial;
import com.codingTech.centreFormation.Repository.ComercialRepositoryInter;

@Service
public class ComercialServiceImpl implements ComercialServiceInter {
    @Autowired
    ComercialRepositoryInter comercialRepository;

    public List<Comercial> findAllComercials() {
        return comercialRepository.findAll();
    }

    public Optional<Comercial> findComercialById(int id) {
        return comercialRepository.findById(id);
    }

    public Comercial addComercial(Comercial comercial) {
        return comercialRepository.save(comercial);
    }

    public Comercial updateComercial(Comercial comercial) {
        return comercialRepository.save(comercial);
    }

    public void removeComercial(Comercial comercial) {
        comercialRepository.delete(comercial);
    }
    
}
