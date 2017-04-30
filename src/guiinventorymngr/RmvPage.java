package guiinventorymngr;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
public class RmvPage {
    static String toRmv;
    public static String display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Remove Entry");
        Button btnSubmit, btnCancel;
        TextField txtRmv;
        Label lblRmv;
        final String MR = "message_completed.wav";
        final String MF = "message_failure.wav";
        lblRmv = new Label("Name of Entry to Remove");
        final String LABEL;
        LABEL = ("-fx-font-family: Times; \n -fx-font-size: 16;");
        lblRmv.setStyle(LABEL);
        txtRmv = new TextField();
        txtRmv.setMaxWidth(170);
        btnSubmit = new Button("Remove");
        btnSubmit.setOnAction(e -> {
            Sfx.play(MR);
            toRmv = txtRmv.getText();
            window.close();
        });
        btnSubmit.setDefaultButton(true);
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e -> {
            Sfx.play(MF);
            window.close() ;
        });
        HBox btns = new HBox(10);
        btns.getChildren().addAll(btnSubmit, btnCancel);
        btns.setAlignment(Pos.CENTER);
        VBox f = new VBox(20);
        f.getChildren().addAll(lblRmv, txtRmv, btns);
        f.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(f, 300, 150);
        scene1.getStylesheets().add("guiinventorymngr/Style.css");
        window.setScene(scene1);
        window.showAndWait();
        return toRmv;
    }
}
