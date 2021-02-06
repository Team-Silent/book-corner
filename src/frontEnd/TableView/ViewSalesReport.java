package frontEnd.TableView;

public class ViewSalesReport {
    String customerName;
    String time;
    Integer transaction;
    String saleInfo;

    public ViewSalesReport(String customerName,Integer transaction,String saleInfo,String time) {
        this.customerName = customerName;
        this.transaction=transaction;
        this.saleInfo=saleInfo;
        this.time=time;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    public String getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(String saleInfo) {
        this.saleInfo = saleInfo;
    }
}
