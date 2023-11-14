package geiffel.da4.issuetracker.commentaire;

import geiffel.da4.issuetracker.exceptions.ResourceAlreadyExistsException;
import geiffel.da4.issuetracker.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpa")

public class CommentaireJPAService implements CommentaireService {
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Override
    public List<Commentaire> getAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire getById(Long code) {
        Optional<Commentaire> commentaire = commentaireRepository.findById(code);
        if (commentaire.isPresent()) {
            return commentaire.get();
        } else {
            throw new ResourceNotFoundException("Commentaire", code);
        }
    }

    @Override
    public List<Commentaire> getAllByAuthorId(Long id) {
        return null;
    }

    @Override
    public List<Commentaire> getAllByIssueCode(Long code) {
        return null;
    }

    @Override
    public Commentaire create(Commentaire newCommentaire) throws ResourceAlreadyExistsException {
        if (commentaireRepository.existsById(newCommentaire.getId())) {
            throw new ResourceAlreadyExistsException("Commentaire already exist", newCommentaire);
        }
        else {
            return commentaireRepository.save(newCommentaire);
        }
    }

    @Override
    public void update(Long code, Commentaire updatedCommentaire) throws ResourceNotFoundException {
        Optional<Commentaire> commentaire = commentaireRepository.findById(code);
        if (commentaire.isPresent()) {
            commentaireRepository.save(updatedCommentaire);
        }
        else {
            throw new ResourceAlreadyExistsException("Commentaire already exist", commentaire);
        }
    }

    @Override
    public void delete(Long code) throws ResourceNotFoundException {
        Optional<Commentaire> commentaire = commentaireRepository.findById(code);
        if (commentaire.isPresent()) {
            commentaireRepository.deleteById(code);
        }
        else {
            throw new ResourceNotFoundException("Commentaire doesn't exist", commentaire);
        }
    }
}
