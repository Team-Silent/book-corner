package bookcorner.Controllers;

import bookcorner.finder.BookFinder;
import bookcorner.finder.SaleFinder;
import bookcorner.models.Book;
import bookcorner.models.Sale;
import frontEnd.TableView.ViewSalesReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SalesReportController implements Initializable {

    public DatePicker datePick;
    public TableView<ViewSalesReport> salesReportTableView;
    public TableColumn<ViewSalesReport,String> customer;
    public TableColumn<ViewSalesReport,String> time;
    public TableColumn<ViewSalesReport,Integer> transaction;
    public TableColumn<ViewSalesReport,String> saleInfo;
    public Label totalSale;

    private List<Sale> saleArrayList = new ArrayList<>();
    List<Book> bookList=new ArrayList<>();



    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/homeView.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void onViewReportClick(ActionEvent actionEvent) {
        LocalDate date=datePick.getValue();
        int day=date.getDayOfMonth();
        int month=date.getMonthValue();
        int year=date.getYear();

        SaleFinder saleFinder=new SaleFinder(day,month,year);
        saleArrayList=saleFinder.findAll();
        int totalAmount=0;

        for(Sale s:saleArrayList){
            bookList=s.getBookList();
            int total=0;
            for(Book b:bookList) {
                total += (b.getSellingPrice()*b.getQuantity());
            }
            ViewSalesReport record=new ViewSalesReport(s.getCustomer().getName(),total,s.getId(),s.getTime());
            totalAmount+=total;
            salesReportTableView.getItems().add(record);
        }

        totalSale.setText(String.valueOf(totalAmount));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        transaction.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        saleInfo.setCellValueFactory(new PropertyValueFactory<>("saleInfo"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

    public void onViewDetailsClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../../frontEnd/bookSales_reportDetails.fxml"));
        Parent root=loader.load();

        ObservableList<ViewSalesReport> salesReports,report;
        salesReports=salesReportTableView.getItems();
        report=salesReportTableView.getSelectionModel().getSelectedItems();
        String salesID = "";
        for(ViewSalesReport v:report){
            salesID=v.getSaleInfo();
        }
        SaleFinder saleFinder=new SaleFinder();
        List<Book> bookList=new ArrayList<>();
        bookList=saleFinder.findByID(salesID).getBookList();

        SaleDetailsController saleDetailsController=loader.getController();
        saleDetailsController.displayRecords(bookList);


        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();


    }
}
