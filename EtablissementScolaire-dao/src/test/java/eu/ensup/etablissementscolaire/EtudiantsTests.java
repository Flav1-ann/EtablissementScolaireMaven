package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtudiantsTests {

    static private  EtudiantDao et = new EtudiantDao();

    @Test
    @DisplayName("Tout les etudiant")
    public void FindAllEtudiantTest() throws DaoException {
        int taille = et.getAll().size();
        assertEquals(6,taille);
    }
    @Test
    @DisplayName("Ajouter un etudiant")
    public void addEtudiantTest() throws DaoException {
        int tailleBeforeIns = et.getAll().size();
        int result = et.create(new Etudiant("4","Annaix"+Math.random()+"@gmail.com","24 b"
                ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
        int tailleAfterIns = et.getAll().size();
        assertEquals(tailleAfterIns,tailleBeforeIns+1);
        assertEquals(0,result);
    }
    @Test
    @DisplayName("Supprimer un etudiant")
    public void deleteEtudiantTest() throws DaoException {
        int tailleBeforeIns = et.getAll().size();
        et.delete(14);
        int tailleAfterIns = et.getAll().size();
        assertEquals(tailleAfterIns,tailleBeforeIns-1);
    }

    @Test
    @DisplayName("Mettre a jour un etudiant")
    public void updateEtudiantTest() throws DaoException {
        Etudiant  etudiantBeforeUpdtae =  et.get(15);
        etudiantBeforeUpdtae.setPrenom("test");
        et.update(etudiantBeforeUpdtae);
        Etudiant  etudiantAfterUpdate =  et.get(15);
        assertEquals("test",etudiantAfterUpdate.getPrenom());
    }
    @Test
    @DisplayName("trouver un etudiant")
    public void getOneEtudiantTest() throws DaoException {
        Etudiant  etudiant=  et.get(15);
        assertEquals("24 b",etudiant.getAdresse());
    }

}
