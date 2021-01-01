package bookcorner.models;

public class Buy extends Model{
    Customer customer;
    Book[] books;

    public Buy(Customer customer, Book[] books) {
        this.customer = customer;
        this.books = books;
    }

    public void makePurchase(){
        /*Todo: for each books
                add record to book_customer_junction_table
                change book stock count
            */

    };
}
