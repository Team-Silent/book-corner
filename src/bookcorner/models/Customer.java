package bookcorner.models;

public class Customer extends Model {
    String contactNumber;
    String name;
    String address;

    public Customer(String contactNumber, String name, String address) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.address = address;
    }

    public Customer(String contactNumber){
        //Todo: query find customer and fill the fields
    }

    public void buy(Book book){
        databaseConnection.runProcedure("buy("+
                        book.getId()+","+
                        contactNumber+","+
                        book.getQuantity()+
                        ")"
                );
    }

}
