package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // TODO: ensure the submitted information is valid
        if(!validRegistrationInput(username, email, password)) {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        if(!confirm.equals(password)){
            request.getRequestDispatcher("/register.")
        }

        // TODO: create a new user based off of the submitted information

        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");

        // TODO: if a user was successfully created, send them to their profile
    }

    private boolean validRegistrationInput(String username, String email, String password) {
        if(!(isValidUsername(username) && isValidEmail(email) && isValidPassword(password))) return false;
        return true;
    }

    private boolean isValidEmail(String email) {

    }

    private boolean isValidUsername(String username) {
        if (username.length() > 4 && username.length < 21) return true;
        return false;
    }
}