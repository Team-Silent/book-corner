package bookcorner.functionalities;

import bookcorner.models.Book;
import bookcorner.models.Customer;

import java.util.List;

public class CashMemo {
    List<Book> bookList;
    Customer customer;

    CashMemo(Customer forCustomer, List<Book> bookList){
        this.bookList = bookList;
        this.customer = forCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
