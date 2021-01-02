package bookcorner.models;

import bookcorner.database.DatabaseUser;

public abstract class Model extends DatabaseUser {
    abstract String getTableName();
}
