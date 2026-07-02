package com.university.studentmgmt.controller.api;

import com.university.studentmgmt.model.Cours;
import com.university.studentmgmt.service.CoursService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursRestController {
    private final CoursService coursService;

    public CoursRestController(CoursService coursService) { this.coursService = coursService; }

    @GetMapping
    public List<Cours> getAll() { return coursService.getAll(); }

    @PostMapping
    public void create(@RequestBody Cours c) { coursService.create(c); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { coursService.delete(id); }
}
