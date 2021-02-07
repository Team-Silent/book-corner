package bookcorner.Controllers;
import bookcorner.finder.BookFinder;
import bookcorner.functionalities.Buy;
import bookcorner.functionalities.CashMemo;
import bookcorner.models.Book;
import bookcorner.models.Customer;
import frontEnd.TableView.ViewSaleInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SaleInfoController implements Initializable {

    public TableView<ViewSaleInfo> saleInfoTableView;
    public TableColumn<ViewSaleInfo,String> tv_bookName;
    public TableColumn<ViewSaleInfo,String> tv_author;
    public TableColumn<ViewSaleInfo,Integer> tv_quantity;
    public TableColumn<ViewSaleInfo,Integer> tv_price;
    public TableColumn<ViewSaleInfo,Integer> tv_total;
    @FXML private TextField bookQuantity;
    @FXML private TextArea cust_address;
    @FXML private TextArea cust_name;
    @FXML private TextArea cust_contact;
    @FXML private ComboBox<String> bookName;

    Customer customer;
    BookFinder bookFinder=new BookFinder();
    BookFinder bookRecord=new BookFinder();
    ArrayList<String> selectedBooks=new ArrayList<>();
    ArrayList<Integer> allPriceTotal=new ArrayList<>();
    ArrayList<Book> bookList=new ArrayList<>();
    ArrayList<CashMemo> bookCashMemo=new ArrayList<>();


    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/homeView.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    public void cashMemoScene(ActionEvent actionEvent) throws IOException {
//        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/cashMemo.fxml"));
//        Scene scene=new Scene(saleReportView);
        createCustomerRecord();
        System.out.println("CUSTOMER data: "+customer.getName()+" "+customer.getAddress()+" "+customer.getID());
        if(customer.getID().equals("") ||customer.getID()==null||customer.getName()==null||customer.getAddress()==null) return;
        if(bookList.size()==0) return;
        customer.saveToDatabase();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../../frontEnd/cashMemo.fxml"));
        Parent root=loader.load();

        Buy buy = new Buy(customer,bookList);
        buy.makePurchase();
        CashMemoController cashMemoController=loader.getController();

        cashMemoController.displayInfo(cust_name.getText(),cust_address.getText(),getTotalPrice(),bookCashMemo);
        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();

    }

    public ArrayList<Book> getBookList(){
        return bookList;
    }

    public void saveButtonClicked(ActionEvent actionEvent) {

        createCustomerRecord();
        // test
        System.out.println(selectedBooks);
    }

    public void createCustomerRecord(){
        String customerName=cust_name.getText();
        String customerContact=cust_contact.getText();
        String customerAddress=cust_address.getText();
        System.out.println(customerName+" "+customerContact+" "+customerAddress);
        customer=new Customer(customerContact,customerName,customerAddress);

    }

    public String bookList(ActionEvent actionEvent) {
        return bookName
                .getSelectionModel()
                .getSelectedItem();
    }


    public void addBook(ActionEvent actionEvent) {
        String book=bookList(actionEvent);
        if(!selectedBooks.contains(book))
        {
            if(book==null) return;
            if(book.equals("")) return;
            Book bookDetails=bookRecord.findByID(book);
            selectedBooks.add(book);

            // add new book to the list
            int quantity = Integer.parseInt(bookQuantity.getText());
            int price=bookDetails.getSellingPrice();
            int totalPrice = quantity * price;
            bookDetails.setQuantity(quantity);
            bookList.add(bookDetails);
            allPriceTotal.add(totalPrice);
            CashMemo cashMemo = new CashMemo(book, price, quantity, totalPrice);
            bookCashMemo.add(cashMemo);
            ViewSaleInfo record = new ViewSaleInfo(bookDetails.getTitle(), bookDetails.getAuthor(), quantity, price, totalPrice);
            saleInfoTableView.getItems().add(record);
        }
    }
    private int getTotalPrice(){
        int sum=0;
        for(int price:allPriceTotal){
            sum+=price;
        }
        return sum;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(Book b:bookFinder.findAll()){
            bookName.getItems().add(b.getId());
        }

        tv_bookName.setCellValueFactory(new PropertyValueFactory<ViewSaleInfo,String>("bookName"));
        tv_quantity.setCellValueFactory(new PropertyValueFactory<ViewSaleInfo,Integer>("quantity"));
        tv_author.setCellValueFactory(new PropertyValueFactory<ViewSaleInfo,String>("author"));
        tv_price.setCellValueFactory(new PropertyValueFactory<ViewSaleInfo,Integer>("price"));
        tv_total.setCellValueFactory(new PropertyValueFactory<ViewSaleInfo,Integer>("total"));


    }

    public void removeBook(ActionEvent actionEvent) {
        ObservableList<ViewSaleInfo>allBooks,book;
        allBooks=saleInfoTableView.getItems();
        book=saleInfoTableView.getSelectionModel().getSelectedItems();
        for(ViewSaleInfo v:book){
            selectedBooks.remove(v.getBookName());
        }
        book.forEach(allBooks::remove);
    }
}
