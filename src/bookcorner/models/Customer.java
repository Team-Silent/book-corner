package bookcorner.models;

import bookcorner.database.DatabaseConnection;

public class Customer extends Model {
    String contactNumber;
    String name;
    String address;

    boolean recordable;

    public Customer(String contactNumber, String name, String address) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.address = address;
        recordable = true;
        databaseConnection = new DatabaseConnection();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void buy(Book book){
        databaseConnection.runProcedure("buy("+
                       "'"+ book.getId()+"'"+","+
                       "'"+ contactNumber+"'"+","+
                       "'"+ book.getQuantity()+"'"+
                        ")"
                );
    }

    public void saveToDatabase(){
        if(!recordable) throw new IllegalArgumentException();

        databaseConnection.runProcedure("addCustomer("+
                                    "'"+name         +"'"+","+
                                    "'"+contactNumber+"'"+","+
                                    "'"+address      +"'"+
                                    ")"
        );
    }


    @Override
    String getTableName() {
        return "Customers";
    }

    public String getID() {
        return contactNumber;
    }
}
