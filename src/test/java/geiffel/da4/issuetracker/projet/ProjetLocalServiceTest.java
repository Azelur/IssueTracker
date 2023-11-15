package geiffel.da4.issuetracker.projet;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = ProjetLocalService.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjetLocalServiceTest {

    List<Projet> projets = new ArrayList<>() {{
        add(new Projet(1L,"leMemeNom1"));
        add(new Projet(2L,"leMemeNom2"));
        add(new Projet(3L,"leMemeNom3"));
        add(new Projet(4L,"leMemeNom4"));
    }};

    private ProjetService projetService = new ProjetLocalService(projets);


    @Test
    void whenGettingAll_shouldBeOfSize(){
        List<Projet> lesProjets = projetService.getAll();
        assertEquals(4,lesProjets.size());
    }

    @Test
    void whenGettingById_shouldBeOfSize(){
        assertAll(
               () -> assertEquals(projets.get(0), projetService.getById(1L)),
               () -> assertEquals(projets.get(1), projetService.getById(2L))
        );
    }


}
