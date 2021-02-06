package bookcorner.finder;

import bookcorner.models.Book;
import bookcorner.models.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleFinder extends Finder<Sale>{
    String date;
    private List<SaleCustomer> saleCustomerInfoList = new ArrayList<>();
    private List<Sale> saleArrayList = new ArrayList<>();

    SaleFinder(int day, int month, int year){
        String dayString = String.valueOf(day);
        String monthString = String.valueOf(month);
        String yearString = String.valueOf(year);
        if(day<10) dayString = '0'+dayString;
        if(month<10) monthString = '0'+monthString;
        if(year<10) yearString = '0'+yearString;
        this.date = dayString+"-"+monthString+"-"+yearString;
    }








    @Override
    public List<Sale> findAll() {
        String query = "SELECT Sales_id, Customer_id, TO_CHAR( Sales_Date, 'HH24:MI:SS' )\n" +
                "From Sales\n" +
                "Where TO_CHAR(Sales_Date,'DD-MM-YYYY')= '"+date+"'";
        return getSales(query);
    }


    private List<Sale> getSales(String query) {
        saleArrayList.clear();
        databaseConnection.connect();
        ResultSet resultSet = databaseConnection.runQuery(query);
        try {

            while (resultSet.next()){
                addToInfoList(resultSet);
            }
            for (SaleCustomer saleCustomer: saleCustomerInfoList){
                saleArrayList.add(createSale(saleCustomer));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        databaseConnection.disconnect();
        return saleArrayList;
    }

    private Sale createSale(SaleCustomer saleCustomer) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT Book_id, Quantity FROM Book_Sales_junction Where Sales_id = '" + saleCustomer.saleID+"'";
        databaseConnection.connect();
        ResultSet resultSet = databaseConnection.runQuery(query);
        try {
            while (resultSet.next()){
                Book book = new Book(resultSet.getString("Book_id"),resultSet.getInt("QUANTITY"));
                books.add(book);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return new Sale(saleCustomer.saleID,saleCustomer.customerID,books);
    }

    private void addToInfoList(ResultSet resultSet) throws SQLException {
        saleCustomerInfoList.add(new SaleCustomer(resultSet.getString("sales_ID"),resultSet.getString("customer_id")));
    }

    private List<String> getSaleBookS() {
        return null;
    }

    @Override
    public Sale findByID(String id){
        String query = "Select * from Books where Books.Book_ID = '" + id +"'";
        return null;
    }

    public Sale findByTitle(String title){
        Book book = null;
        String query = "Select * from Books where Books.title = '" + title +"'";
        return null;
    }



    @Override
    public List<Sale> findByProperty(String columnName, String value){
        String query = "Select * from Books where"+ "Books."+ columnName +"= '" + value +"'";
        return null;
    }



    class SaleCustomer{
        String saleID;
        String customerID;

        public SaleCustomer(String saleID, String customerID) {
            this.saleID = saleID;
            this.customerID = customerID;
        }
    }
}

