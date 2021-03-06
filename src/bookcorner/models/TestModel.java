package bookcorner.models;

import bookcorner.finder.BookFinder;
import bookcorner.functionalities.Buy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestModel {
    Customer customer = new Customer("123","abc","def");

    @Test
    public void testModel() throws InterruptedException {
       // wait(500);
        customer.saveToDatabase();
        Book book = new Book("ABC","DEF",2200,2500,10);
        book.saveToDatabase();

        Buy buy = new Buy(customer, new BookFinder().findAll());
        buy.makePurchase();

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("ABC by DEF",3));
        Sale sale = new Sale(customer,bookList);
        Assertions.assertEquals(7500,sale.getTransaction());

    }





}



