package bookcorner.Controllers;

import bookcorner.models.Book;
import frontEnd.TableView.ViewSaleDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SaleDetailsController implements Initializable {
    public TableView<ViewSaleDetails> saleDetailsTableView;
    public TableColumn<ViewSaleDetails,Integer> tv_quantity;
    public TableColumn<ViewSaleDetails,String> tv_bookTitle;
    public TableColumn<ViewSaleDetails,Integer> tv_price;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tv_bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        tv_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tv_price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void displayRecords(List<Book> books){
        ObservableList<ViewSaleDetails>selectedBooks= FXCollections.observableArrayList();
        for(Book book:books){
            selectedBooks.add(new ViewSaleDetails(book.getTitle(),book.getQuantity(),book.getSellingPrice()));
        }
        saleDetailsTableView.setItems(selectedBooks);
    }
}
