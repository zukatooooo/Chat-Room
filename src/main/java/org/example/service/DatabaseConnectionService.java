package org.example.service;

public class DatabaseConnectionService {
    private static DatabaseConnectionService databaseConnectionServiceObject = null;

    public DatabaseConnectionService instance() {
        if(databaseConnectionServiceObject == null) {
            databaseConnectionServiceObject = new DatabaseConnectionService();
        }
        return databaseConnectionServiceObject;
    }
}
