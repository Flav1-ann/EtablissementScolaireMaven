package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SpyEtudiantServiceTest {

    @Spy
    IEtudiantService service;

    @Test
    public void testGetOneUtilisateur() throws  ServiceException {

        //Subbing
        Mockito.doReturn(new Etudiant(2,"name","Annaix"+Math.random()+"@gmail.com","24 b"
                ,"24 b","0252154785","","",new Date( new java.util.Date().getTime()))).when(service).get(15);

        Etudiant et = service.get(15);

        assertEquals(et.getNom(), "name");

        Mockito.verify(service, Mockito.times(1)).get(15);
    }

    @AfterEach
    public void afterEach()
    {
        service = null;
    }

}
