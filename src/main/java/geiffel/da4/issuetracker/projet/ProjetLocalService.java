package geiffel.da4.issuetracker.projet;

import geiffel.da4.issuetracker.utils.LocalService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Qualifier("local")
public class ProjetLocalService extends LocalService<Projet, Long> implements ProjetService{

        public ProjetLocalService(List<Projet> projets) {
                super(projets);
        }

    @Override
    public String getIdentifier() {
        return "id";
    }

    @Override
    public List<Projet> getAll() {
        return allValues;
    }

    @Override
    public List<Projet> getById() {
        return null;
    }

    @Override
    public Projet getById(Long id) {
        return this.getByIdentifier(id);
    }




}
