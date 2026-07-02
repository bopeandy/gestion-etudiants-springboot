package com.university.studentmgmt.controller.web;

import com.university.studentmgmt.model.Etudiant;
import com.university.studentmgmt.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/etudiants")
public class EtudiantWebController {

    private final EtudiantService etudiantService;

    public EtudiantWebController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // Lire (Read) - Afficher la liste et le formulaire
    @GetMapping
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAll());
        return "etudiants";
    }

    // Créer (Create) - Recevoir les données du formulaire
    @PostMapping("/ajouter")
    public String ajouterEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.create(etudiant);
        return "redirect:/web/etudiants"; // Redirige vers la liste mise à jour
    }

    // Supprimer (Delete) - Géré via un lien simple pour l'interface web
    @GetMapping("/supprimer/{id}")
    public String supprimerEtudiant(@PathVariable Long id) {
        etudiantService.delete(id);
        return "redirect:/web/etudiants";
    }
}
