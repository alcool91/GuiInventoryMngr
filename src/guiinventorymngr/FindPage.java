package guiinventorymngr;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
public class FindPage {
    static String toFind;
    public static String display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Find Entry");
        Button btnSubmit, btnCancel;
        TextField txtFnd;
        Label lblFind;
        final String MR = "message_completed.wav";
        lblFind = new Label("Name of Entry to Find");
        final String LABEL;
        LABEL = ("-fx-font-family: Times; \n -fx-font-size: 16;");
        lblFind.setStyle(LABEL);
        txtFnd = new TextField();
        txtFnd.setMaxWidth(170);
        btnSubmit = new Button("Find");
        btnSubmit.setDefaultButton(true);
        btnSubmit.setOnAction(e -> {
            Sfx.play(MR);
            toFind = txtFnd.getText();
            window.close();
        });
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e -> {
            Sfx.play(MF);
            window.close();
                });
        HBox btns = new HBox(10);
        btns.getChildren().addAll(btnSubmit, btnCancel);
        btns.setAlignment(Pos.CENTER);
        VBox f = new VBox(20);
        f.getChildren().addAll(lblFind, txtFnd, btns);
        f.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(f, 300, 150);
        scene1.getStylesheets().add("guiinventorymngr/Style.css");
        window.setScene(scene1);
        window.showAndWait();
        return toFind;
    }
}
