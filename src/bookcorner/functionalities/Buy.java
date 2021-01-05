package bookcorner.functionalities;

import bookcorner.models.Book;
import bookcorner.models.Customer;
import bookcorner.models.Sale;

import java.util.List;

public class Buy {
    Customer customer;
    List<Book> books;

    public Buy(Customer customer, List<Book> books) {
        this.customer = customer;
        this.books = books;
    }

    public void makePurchase(){
        for (Book book: books) {
            customer.buy(book);
        }
        Sale sale = new Sale(customer,books);
        sale.makeSale();
    }
}
