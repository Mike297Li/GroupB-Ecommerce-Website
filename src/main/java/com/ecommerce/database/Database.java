package com.ecommerce.database;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:mysql://localhost:3306/ecommerce" );
        config.setUsername( "root" );
        config.setPassword( "root" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setConnectionTimeout(30000);
        config.setMaximumPoolSize(20);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds = new HikariDataSource( config );
    }

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void main(String[] args) {
        try (Connection conn = new Database().getConnection()) {
            System.out.println("Connection successful: " + (conn != null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
