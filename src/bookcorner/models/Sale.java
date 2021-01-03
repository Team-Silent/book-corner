package bookcorner.models;

public class Sale extends Model{
    String id;
    String customerID;
    boolean databaseAddable = false;

    public Sale(String customerID) {
        this.customerID = customerID;
        databaseAddable = true;
    }

    public void makeSale(){
        addToDatabase();
    }

    private void addToDatabase(){
        if(!databaseAddable) return;
        databaseConnection.runProcedure("makeSales("+
                                        "'"+ customerID + "'"+
                                        ")"
        );

    }


    @Override
    String getTableName() {
        return "Sales";
    }
}
