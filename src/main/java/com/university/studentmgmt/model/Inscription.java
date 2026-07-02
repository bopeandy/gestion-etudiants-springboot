package com.university.studentmgmt.model;

import java.time.LocalDate;

public class Inscription {
    private Long id;
    private Etudiant etudiant; // Relation N:1
    private Cours cours;       // Relation N:1
    private LocalDate dateInscription;

    // Constructeurs, Getters et Setters
    public Inscription() {}
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }
    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }
    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { this.dateInscription = dateInscription; }
}