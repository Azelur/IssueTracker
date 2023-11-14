package geiffel.da4.issuetracker.commentaire;

import geiffel.da4.issuetracker.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    //@Query(value = "SELECT * FROM Commentaire WHERE author_id=:id", nativeQuery = true)
    @Query(value = "SELECT c FROM Commentaire c WHERE c.author.id=:id")
    List<Commentaire> getAllByAuthorId(@Param("id") Long id);

}
