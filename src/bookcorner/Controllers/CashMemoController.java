package bookcorner.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CashMemoController {
    public Label cust_name;
    public Label cust_add;
    public Label issueDate;
    public Label invoiceTotal;

    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/homeView.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void displayInfo(String name,String address){
         cust_name.setText(name);
         cust_add.setText(address);
    }

}
