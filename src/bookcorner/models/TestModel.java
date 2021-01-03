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
    }

    @Test
    public void testSale(){
        new Sale("1234").makeSale();
    }




}



