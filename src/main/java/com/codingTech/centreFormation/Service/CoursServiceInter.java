package com.codingTech.centreFormation.Service;

import com.codingTech.centreFormation.Entity.Cours;

import java.util.List;
import java.util.Optional;

public interface CoursServiceInter {
    public List<Cours> findAllCours();

    public Optional<Cours> findCoursById(int id);

    public Cours addCours(Cours cours);

    List<Cours> addListCourses(List<Cours> courses);

    public Cours updateCours(Cours cours);

    public void removeCours(Cours cours);

}