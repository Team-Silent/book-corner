package frontEnd.TableView;

import javafx.fxml.Initializable;

public class ViewSaleInfo {
    private String bookName;
    private String author;
    private Integer price;
    private Integer quantity;
    private Integer total;

    public ViewSaleInfo(String bookName,String author,Integer quantity,Integer price,Integer total) {
        this.bookName = bookName;
        this.author=author;
        this.quantity=quantity;
        this.price=price;
        this.total=total;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
