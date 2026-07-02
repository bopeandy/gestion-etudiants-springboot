package com.university.studentmgmt.controller.api;

import com.university.studentmgmt.model.Inscription;
import com.university.studentmgmt.service.InscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionRestController {

    private final InscriptionService inscriptionService;

    public InscriptionRestController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping
    public List<Inscription> getAll() {
        return inscriptionService.getAllInscriptions();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam Long etudiantId, @RequestParam Long coursId) {
        inscriptionService.inscrireEtudiant(etudiantId, coursId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscriptionService.annulerInscription(id);
    }
}