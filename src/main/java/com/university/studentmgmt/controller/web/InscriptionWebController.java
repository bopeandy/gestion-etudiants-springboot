package com.university.studentmgmt.controller.web;

import com.university.studentmgmt.service.InscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/inscriptions")
public class InscriptionWebController {

    private final InscriptionService inscriptionService;

    public InscriptionWebController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping
    public String listInscriptions(Model model) {
        model.addAttribute("inscriptions", inscriptionService.getAllInscriptions());
        return "inscriptions"; // Renvoie vers la vue src/main/resources/templates/inscriptions.html
    }
}