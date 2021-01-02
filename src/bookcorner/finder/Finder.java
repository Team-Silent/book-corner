package bookcorner.finder;

import bookcorner.database.DatabaseUser;
import bookcorner.models.Model;

import java.util.ArrayList;

public abstract class Finder <T extends Model> extends DatabaseUser {
    abstract ArrayList<T> findAll();
}
