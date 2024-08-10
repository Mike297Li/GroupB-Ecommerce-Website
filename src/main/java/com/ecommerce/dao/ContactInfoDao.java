package com.ecommerce.dao;

import com.ecommerce.databaseUtils.Database;
import com.ecommerce.model.ContactInfo;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Slf4j
public class ContactInfoDao {
    Connection connection = null;

    private static final String INSERT_CONTACT_INFO_SQL = "INSERT INTO contact_info (name, email, message) VALUES (?, ?, ?)";

    public ContactInfoDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = Database.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void saveContactInfo(ContactInfo contactInfo) throws SQLException {
        try {
            connection = Database.getConnection();
            // Disable auto-commit
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACT_INFO_SQL);
            preparedStatement.setString(1, contactInfo.getName());
            preparedStatement.setString(2, contactInfo.getEmail());
            preparedStatement.setString(3, contactInfo.getMessage());
            preparedStatement.executeUpdate();
            // Commit the transaction if all statements are successful
            connection.commit();
        } catch (SQLException e) {
            log.info(e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();  // Rollback the transaction in case of error
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback failed: " + rollbackEx.getMessage());
                }
            };
        }
    }
}
