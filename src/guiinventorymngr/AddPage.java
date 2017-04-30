package guiinventorymngr;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class AddPage{
    static Entry addition;
    
    public static Entry display() {
        Stage additionStage = new Stage();
        additionStage.initModality(Modality.APPLICATION_MODAL);
        final String MR = "message_completed.wav";
        final String MF = "message_failure.wav";
        additionStage.setTitle("Add Entry");
        Label lblName, lblQnty, lblNotes, lblAdd;
        Button btnSubmit, btnCancel;
        TextField txtName, txtQnty, txtNotes;
        lblAdd = new Label("Add Entry");
        lblAdd.setAlignment(Pos.CENTER);
        lblAdd.setStyle("-fx-underline: true");
        lblName = new Label("Name: ");
        txtName = new TextField();
        lblQnty = new Label("Quantity: ");
        txtQnty = new TextField();
        lblNotes = new Label("Notes: ");
        txtNotes = new TextField();
        btnSubmit = new Button("Submit");
        addition = null;
        btnSubmit.setOnAction(e -> {
            Sfx.play(MR);
            addition = new Entry(txtName.getText(), txtQnty.getText(),
                            txtNotes.getText());
            additionStage.close();
        });
        btnSubmit.setDefaultButton(true);
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e -> {
            Sfx.play(MF);
            additionStage.close();
                });

        GridPane fields = new GridPane();
        fields.setAlignment(Pos.CENTER);
        fields.setHgap(7);
        fields.setVgap(10);
        fields.add(lblName, 0, 0);
        fields.add(txtName, 1, 0);
        fields.add(lblQnty, 0, 1);
        fields.add(txtQnty, 1, 1);
        fields.add(lblNotes, 0, 2);
        fields.add(txtNotes, 1, 2);
        final String BORDER = ("-fx-border-color: black;\n " + 
                "-fx-border-style: solid;\n -fx-border-width: 2;\n " + 
                "-fx-border-insets: 3;");        
        HBox btns = new HBox(10);
        btns.getChildren().addAll(btnSubmit, btnCancel);
        btns.setAlignment(Pos.CENTER);
        btns.setTranslateX(15);
        VBox s = new VBox(20);
        s.getChildren().addAll(lblAdd, fields, btns);
        s.setAlignment(Pos.CENTER);
        s.setStyle(BORDER);
        Scene scene1 = new Scene(s, 300, 300);
        scene1.getStylesheets().add("guiinventorymngr/Style.css");
        additionStage.setScene(scene1);
        additionStage.showAndWait();
        
        return addition;
    }

    
}
