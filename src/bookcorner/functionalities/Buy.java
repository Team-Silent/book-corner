package bookcorner.functionalities;
//Todo: Needs to be moved to a different package i think

import bookcorner.models.Book;
import bookcorner.models.Customer;

public class Buy {
    Customer customer;
    Book[] books;

    public Buy(Customer customer, Book[] books) {
        this.customer = customer;
        this.books = books;
    }

    public void makePurchase(){
        for (Book book: books) {
            customer.buy(book);
        }

    };
}
