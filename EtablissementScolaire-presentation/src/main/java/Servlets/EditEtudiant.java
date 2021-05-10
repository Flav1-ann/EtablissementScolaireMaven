package Servlets;

import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.CredentialException1;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.AddEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.UpdateEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@WebServlet(name = "editEtudiant", value = "/editEtudiant")
public class EditEtudiant extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (CredentialException1 | NoSuchAlgorithmException | AddEtudiantServiceException | GetAllEtudiantServiceException | UpdateEtudiantServiceException | ParseException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (CredentialException1 | NoSuchAlgorithmException | AddEtudiantServiceException | GetAllEtudiantServiceException | UpdateEtudiantServiceException | ParseException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CredentialException1, NoSuchAlgorithmException, AddEtudiantServiceException, GetAllEtudiantServiceException, UpdateEtudiantServiceException, ParseException {
        EtudiantService etudiantService = new EtudiantService();
        HttpSession userSession = request.getSession();
        Set<Etudiant> List = etudiantService.getAll();
        userSession.setAttribute("listEtudiant",List);

        if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
            Etudiant etudiant = new Etudiant(request.getParameter("firstName"), request.getParameter("email"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("lastName"), "", "", null);
           System.out.println(etudiant);
            if(etudiant.getNom() == null  || etudiant.getPrenom() == null || etudiant.getEmail() == null || etudiant.getTelephone() == null || etudiant.getAdresse() == null ){
                userSession.setAttribute("info", "Veuillez remplir tous les champs");
            } else {
                userSession.setAttribute("info", "Modification réussie");
                etudiantService.update(etudiant);
            }
            request.getRequestDispatcher("editEtudiant.jsp").forward(request,response);

        } else {
            userSession.setAttribute("info", "Veuillez sélectionnez un étudiant");
            request.getRequestDispatcher("editEtudiant.jsp").forward(request,response);
        }

    }
}
