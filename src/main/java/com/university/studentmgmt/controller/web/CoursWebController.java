package com.university.studentmgmt.controller.web;

import com.university.studentmgmt.model.Cours;
import com.university.studentmgmt.service.CoursService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/cours")
public class CoursWebController {
    private final CoursService coursService;

    public CoursWebController(CoursService coursService) { this.coursService = coursService; }

    @GetMapping
    public String listCours(Model model) {
        model.addAttribute("lesCours", coursService.getAll());
        return "cours";
    }

    @PostMapping("/ajouter")
    public String ajouter(@ModelAttribute Cours cours) {
        coursService.create(cours);
        return "redirect:/web/cours";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        coursService.delete(id);
        return "redirect:/web/cours";
    }
}
