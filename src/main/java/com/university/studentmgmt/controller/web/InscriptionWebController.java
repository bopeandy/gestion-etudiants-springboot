package com.university.studentmgmt.controller.web;

import org.springframework.web.bind.annotation.PathVariable;
import com.university.studentmgmt.service.CoursService;
import com.university.studentmgmt.service.EtudiantService;
import com.university.studentmgmt.service.InscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web/inscriptions")
public class InscriptionWebController {

    private final InscriptionService inscriptionService;
    private final EtudiantService etudiantService;
    private final CoursService coursService;

    public InscriptionWebController(
            InscriptionService inscriptionService,
            EtudiantService etudiantService,
            CoursService coursService) {
        this.inscriptionService = inscriptionService;
        this.etudiantService = etudiantService;
        this.coursService = coursService;
    }

    /**
     * Affiche la liste des inscriptions.
     */
    @GetMapping
    public String listInscriptions(Model model) {
        model.addAttribute("inscriptions", inscriptionService.getAllInscriptions());
        return "inscriptions";
    }

    /**
     * Affiche le formulaire d'inscription.
     */
    @GetMapping("/ajouter")
    public String afficherFormulaire(Model model) {
        model.addAttribute("lesEtudiants", etudiantService.getAll());
        model.addAttribute("lesCours", coursService.getAll());
        return "inscrire";
    }

    /**
     * Traite la soumission du formulaire.
     */
    @PostMapping("/ajouter")
    public String ajouterInscription(
            @RequestParam Long etudiantId,
            @RequestParam Long coursId) {

        inscriptionService.inscrireEtudiant(etudiantId, coursId);
        return "redirect:/web/inscriptions";
    }
/**
 * Annule une inscription via son ID.
 */
    @GetMapping("/supprimer/{id}")
    public String supprimerInscription(@PathVariable Long id) {
        inscriptionService.annulerInscription(id);
        return "redirect:/web/inscriptions";
}
}
