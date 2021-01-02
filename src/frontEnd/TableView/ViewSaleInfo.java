package frontEnd.TableView;

import javafx.fxml.Initializable;

public class ViewSaleInfo {
    private String bookName;
    private String author;
    private Double price;
    private Integer quantity;
    private Double total;

    public ViewSaleInfo(String bookName,Integer quantity) {
        this.bookName = bookName;
        this.quantity=quantity;
    }
    public  ViewSaleInfo(){}

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
