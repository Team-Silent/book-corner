package bookcorner.Controllers;
import bookcorner.models.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SaleInfoController implements Initializable {

    @FXML private Button bookAdd;
    @FXML private TextField bookQuantity;
    @FXML private TextArea cust_address;
    @FXML private TextArea cust_name;
    @FXML private TextArea cust_contact;
    @FXML private ComboBox<String> bookName;

    Customer customer;
    ArrayList<String> selectedBooks=new ArrayList<>();

    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/homeView.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void cashMemoScene(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/cashMemo.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
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
        String book=bookName.getSelectionModel().getSelectedItem().toString();
//        System.out.println("Book : "+book);
        return book;
    }

    // For testing purpose
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> bookList= FXCollections.observableArrayList("Sherlock Holmes","Harry Potter","Rich Dad Poor Dad","The Dialogues of Plato");
        bookName.setItems(bookList);
    }


    public void addBook(ActionEvent actionEvent) {
        String book=bookList(actionEvent);
        selectedBooks.add(book);
    }
}
