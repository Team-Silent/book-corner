package bookcorner.models;

public class Customer {
    String contactNumber;
    String name;
    String address;

    public Customer(String contactNumber, String name, String address) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.address = address;
    }

    public void buy(Book book){
        //Todo: add the record to book_customer_junction
    }

    private void buy(){

    }
}
