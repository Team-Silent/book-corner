package bookcorner.finder;

import bookcorner.database.DatabaseUser;
import bookcorner.models.Book;
import bookcorner.models.Model;

import java.util.List;

public abstract class Finder <T extends Model> extends DatabaseUser {
    abstract List<T> findAll();
    abstract List<T> findByProperty(String property, String value);
}
