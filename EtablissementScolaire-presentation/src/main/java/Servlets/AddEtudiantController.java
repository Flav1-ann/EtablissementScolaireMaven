package Servlets;

import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.CredentialException1;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.AddEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@WebServlet(name = "etudiantAdd", value = "/etudiantAdd")
public class AddEtudiantController extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request, response);
        } catch (CredentialException1 | NoSuchAlgorithmException | AddEtudiantServiceException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request, response);
        } catch (CredentialException1 | NoSuchAlgorithmException | AddEtudiantServiceException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CredentialException1, NoSuchAlgorithmException, AddEtudiantServiceException {
        EtudiantService etudiantService = new EtudiantService();
        HttpSession userSession = request.getSession();

        Etudiant etudiant = new Etudiant(request.getParameter("lastname"), request.getParameter("email"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("firstName"), "", "", null);
        int ret;
        if(etudiant.getNom() == null || etudiant.getPrenom() == null || etudiant.getEmail() == null || etudiant.getTelephone() == null || etudiant.getAdresse() == null){
            ret = -2;
        } else {
            ret = etudiantService.create(etudiant);
        }

        if (ret == 0) {
            userSession.setAttribute("info", "L'étudiant à été crée");
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
        } else if (ret == -1) {
            userSession.setAttribute("info", "Erreur lors de la creation de l'étudiant");
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
        } else if (ret == -2){
            userSession.setAttribute("info", "Veuillez remplir tous les champs");
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
        }


    }

    public void destroy() {
    }
}
