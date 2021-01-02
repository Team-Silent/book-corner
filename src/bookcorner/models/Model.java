package bookcorner.models;

import bookcorner.database.DatabaseConnection;

public abstract class Model {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    abstract String getTableName();


}
