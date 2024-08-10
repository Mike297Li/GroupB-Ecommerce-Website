package com.ecommerce.control;

import com.ecommerce.dao.AccountDao;
import com.ecommerce.entity.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ProfileControl", value = "/profile-page")
@MultipartConfig
public class ProfileControl extends HttpServlet {
    // Call DAO class to access with the database.
    AccountDao accountDao = new AccountDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile-page.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        int accountId = account.getId();
        String firstName = request.getParameter("first-name").trim();
        String lastName = request.getParameter("last-name").trim(); // Last name is optional
        String address = request.getParameter("address").trim();    // Address is compulsory
        String email = request.getParameter("email").trim();
        String phone = request.getParameter("phone").trim();

        String errorMessage = null;

        // Basic validation for required fields
        if (firstName.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            errorMessage = "First name, address, email, and phone number are required.";
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errorMessage = "Please enter a valid email address.";
        } else if (!phone.matches("\\d{10}")) {
            errorMessage = "Please enter a valid 10-digit phone number.";
        }

        Part part = request.getPart("profile-image");
        if (part != null && part.getSize() > 0) { // Check if an image is uploaded
            String contentType = part.getContentType();
            if (!contentType.equals("image/jpeg") && !contentType.equals("image/png")) {
                errorMessage = "Only JPG and PNG images are allowed.";
            }
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile-page.jsp");
            dispatcher.forward(request, response);
        } else {
            // Proceed with updating the profile if validation passes
            InputStream inputStream = (part != null && part.getSize() > 0) ? part.getInputStream() : null;

            accountDao.editProfileInformation(accountId, firstName, lastName, address, email, phone, inputStream);
            response.sendRedirect("login");
        }
    }

}
