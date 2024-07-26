package com.ecommerce.dao;

import com.ecommerce.database.Database;
import com.ecommerce.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    Connection connection = Database.getConnection();;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public CategoryDao() throws SQLException {
    }

    // Method to set amount of products for category.
    private void queryCategoryProductAmount(Category category){
        int productId = category.getId();
        String query = "SELECT COUNT(*) FROM product WHERE fk_category_id = ? AND product_is_deleted = false";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, productId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    category.setTotalCategoryProduct(resultSet.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("Get category products amount catch: ");
            e.printStackTrace();
        }
    }

    // Method to get category by id.
    public Category getCategory(int categoryId) {
        Category category = new Category();
        String query = "SELECT * FROM category WHERE category_id = " + categoryId;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Call method to set category amount for category.
        queryCategoryProductAmount(category);

        return category;
    }

    // Method to get all categories from database.
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM category";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                list.add(category);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Call method to set category amount for category.
        for (Category category : list) {
            queryCategoryProductAmount(category);
        }

        return list;
    }
}
