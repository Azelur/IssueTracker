package geiffel.da4.issuetracker.issue;

import geiffel.da4.issuetracker.exceptions.ResourceAlreadyExistsException;
import geiffel.da4.issuetracker.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Qualifier("jpa")
public class IssueJPAService implements IssueService {
    @Autowired
    private IssueRepository issueRepository;
    @Override
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    @Override
    public Issue getByCode(Long code) {
        Optional<Issue> issue = issueRepository.findById(code);
        if (issue.isPresent()) {
            return issue.get();
        } else {
            throw new ResourceNotFoundException("Issue", code);
        }
    }

    @Override
    public Issue create(Issue newIssue) throws ResourceAlreadyExistsException {
        if (issueRepository.existsById(newIssue.getCode())) {
            throw new ResourceAlreadyExistsException("Issue already exist", newIssue);
        }
        else {
            return issueRepository.save(newIssue);
        }
    }

    @Override
    public void update(Long code, Issue updatedIssue) throws ResourceNotFoundException {
        Optional<Issue> issue = issueRepository.findById(code);
        if (issue.isPresent()) {
            issueRepository.save(updatedIssue);
        }
        else {
            throw new ResourceAlreadyExistsException("Issue already exist", issue);
        }
    }

    @Override
    public void delete(Long code) throws ResourceNotFoundException {
        Optional<Issue> issue = issueRepository.findById(code);
        if (issue.isPresent()) {
            issueRepository.deleteById(code);
        }
        else {
            throw new ResourceNotFoundException("Issue doesn't exist", issue);
        }
    }
}
