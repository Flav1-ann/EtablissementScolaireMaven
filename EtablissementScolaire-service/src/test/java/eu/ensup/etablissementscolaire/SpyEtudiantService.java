package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpyEtudiantService {

    @Spy
    IEtudiantDao dao;

    @BeforeEach
    public void beforeEach()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOneUtilisateur() throws DaoException {

        Mockito.doReturn(new Etudiant(2,"name","Annaix"+Math.random()+"@gmail.com","24 b"
                ,"24 b","0252154785","","",new Date( new java.util.Date().getTime()))).when(dao).get(2);

        Mockito.doReturn(new Etudiant(2,"name","Annaix"+Math.random()+"@gmail.com","24 b"
                ,"24 b","0252154785","","",new Date( new java.util.Date().getTime()))).when(dao).get(3);

        Etudiant et = dao.get(2);
        Etudiant et3 = dao.get(2);

        assertEquals(et.getNom(), "name");

       Mockito.verify(dao, Mockito.times(2)).get(2);

    }

    @AfterEach
    public void afterEach()
    {
        dao = null;
    }

}
