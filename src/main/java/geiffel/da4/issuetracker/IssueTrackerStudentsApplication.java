package geiffel.da4.issuetracker;

import geiffel.da4.issuetracker.commentaire.Commentaire;
import geiffel.da4.issuetracker.commentaire.CommentaireRepository;
import geiffel.da4.issuetracker.issue.Issue;
import geiffel.da4.issuetracker.issue.IssueRepository;
import geiffel.da4.issuetracker.user.Fonction;
import geiffel.da4.issuetracker.user.User;
import geiffel.da4.issuetracker.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IssueTrackerStudentsApplication {


    public static void main(String[] args) {
        SpringApplication.run(IssueTrackerStudentsApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpBDD(UserRepository userRepository, IssueRepository issueRepository, CommentaireRepository commentaireRepository) {
        return (args) -> {
            User user1 =  new User(1L, "Machin", Fonction.USER);
            User user2 =  new User(2L, "Chose", Fonction.USER);
            User user3 =  new User(3L, "Truc", Fonction.DEVELOPPER);
            List<User> users = new ArrayList<>(){{
                add(user1);
                add(user2);
                add(user3);
            }};
            userRepository.saveAll(users);
            Issue issue1 = new Issue(1L, "blah", "some content1", user1, Timestamp.from(Instant.now()), null);
            Issue issue2 = new Issue(2L, "bleuh", "some content2", user2, Timestamp.from(Instant.now()), null);
            Issue issue3 = new Issue(3L, "blih", "some content3", user3, Timestamp.from(Instant.now()), null);
            Issue issue4 = new Issue(4L, "bloh", "some content4", user2, Timestamp.from(Instant.now()), null);

            List<Issue> issues = new ArrayList<>(){{
                add(issue1);
                add(issue2);
                add(issue3);
                add(issue4);
            }};
            issueRepository.saveAll(issues);

            List<Commentaire> commentaires = new ArrayList<>(){{
                add(new Commentaire(1L, user1, issue1, "Du contenu"));
            }};
            commentaireRepository.saveAll(commentaires);
        };
    }

}
