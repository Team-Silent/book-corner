package bookcorner.models;

public class Book extends Model{
    String title;
    String author;
    private String id;
    int purchasingPrice;
    int sellingPrice;
    private int quantity;
    int stock;
    boolean updatable = false;

    public Book(String title, String author, int purchasingPrice, int sellingPrice, int quantity) {
        this.title = title;
        this.author = author;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.id = title+author;
        updatable = true;
    }


    public Book(String title, String author, int quantity){
        //Todo: find book; assign values
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

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


    @Override
    String getTableName() {
        return "Books";
    }
}
