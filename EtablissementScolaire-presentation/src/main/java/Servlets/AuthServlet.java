package Servlets;


import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.ResponsableService;
import eu.ensup.etablissementscolaire.exception.CredentialException1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.NoSuchAlgorithmException;


@WebServlet(name = "aut", value = "/aut")
public class AuthServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (CredentialException1 | NoSuchAlgorithmException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            operations(request,response);
        } catch (CredentialException1 | NoSuchAlgorithmException e) {
            request.getRequestDispatcher("erreur.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CredentialException1, NoSuchAlgorithmException {
        HttpSession userSession = request.getSession();

        String email = request.getParameter("login");
        String pwd = request.getParameter("password");

        userSession.removeAttribute("user");

        ResponsableService responsableService = new ResponsableService();

        Responsable user;

        user = responsableService.getCredentialByEmail(email);
        try {
            responsableService.validAuthentification(user, pwd);
            userSession.setAttribute("user",user);
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (CredentialException1 credentialException1){
            request.setAttribute("error", credentialException1.getLocalizedMessage());
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }


    }

    public void destroy() {
    }
}
