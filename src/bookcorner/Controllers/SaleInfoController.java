package bookcorner.Controllers;
import bookcorner.finder.BookFinder;
import bookcorner.models.Book;
import bookcorner.models.Customer;
import frontEnd.TableView.ViewSaleInfo;
import javafx.collections.FXCollections;
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

        FXMLLoader loader=new FXMLLoader(getClass().getResource("../../frontEnd/cashMemo.fxml"));
        Parent root=loader.load();

        CashMemoController cashMemoController=loader.getController();
        System.out.println(cust_name.getText());
        cashMemoController.displayInfo(cust_name.getText(),cust_address.getText());
        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
//        Stage stage=new Stage();
//        stage.setScene(new Scene(root));
//        stage.show();
    }


    public void saveButtonClicked(ActionEvent actionEvent) {
        String customerName=cust_name.getText();
        String customerContact=cust_contact.getText();
        String customerAddress=cust_address.getText();
        System.out.println(customerName+" "+customerContact+" "+customerAddress);
        createCustomerRecord(customerName,customerContact,customerAddress);
        // test
        System.out.println(selectedBooks);
    }

    public void createCustomerRecord(String name,String contact,String address){
        customer=new Customer(contact,name,address);
    }

    public String bookList(ActionEvent actionEvent) {
        return bookName.getSelectionModel().getSelectedItem().toString();
    }


    public void addBook(ActionEvent actionEvent) {
        String book=bookList(actionEvent);
        if(!selectedBooks.contains(book))
        {
            Book bookDetails=bookRecord.findByTitle(book);
            selectedBooks.add(book);
            // add new book to the list
            int quantity = Integer.parseInt(bookQuantity.getText());
            int totalPrice = quantity * (bookDetails.getSellingPrice());
            ViewSaleInfo record = new ViewSaleInfo(book, bookDetails.getAuthor(), quantity, bookDetails.getSellingPrice(), totalPrice);
            saleInfoTableView.getItems().add(record);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(Book b:bookFinder.findAll()){
            bookName.getItems().add(b.getTitle());
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
