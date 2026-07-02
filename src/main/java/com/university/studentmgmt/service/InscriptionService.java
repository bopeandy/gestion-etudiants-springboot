package com.university.studentmgmt.service;

import com.university.studentmgmt.model.Inscription;
import com.university.studentmgmt.repository.InscriptionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public void inscrireEtudiant(Long etudiantId, Long coursId) {
        inscriptionRepository.save(etudiantId, coursId);
    }

    public void annulerInscription(Long id) {
        inscriptionRepository.delete(id);
    }
}