/*
 * Copyright (C) 2020. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 *
 */

package de.linzn.simplyDatabase.provider;

import de.linzn.simplyDatabase.DatabaseProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteProvider extends DatabaseProvider {

    private final String url;
    private Connection connection;


    private SQLiteProvider(String url) {
        super();
        this.url = url;
    }

    public static DatabaseProvider createConnection(String url) {
        SQLiteProvider databaseProvider = new SQLiteProvider(url);
        databaseProvider.connection = setup(url);
        return databaseProvider;
    }

    private static Connection setup(String url) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public Connection getConnection() {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connection = setup(this.url);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.connection;
    }

    @Override
    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    @Override
    public Object test(String test) {
        return null;
    }
}
