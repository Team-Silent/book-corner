package bookcorner.Controllers;

import bookcorner.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewBookController {

    @FXML private TextField sellingPrice;
    @FXML private TextField author;
    @FXML private TextField purchasingPrice;
    @FXML private TextField stockQuantity;
    @FXML private TextField bookTitle;

    Book book;

    public void onAddClick(ActionEvent event) {

        String title=bookTitle.getText();
        String bookAuthor=author.getText();
        int purchase=0,sell=0,quantity=0;
        try {
             purchase=Integer.parseInt(purchasingPrice.getText());
             sell=Integer.parseInt(sellingPrice.getText());
             quantity=Integer.parseInt(stockQuantity.getText());
        }
        catch (NumberFormatException e){
            System.out.println(e);
            System.out.println("Incorrect Values");
            return;
        }

//        System.out.println(title+" "+bookAuthor+" "+purchase+" "+sell+" "+quantity);

        // Creating new book
        book=new Book(title,bookAuthor,purchase,sell,quantity);
        book.saveToDatabase();
        // Clear everything
        bookTitle.clear();
        author.clear();
        purchasingPrice.clear();
        sellingPrice.clear();
        stockQuantity.clear();

    }



    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent saleReportView= FXMLLoader.load(getClass().getResource("../../frontEnd/homeView.fxml"));
        Scene scene=new Scene(saleReportView);

        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
