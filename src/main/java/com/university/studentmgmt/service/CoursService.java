package com.university.studentmgmt.service;

import com.university.studentmgmt.model.Cours;
import com.university.studentmgmt.repository.CoursRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoursService {
    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public List<Cours> getAll() { return coursRepository.findAll(); }
    public void create(Cours c) { coursRepository.save(c); }
    public void delete(Long id) { coursRepository.delete(id); }
}
