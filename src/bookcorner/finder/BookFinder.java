package bookcorner.finder;

import bookcorner.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder extends Finder <Book> {

    @Override
    public List<Book> findAll() {
        String query = "Select * from Books";
        return getBooks(query);
    }


    private List<Book> getBooks( String query) {
        List<Book> bookArrayList = new ArrayList<>();
        databaseConnection.connect();
        ResultSet resultSet = databaseConnection.runQuery(query);
        try {

            while (resultSet.next()){
                Book book = getBookFromResult(resultSet);
                bookArrayList.add(book);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        databaseConnection.disconnect();
        return bookArrayList;
    }

    private Book getBookFromResult(ResultSet resultSet) throws SQLException {
        return new Book(
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getInt("purchase_price"),
                            resultSet.getInt("selling_price"),
                            resultSet.getInt("stock")
                    );
    }

    @Override
    public Book findByID(String id){
        String query = "Select * from Books where Books.Book_ID = '" + id +"'";
        return getBooks(query).get(0);
    }

    public Book findByTitle(String title){
        Book book = null;
        String query = "Select * from Books where Books.title = '" + title +"'";
        return getBooks(query).get(0);
    }



    @Override
    public List<Book> findByProperty(String columnName, String value){
        String query = "Select * from Books where"+ "Books."+ columnName +"= '" + value +"'";
        return getBooks(query);
    }

}
