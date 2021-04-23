package Servlets;

import eu.ensup.etablissementscolaire.Cours;
import eu.ensup.etablissementscolaire.CoursService;
import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.CredentialException1;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.AddEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

@WebServlet(name = "setCourse", value = "/setCourse")
public class SetCourse extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (CredentialException1 | NoSuchAlgorithmException | AddEtudiantServiceException | GetAllEtudiantServiceException | GetAllCoursServiceException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (CredentialException1 | NoSuchAlgorithmException | AddEtudiantServiceException | GetAllEtudiantServiceException | GetAllCoursServiceException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CredentialException1, NoSuchAlgorithmException, AddEtudiantServiceException, GetAllEtudiantServiceException, GetAllCoursServiceException {
        EtudiantService etudiantService = new EtudiantService();
        CoursService coursService = new CoursService();

        HttpSession userSession = request.getSession();

         Set<Cours> listeCours = coursService.getAll();
        userSession.setAttribute("listCourse",listeCours);

        Set<Etudiant> List = etudiantService.getAll();
        userSession.setAttribute("listEtudiant",List);


        request.getRequestDispatcher("setCourse.jsp").forward(request,response);

    }
}
