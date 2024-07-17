package com.ecommerce.control;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ContactInfoDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.ContactInfo;
import com.ecommerce.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeControl", urlPatterns = {"/", "/home", "/submitContact"})
public class HomeControl extends HttpServlet {
    // Call DAO class to access with database.
    ProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();
    ContactInfoDao contactInfoDao=new ContactInfoDao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get all products from database.
        List<Product> productList = productDao.getAllProducts();
        // Get all categories from database.
        List<Category> categoryList = categoryDao.getAllCategories();


        request.setAttribute("product_list", productList);
        request.setAttribute("category_list", categoryList);
        // Set attribute active class for home in header.
        request.setAttribute("home_active", "active");
        // Get request dispatcher and render to index page.
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Determine which form is being submitted based on the URL pattern
        String servletPath = request.getServletPath();

        if ("/submitContact".equals(servletPath)) {
            try {
                handleContactSubmission(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            doGet(request, response);
        }
    }

    private void handleContactSubmission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // Get form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Process the contact form submission
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setName(name);
        contactInfo.setEmail(email);
        contactInfo.setMessage(message);

        // Save the contact info using the ContactInfoDao
        contactInfoDao.saveContactInfo(contactInfo);

        // Set a success message attribute
        request.setAttribute("message", "Thank you for contacting us, " + name + "! We will get back to you soon.");

        // Redirect back to the contact page or to a confirmation page
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact.jsp");
        requestDispatcher.forward(request, response);
    }
}