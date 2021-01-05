package bookcorner.models;

import bookcorner.finder.BookFinder;
import bookcorner.functionalities.Buy;
import org.junit.jupiter.api.Test;

public class TestModel {
    Customer customer = new Customer("123","abc","def");

    @Test
    public void testModel() {
        customer.addToRecords();
        Book book = new Book("ABC","DEF",2200,2500,10);
        book.saveToDatabase();

        Buy buy = new Buy(customer, new BookFinder().findAll());
        buy.makePurchase();
    }





}



