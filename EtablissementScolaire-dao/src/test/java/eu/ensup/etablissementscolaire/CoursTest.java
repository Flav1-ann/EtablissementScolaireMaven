package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CoursTest {

    static private CoursDao _cours = new CoursDao();

    @Test
    @Ignore
    @DisplayName("Tout les Cours")
    public void FindAllCoursTest() throws DaoException {
        //juint
        // int taille = cours.getAll().size();
        // assertThat(3,equalTo(taille));

        //hamcrest
        assertThat(_cours.getAll(), hasSize(3));
    }

    @Ignore
    @Test
    @DisplayName("Ajouter un Cours")
    public void addCoursTest() throws DaoException {
        int tailleBeforeIns = _cours.getAll().size();
        _cours.create(new Cours("Test Inte",5));
        int tailleAfterIns = _cours.getAll().size();
        assertThat(tailleAfterIns,is(tailleBeforeIns+1));
    }

    @Ignore
    @Test
    @DisplayName("Supprimer un Cours")
    public void deleteCoursTest() throws DaoException {
        int tailleBeforeIns = _cours.getAll().size();
        _cours.delete(11);
        int tailleAfterIns = _cours.getAll().size();
        assertThat(tailleAfterIns,equalTo(tailleBeforeIns-1));
    }

    @Ignore
    @Test
    @DisplayName("Mettre a jour un Cours")
    public void updateCoursTest() throws DaoException {
        Cours  CoursBeforeUpdtae =  _cours.get(2);
        CoursBeforeUpdtae.setTheme("Maven");
        _cours.update(CoursBeforeUpdtae);
        Cours  CoursAfterUpdate =  _cours.get(2);
        assertThat("Maven",equalTo(CoursAfterUpdate.getTheme()));
    }

    @Ignore
    @Test
    @DisplayName("Trouver un Cours")
    public void getOneCoursTest() throws DaoException {
        Cours  Cours=  _cours.get(3);
        assertNotNull(Cours);
        assertThat(Cours, instanceOf(Cours.class));
        assertEquals("info",Cours.getTheme());
    }

}
