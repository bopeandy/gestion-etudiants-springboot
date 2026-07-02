package com.university.studentmgmt.repository;

import com.university.studentmgmt.model.Etudiant;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EtudiantRepository {
    private final JdbcClient jdbcClient;

    public EtudiantRepository(JdbcClient jdbcClient) { this.jdbcClient = jdbcClient; }

    public List<Etudiant> findAll() {
        return jdbcClient.sql("SELECT * FROM etudiant").query(Etudiant.class).list();
    }

    public void save(Etudiant e) {
        jdbcClient.sql("INSERT INTO etudiant(nom, prenom, email) VALUES (?, ?, ?)")
                .params(e.getNom(), e.getPrenom(), e.getEmail()).update();
    }

    public void update(Etudiant e) {
        jdbcClient.sql("UPDATE etudiant SET nom = ?, prenom = ?, email = ? WHERE id = ?")
                .params(e.getNom(), e.getPrenom(), e.getEmail(), e.getId()).update();
    }

    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM etudiant WHERE id = ?").param(id).update();
    }
}
