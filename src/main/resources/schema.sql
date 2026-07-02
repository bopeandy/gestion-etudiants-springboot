CREATE TABLE IF NOT EXISTS etudiant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS cours (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(150) NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS inscription (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    etudiant_id BIGINT NOT NULL,
    cours_id BIGINT NOT NULL,
    date_inscription DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (etudiant_id) REFERENCES etudiant(id) ON DELETE CASCADE,
    FOREIGN KEY (cours_id) REFERENCES cours(id) ON DELETE CASCADE
);
-- Insertion de données de test par défaut
INSERT INTO etudiant (nom, prenom, email) VALUES ('Dupont', 'Jean', 'jean.dupont@univ.fr');
INSERT INTO etudiant (nom, prenom, email) VALUES ('Curie', 'Marie', 'marie.curie@univ.fr');

INSERT INTO cours (titre, code) VALUES ('Architecture Logicielle', 'INFO-301');
INSERT INTO cours (titre, code) VALUES ('Bases de données avancées', 'INFO-302');

-- Liaison : Jean Dupont (ID 1) est inscrit au cours INFO-301 (ID 1)
INSERT INTO inscription (etudiant_id, cours_id) VALUES (1, 1);
-- Liaison : Marie Curie (ID 2) est inscrite au cours INFO-302 (ID 2)
INSERT INTO inscription (etudiant_id, cours_id) VALUES (2, 2);
