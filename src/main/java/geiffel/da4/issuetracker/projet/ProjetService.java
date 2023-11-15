package geiffel.da4.issuetracker.projet;

import geiffel.da4.issuetracker.issue.Issue;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProjetService {

    List<Projet> getAll();

    Projet getById(Long id);
    List<Projet> getById();


}
