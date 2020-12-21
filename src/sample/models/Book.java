package sample.models;

public class Book implements DatabaseExecutable {
    String bookID;
    String title;
    String author;
    int purchasingPrice;
    int sellingPrice;
    int stock;

    @Override
    public String[] plsqlProcedure() {
        String[] insertionStrings = new String[6];

        return new String[0];
    }
}
