package com.university.studentmgmt.service;

import com.university.studentmgmt.model.Etudiant;
import com.university.studentmgmt.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> getAll() { return etudiantRepository.findAll(); }
    public void create(Etudiant e) { etudiantRepository.save(e); }
    public void update(Etudiant e) { etudiantRepository.update(e); }
    public void delete(Long id) { etudiantRepository.delete(id); }
}
