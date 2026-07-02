package com.university.studentmgmt.repository;

import com.university.studentmgmt.model.Inscription;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class InscriptionRepository {

    private final JdbcClient jdbcClient;
    
    // Correction ici : l'import et le type sont maintenant parfaits
    private final JdbcMapper<Inscription> inscriptionMapper = JdbcMapperFactory.newInstance()
            .addKeys("id")
            .newMapper(Inscription.class);

    public InscriptionRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Inscription> findAll() {
        String sql = """
            SELECT 
                i.id AS id, 
                i.date_inscription AS dateInscription,
                e.id AS etudiant_id, e.nom AS etudiant_nom, e.prenom AS etudiant_prenom, e.email AS etudiant_email,
                c.id AS cours_id, c.titre AS cours_titre, c.code AS cours_code
            FROM inscription i
            JOIN etudiant e ON i.etudiant_id = e.id
            JOIN cours c ON i.cours_id = c.id
        """;
        
        return jdbcClient.sql(sql)
                .query((ResultSet rs, int rowNum) -> {
                    if (rs.isBeforeFirst()) rs.next(); 
                    return inscriptionMapper.map(rs);
                })
                .list(); // Retourne maintenant une List<Inscription> correcte
    }

    public int save(Long etudiantId, Long coursId) {
        return jdbcClient.sql("INSERT INTO inscription(etudiant_id, cours_id) VALUES (?, ?)")
                .params(etudiantId, coursId)
                .update();
    }

    public int delete(Long id) {
        return jdbcClient.sql("DELETE FROM inscription WHERE id = ?")
                .param(id)
                .update();
    }
}