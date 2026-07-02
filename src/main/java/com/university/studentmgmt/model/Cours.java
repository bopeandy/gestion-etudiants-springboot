package com.university.studentmgmt.model;

public class Cours {
    private Long id;
    private String titre;
    private String code;

    // Constructeurs, Getters et Setters
    public Cours() {}
    public Cours(Long id, String titre, String code) {
        this.id = id; this.titre = titre; this.code = code;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}