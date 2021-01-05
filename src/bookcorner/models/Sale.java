package bookcorner.models;

import java.util.Date;
import java.util.List;

public class Sale extends Model{
    String id;
    Customer customer;
    Date date;
    boolean databaseAddable = false;
    List<Book> bookList;

    public Sale(Customer customer, List<Book> bookList) {
        this.customer = customer;
        this.bookList = bookList;
        databaseAddable = true;
    }


    public void makeSale(){
        addSaleInfoToDatabase();
    }

    private void addSaleInfoToDatabase(){
        if(!databaseAddable) return;
        toSalesTable();
        for (Book book: bookList) {
            toSaleBookJunctionTable(book);
        }

    }

    private void toSaleBookJunctionTable(Book book) {
        databaseConnection.runProcedure("book_to_sell_at("+
                "'"+customer.getID()+"'"+","+
                "'"+book.getId()+"'"+","+
                "'"+book.getQuantity()+"'"+
                ")"
        );
    }

    private void toSalesTable() {
        databaseConnection.runProcedure("makeSales("+
                                        "'"+ customer.getID() + "'"+
                                        ")"
        );
    }


    @Override
    String getTableName() {
        return "Sales";
    }
}
