package bookcorner.models;

public class Book extends Model{
    private String title;
    private String author;
    private String id;
    private int purchasingPrice;
    private int sellingPrice;
    private int quantity;
    private int stock;
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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPurchasingPrice() {
        return purchasingPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getStock() {
        return stock;
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
