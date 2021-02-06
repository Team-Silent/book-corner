package frontEnd.TableView;

public class ViewSaleDetails {
    String bookTitle;
    Integer quantity;
    Integer price;

    public ViewSaleDetails(String bookTitle, Integer quantity, Integer price) {
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }
}
