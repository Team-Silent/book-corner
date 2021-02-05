package bookcorner.finder;

import bookcorner.models.Book;
import bookcorner.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FinderTester {
    @Test
    public void testBookFinder(){
        BookFinder bookFinder = new BookFinder();
        printBooks(bookFinder.findAll());
        Book book = new Book("a_title","an_author",1000,1200,3);
        book.saveToDatabase();
        Book foundBook = bookFinder.findByID("a_titlean_author");
        Assertions.assertEquals(book.getId(),foundBook.getId());
        Assertions.assertEquals(book.getTitle(),foundBook.getTitle());
        Assertions.assertEquals(book.getPurchasingPrice(),foundBook.getPurchasingPrice());
        Customer customer = new Customer("123232323","louuu","Korfu");
        customer.saveToDatabase();
        Customer customer2 = new CustomerFinder().findByID("123232323");
        Assertions.assertEquals(customer.getID(),customer2.getID());
        Assertions.assertEquals(customer.getName(),customer2.getName());
        Assertions.assertEquals(customer.getAddress(),customer2.getAddress());
        printCustomers(new CustomerFinder().findAll());
    }

    private void printCustomers(List<Customer> customers) {
        for(Customer customer:customers){
            System.out.println(customer.getID()+" " +customer.getName()+ " "+customer.getAddress());
        }
    }

    private void printBooks(List<Book> books) {
        for (Book book: books) {
            System.out.println(book.getId() + " " + book.getTitle()+" " + book.getAuthor()+" " + book.getQuantity());
        }
    }

}
