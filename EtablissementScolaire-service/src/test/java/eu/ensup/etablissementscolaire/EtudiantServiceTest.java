package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTest {

    @Mock
    IEtudiantDao mockDao;

    @InjectMocks
    EtudiantService service;

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
