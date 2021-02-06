package bookcorner.models;

import bookcorner.database.DatabaseConnection;
import bookcorner.finder.BookFinder;
import bookcorner.finder.CustomerFinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale extends Model{
    String id;
    Customer customer;
    Date date;
    String time;
    boolean databaseAddable = false;
    List<Book> bookList;

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public int getTransaction(){
        int transaction = 0;
        for (Book book:bookList){
            transaction+= book.getTotalSellingPrice();
        }
        return transaction;
    }

    public String getTime(){
        return time;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Sale(Customer customer, List<Book> bookList) {
        this.customer = customer;
        this.bookList = bookList;
        databaseAddable = true;
        databaseConnection = new DatabaseConnection();
    }

    public Sale(String id, String customerID, String time, List<Book> books){
        customer = new CustomerFinder().findByID(customerID);
        this.id = id;
        this.bookList=books;
        this.time = time;
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
        databaseConnection.runProcedure("book_to_sale_for("+
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
