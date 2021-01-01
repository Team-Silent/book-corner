package bookcorner.models;

public class Book extends Model implements Updatable{
    String title;
    String author;
    int purchasingPrice;
    int sellingPrice;
    int quantity;
    int stock;
    boolean updatable = false;

    public Book(String title, String author, int purchasingPrice, int sellingPrice, int quantity) {
        this.title = title;
        this.author = author;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        updatable = true;
    }


    public Book(String title, String author, int quantity){
        //Todo: find book; assign values
    }






    @Override
    public void updateStock() {
        if(!updatable) return;
        databaseConnection.runProcedure("insertBook("+
                "'"+this.title+"'"+","+
                "'"+this.author+"'"+","+
                this.purchasingPrice+","+
                this.sellingPrice+","+
                this.quantity +
                ")");
    }




}
