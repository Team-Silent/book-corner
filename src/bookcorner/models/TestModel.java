package bookcorner.models;

import bookcorner.functionalities.Buy;
import org.junit.jupiter.api.Test;

public class TestModel {
    @Test
    public void testModel() {
        Book book = new Book("ABC","DEF",2200,2500,10);
        book.saveToDatabase();
        Customer customer = new Customer("123","abc","def");
        customer.addToRecords();
        Buy buy = new Buy(customer,new Book[] {book});
        buy.makePurchase();

        ///
        //

        //Add new book, stock update
        //Buy (with add customer information) Buy->[customer_id, book_id, quantity]
        //Add-> Controller -> for all info buy

        //Add sales information  (3rd)
        //View sales information

        //Cash memo generation (4th)
    }




}



