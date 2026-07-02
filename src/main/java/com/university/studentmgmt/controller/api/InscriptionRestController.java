package com.university.studentmgmt.controller.api;

import com.university.studentmgmt.model.Etudiant;
import com.university.studentmgmt.service.EtudiantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantRestController {
    private final EtudiantService etudiantService;

    public EtudiantRestController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> getAll() { return etudiantService.getAll(); }

    @PostMapping
    public void create(@RequestBody Etudiant e) { etudiantService.create(e); }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Etudiant e) {
        e.setId(id);
        etudiantService.update(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { etudiantService.delete(id); }
}
