package bookcorner.models;

public class Customer extends Model {
    String contactNumber;
    String name;
    String address;

    boolean recordable = false;

    public Customer(String contactNumber, String name, String address) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.address = address;
        recordable = true;
    }

    public Customer(String contactNumber){
        //Todo: query find customer and fill the fields
    }

    public void buy(Book book){
        databaseConnection.runProcedure("buy("+
                       "'"+ book.getId()+"'"+","+
                       "'"+ contactNumber+"'"+","+
                       "'"+ book.getQuantity()+"'"+
                        ")"
                );
    }

    public void addToRecords(){
        if(!recordable) throw new IllegalArgumentException();

        /*Todo: Add this customer to the database
                Using procedure: add_or_update_customer()
        */
    }

}
