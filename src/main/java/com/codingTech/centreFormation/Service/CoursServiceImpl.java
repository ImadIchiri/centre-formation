package com.codingTech.centreFormation.Service;

import com.codingTech.centreFormation.Entity.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingTech.centreFormation.Repository.CoursRepositoryInter;

import java.util.List;
import java.util.Optional;

@Service
public class CoursServiceImpl implements CoursServiceInter {
    @Autowired
    CoursRepositoryInter coursRepository;

    @Override
    public List<Cours> findAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Optional<Cours> findCoursById(int id) {
        return coursRepository.findById(id);
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> addListCourses(List<Cours> courses) {
        return coursRepository.saveAll(courses);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public void removeCours(Cours cours) {
        coursRepository.delete(cours);
    }
}
