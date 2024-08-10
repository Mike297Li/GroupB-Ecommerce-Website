package com.ecommerce.controller;

import com.ecommerce.dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ResetControl", value = "/reset")
@MultipartConfig
public class ResetControl extends HttpServlet {
    // Call DAO class to access with database.
    AccountDao accountDao = new AccountDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        resetPassword(request, response);

    }
    private void resetPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("new-password");
        String repeatNewPassword = request.getParameter("repeat-new-password");

        // Check if the new passwords match
        if (!newPassword.equals(repeatNewPassword)) {
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    "                            Passwords do not match!\n" +
                    "                        </p>\n" +
                    "                    </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
        }
        // Check if username exists in the database
        else if (!accountDao.checkUsernameExists(username)) {
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    "                            Username does not exist!\n" +
                    "                        </p>\n" +
                    "                    </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
        }
        // Reset the password in the database
        else {
            boolean isReset = accountDao.resetPassword(username, newPassword);
            if (isReset) {
                String alert = "<div class=\"alert alert-success wrap-input100\">\n" +
                        "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                        "                            Password reset successfully!\n" +
                        "                        </p>\n" +
                        "                    </div>";
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                        "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                        "                            Password reset failed!\n" +
                        "                        </p>\n" +
                        "                    </div>";
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            }
        }
    }
}
