package bookcorner.models;

public class Book extends Model implements Updatable{
    String title;
    String author;
    int purchasingPrice;
    int sellingPrice;
    int stock;

    public Book(String title, String author, int purchasingPrice, int sellingPrice, int stock) {
        this.title = title;
        this.author = author;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }

    @Override
    public void saveToDatabase() {
        databaseConnection.runProcedure("insertBook("+
                "'"+this.title+"'"+","+
                "'"+this.author+"'"+","+
                this.purchasingPrice+","+
                this.sellingPrice+","+
                this.stock+
                ")");
    }




}
