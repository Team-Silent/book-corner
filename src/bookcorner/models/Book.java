package bookcorner.models;

import bookcorner.database.DatabaseConnection;
import bookcorner.finder.BookFinder;

public class Book extends Model{
    private String title;
    private String author;
    private String id;
    private int purchasingPrice;
    private int sellingPrice;
    private int quantity;
    private int stock;
    boolean updatable;

    public Book(String title, String author, int purchasingPrice, int sellingPrice, int quantity) {
        this.title = title;
        this.author = author;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.id = title+author;
        updatable = true;
        databaseConnection = new DatabaseConnection();
    }

    private void syncFromDatabase(){
       Book foundBook = new BookFinder().findByID(id);
       this.purchasingPrice = foundBook.purchasingPrice;
       this.sellingPrice = foundBook.sellingPrice;
       this.title=foundBook.title;
       this.author=foundBook.author;
       this.stock = foundBook.quantity;
    }

    public int getTotalSellingPrice(){
        return quantity*sellingPrice;
    }

    public Book(String title, String author, int quantity){
       this(title+author,quantity);
    }

    public Book(String id, int quantity){
        this.id = id;
        this.quantity = quantity;
        syncFromDatabase();
        updatable = false;
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

    public void saveToDatabase() {
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
