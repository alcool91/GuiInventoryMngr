package guiinventorymngr;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
public class AlertBox {
    public static void display(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Button btnSubmit;
        Label lblMsg;
        final String MR = "message_completed.wav";
        lblMsg = new Label(message);
        btnSubmit = new Button("OK");
        btnSubmit.setDefaultButton(true);
        btnSubmit.setOnAction(e -> {
            Sfx.play(MR);
            window.close();
        });
        GridPane G = new GridPane();
        G.add(lblMsg, 0, 0);
        G.add(btnSubmit, 0, 1);
        G.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(G, 345, 150);
        scene1.getStylesheets().add("guiinventorymngr/Style.css");
        window.setScene(scene1);
        window.showAndWait();
    }
}