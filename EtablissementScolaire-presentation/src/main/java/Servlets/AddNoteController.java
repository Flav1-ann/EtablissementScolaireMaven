package Servlets;

import eu.ensup.etablissementscolaire.*;
import eu.ensup.etablissementscolaire.exception.CredentialException1;
import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.InscriptionCoursServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.AddEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Set;

@WebServlet(name = "addNote", value = "/addNote")
public class AddNoteController extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (NoSuchAlgorithmException | ServiceException | DaoException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (NoSuchAlgorithmException | ServiceException | DaoException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException, NoSuchAlgorithmException, DaoException {

        EtudiantService etudiantService = new EtudiantService();
        MatiereService matiereService = new MatiereService();
        NoteEleveService noteEleveService = new NoteEleveService();

        HttpSession userSession = request.getSession();

        Set<Matiere> listeCours = matiereService.getAll();
        userSession.setAttribute("listCourse",listeCours);

        Set<Etudiant> List = etudiantService.getAll();
        userSession.setAttribute("listEtudiant",List);

        if (request.getParameter("button")!= null ){
            NoteEleve noteEleve = new NoteEleve(1, Integer.parseInt(request.getParameter("button").split(" ")[2]));
            noteEleveService.addNoteEleve(noteEleve,etudiantService.get(Integer.parseInt(request.getParameter("button").split(" ")[1])),matiereService.get(Integer.parseInt(request.getParameter("button").split(" ")[0])));
        }

        request.getRequestDispatcher("addNoteEtudiant.jsp").forward(request,response);

    }

    public void destroy() {
    }
}
