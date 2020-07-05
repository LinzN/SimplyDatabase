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

package de.linzn.simplyDatabase;

import de.linzn.simplyDatabase.iohub.DatabaseActions;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class DatabaseProvider extends DatabaseActions {

    public abstract Connection getConnection();

    public abstract void closeConnection() throws SQLException;
}
