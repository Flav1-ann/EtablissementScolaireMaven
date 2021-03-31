package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestSansInjection {

    IEtudiantDao mockDao;
    EtudiantService service;

    @Before
    public void init() {
        mockDao = Mockito.mock(IEtudiantDao.class);
        service = new EtudiantService(mockDao);
    }

    @Test
    @DisplayName("Tout les etudiant")
    public void FindAllEtudiantTest() throws DaoException, GetAllEtudiantServiceException {



        Set<Etudiant> setEtudiant = new HashSet<Etudiant>() {{
            add(new Etudiant("4","Annaix"+Math.random()+"@gmail.com","24 b"
                    ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
            add(new Etudiant("4","Annaix"+Math.random()+"@gmail.com","24 b"
                    ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
            add(new Etudiant("4","Annaix"+Math.random()+"@gmail.com","24 b"
                    ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
        }};

        when(mockDao.getAll()).thenReturn(setEtudiant);

        Set<Etudiant> etudiantList = service.getAll();

        assertEquals(3,etudiantList.size());
        verify(mockDao).getAll();
    }

    @AfterEach
    public void afterEach()
    {
        mockDao = null;
        service = null;
    }
}
