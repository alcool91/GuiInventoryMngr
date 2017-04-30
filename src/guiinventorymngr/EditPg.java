package guiinventorymngr;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
public class EditPg {
    static String toEdit;
    public static String display() {
        Stage window = new Stage();
        window.setTitle("Edit Entry");
        window.initModality(Modality.APPLICATION_MODAL);
        Button btnSubmit, btnCancel;
        TextField txtEdit;
        Label lblEdit;
        final String MR = "message_completed.wav";
        final String MF = "message_failure.wav";
        lblEdit = new Label("Name of Entry to Edit");
        final String LABEL;
        LABEL = ("-fx-font-family: Times; \n -fx-font-size: 16;");
        lblEdit.setStyle(LABEL);
        txtEdit = new TextField();
        txtEdit.setMaxWidth(170);
        btnSubmit = new Button("Edit");
        btnSubmit.setDefaultButton(true);
        btnSubmit.setOnAction(e -> {
            Sfx.play(MR);
            toEdit = txtEdit.getText();
            window.close();
        });
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e -> {
            Sfx.play(MF);
            window.close();
                });
        HBox btns = new HBox(10);
        btns.setAlignment(Pos.CENTER);
        btns.getChildren().addAll(btnSubmit, btnCancel);
        VBox f = new VBox(20);
        f.getChildren().addAll(lblEdit, txtEdit, btns);
        f.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(f, 300, 150);
        scene1.getStylesheets().add("guiinventorymngr/Style.css");
        window.setScene(scene1);
        window.showAndWait();
        return toEdit;
    }
}
