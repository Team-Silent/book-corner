package bookcorner.finder;

import bookcorner.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookFinder extends Finder <Book> {
    @Override
    ArrayList<Book> findAll() {
        ArrayList<Book> bookArrayList = new ArrayList<>();

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
}
