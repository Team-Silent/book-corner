package frontEnd.TableView;

public class ViewCashMemo {

    private Integer serialNo;
    private String bookName;
    private Integer price;
    private Integer quantity;
    private Integer amount;

    public ViewCashMemo(Integer serialNo,String bookName, Integer price, Integer quantity, Integer amount) {
        this.serialNo=serialNo;
        this.bookName = bookName;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
