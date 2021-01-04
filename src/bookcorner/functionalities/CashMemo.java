package bookcorner.functionalities;

import bookcorner.models.Book;
import bookcorner.models.Customer;

import java.util.List;

public class CashMemo {
    List<Book> bookList;
    Customer customer;
    int totalPrice;

    CashMemo(Customer forCustomer, List<Book> bookList){
        this.bookList = bookList;
        this.customer = forCustomer;
        findTotalPrice();
    }

    private void findTotalPrice() {
        int sum = 0;
        for (Book book: bookList ) {
            sum+= book.getTotalSellingPrice();
        }
        totalPrice = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }


}