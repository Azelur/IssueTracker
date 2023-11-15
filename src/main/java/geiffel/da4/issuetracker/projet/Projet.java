package geiffel.da4.issuetracker.projet;

import geiffel.da4.issuetracker.commentaire.Commentaire;
import geiffel.da4.issuetracker.user.User;
import geiffel.da4.issuetracker.utils.TimestampUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Projet {
    @Id
    private long id;
    private String nom;
    public Projet(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Projet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}

