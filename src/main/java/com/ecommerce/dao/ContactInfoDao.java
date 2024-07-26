package com.ecommerce.dao;

import com.ecommerce.database.Database;
import com.ecommerce.entity.ContactInfo;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Slf4j
public class ContactInfoDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_CONTACT_INFO_SQL = "INSERT INTO contact_info (name, email, message) VALUES (?, ?, ?)";

    public ContactInfoDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection =  Database.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void saveContactInfo(ContactInfo contactInfo) throws SQLException {
        try (Connection connection =Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACT_INFO_SQL)) {
            preparedStatement.setString(1, contactInfo.getName());
            preparedStatement.setString(2, contactInfo.getEmail());
            preparedStatement.setString(3, contactInfo.getMessage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           log.info(e.getMessage());
        }
    }
}
