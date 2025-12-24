/*
 * Copyright (c) 2025 MirraNET, Niklas Linz. All rights reserved.
 *
 * This file is part of the MirraNET project and is licensed under the
 * GNU Lesser General Public License v3.0 (LGPLv3).
 *
 * You may use, distribute and modify this code under the terms
 * of the LGPLv3 license. You should have received a copy of the
 * license along with this file. If not, see <https://www.gnu.org/licenses/lgpl-3.0.html>
 * or contact: niklas.linz@mirranet.de
 */

package de.linzn.simplyDatabase.provider;

import de.linzn.simplyDatabase.DatabaseProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLProvider extends DatabaseProvider {

    private final String username;
    private final String password;
    private final String hostname;
    private final int port;
    private final String database;

    public MySQLProvider(String hostname, int port, String username, String password, String database) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.database = database;
        this.hostname = hostname;
    }


    @Override
    public Connection getConnection()  {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + this.port + "/" + this.database, this.username, this.password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void releaseConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
