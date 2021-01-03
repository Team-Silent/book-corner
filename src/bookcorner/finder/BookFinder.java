package bookcorner.finder;

import bookcorner.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder extends Finder <Book> {
    @Override
    List<Book> findAll() {
        List<Book> bookArrayList = new ArrayList<>();

        databaseConnection.connect();
        ResultSet resultSet = databaseConnection.runQuery("Select * from Books");
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



    public Book findByID(String id){
        Book book = null;
        databaseConnection.connect();
        ResultSet resultSet = databaseConnection.runQuery("Select * from Books where Books.Book_ID = '" + id +"'");
        try {

            System.out.println("start");
            while (resultSet.next()){
                book = getBookFromResult(resultSet);

            }
        }
        catch (SQLException e){
            System.out.println("Exception");
            e.printStackTrace();
        }
        databaseConnection.disconnect();
        return book;
    }
}
