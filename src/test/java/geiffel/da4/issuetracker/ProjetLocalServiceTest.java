package geiffel.da4.issuetracker;

import geiffel.da4.issuetracker.commentaire.Commentaire;
import geiffel.da4.issuetracker.commentaire.CommentaireRepository;
import geiffel.da4.issuetracker.issue.Issue;
import geiffel.da4.issuetracker.issue.IssueRepository;
import geiffel.da4.issuetracker.projet.Projet;
import geiffel.da4.issuetracker.projet.ProjetLocalService;
import geiffel.da4.issuetracker.projet.ProjetService;
import geiffel.da4.issuetracker.user.Fonction;
import geiffel.da4.issuetracker.user.User;
import geiffel.da4.issuetracker.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
public class ProjetLocalServiceTest {
    List<Projet> projets = new ArrayList<>(){{
        add(new Projet(1L, "LeMemeNom1"));
        add(new Projet(2L, "LeMemeNom2"));
        add(new Projet(3L, "LeMemeNom3"));
        add(new Projet(4L, "LeMemeNom4"));
    }};

    private ProjetService projetService = new ProjetLocalService(projets);

    @Test
    void whenGettingAll_shouldBeSize4() {
        List<Projet> lesProjets = projetService.getAll();
        assertEquals(4, lesProjets.size());
        }
}