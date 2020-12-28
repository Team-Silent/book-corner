package sample.models;

public class Book extends Model implements Updatable{
    String bookID;
    String title;
    String author;
    int purchasingPrice;
    int sellingPrice;
    int stock;

    public Book(String bookID, String title, String author, int purchasingPrice, int sellingPrice, int stock) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }

    @Override
    public void update() {
        databaseConnection.runProcedure("insertBook("+
                this.bookID+","+
                this.title+","+
                this.author+","+
                this.purchasingPrice+","+
                this.sellingPrice+","+
                this.stock+
                ")");
    }




}
