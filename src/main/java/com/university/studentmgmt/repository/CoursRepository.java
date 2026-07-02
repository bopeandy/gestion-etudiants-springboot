package com.university.studentmgmt.repository;

import com.university.studentmgmt.model.Cours;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CoursRepository {
    private final JdbcClient jdbcClient;

    public CoursRepository(JdbcClient jdbcClient) { this.jdbcClient = jdbcClient; }

    public List<Cours> findAll() {
        return jdbcClient.sql("SELECT * FROM cours").query(Cours.class).list();
    }

    public void save(Cours c) {
        jdbcClient.sql("INSERT INTO cours(titre, code) VALUES (?, ?)")
                .params(c.getTitre(), c.getCode()).update();
    }

    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM cours WHERE id = ?").param(id).update();
    }
}
