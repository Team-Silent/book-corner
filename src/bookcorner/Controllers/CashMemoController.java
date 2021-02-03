package bookcorner.Controllers;

import bookcorner.functionalities.CashMemo;
import bookcorner.models.Book;
import frontEnd.TableView.ViewCashMemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CashMemoController implements Initializable {
    public Label cust_name;
    public Label cust_add;
    public Label issueDate;
    public Label invoiceTotal;
    public Label total_amount;

    public TableView<ViewCashMemo> cashMemoTableView;
    public TableColumn<ViewCashMemo,Integer> tv_sl;
    public TableColumn<ViewCashMemo,String> tv_bookTitle;
    public TableColumn<ViewCashMemo,Integer> tv_price;
    public TableColumn<ViewCashMemo,Integer> tv_quantity;
    public TableColumn<ViewCashMemo,Integer> tv_amount;

    ArrayList<Book> bookList=new ArrayList<>();
    SaleInfoController saleInfoController=new SaleInfoController();

    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/homeView.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void displayInfo(String name, String address, int totalPrice,ArrayList<CashMemo> books){
         cust_name.setText(name);
         cust_add.setText(address);
         invoiceTotal.setText(String.valueOf(totalPrice));
         total_amount.setText(String.valueOf(totalPrice));

        getBooks(books);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tv_sl.setCellValueFactory(new PropertyValueFactory<ViewCashMemo,Integer>("serialNo"));
        tv_bookTitle.setCellValueFactory(new PropertyValueFactory<ViewCashMemo,String>("bookName"));
        tv_price.setCellValueFactory(new PropertyValueFactory<ViewCashMemo,Integer>("price"));
        tv_quantity.setCellValueFactory(new PropertyValueFactory<ViewCashMemo,Integer>("quantity"));
        tv_amount.setCellValueFactory(new PropertyValueFactory<ViewCashMemo,Integer>("amount"));

    }

     public void getBooks(ArrayList<CashMemo> books) {
         ObservableList<ViewCashMemo> allPurchasedBooks = FXCollections.observableArrayList();
         int bookCount=0;
         for(CashMemo book:books){
           allPurchasedBooks.add(new ViewCashMemo(++bookCount,book.getBookTitle(),book.getPrice(),book.getQuantity(),book.getAmount()));
         }
         cashMemoTableView.setItems(allPurchasedBooks);
     }


}
