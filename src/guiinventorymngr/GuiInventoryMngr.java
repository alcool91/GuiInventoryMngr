package guiinventorymngr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
/*Written by Allen Williams and Dustin Fitzpatrick
  Manages inventory using a text file and provides 
  the user with basic functionality*/
public class GuiInventoryMngr extends Application {
    public Inventory list = new Inventory();
    
    @Override
    public void start(Stage primaryStage) {

        Button btnAdd, btnList, btnFind, btnRmv, btnEdit, btnQuit;
        TextArea output = new TextArea();
        output.setEditable(false);
        final String FILENAME = "list.txt";
        Label lblWelcome;
        try{
            list.populate(FILENAME);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        output.setPrefHeight(200);
        output.setPrefWidth(200);
        lblWelcome = new Label("Inventory Management");
        btnAdd = new Button("Add Item");
        btnAdd.setMaxWidth(150);
        btnList = new Button("List Items");
        btnList.setMaxWidth(150);
        btnFind = new Button("Find Item");
        btnFind.setMaxWidth(150);
        btnRmv = new Button("Remove Item");
        btnRmv.setMaxWidth(150);
        btnEdit = new Button("Edit Item Entry");
        btnEdit.setMaxWidth(150);
        btnQuit = new Button("Quit");
        btnQuit.setMaxWidth(150);
        VBox btns = new VBox(20);
        final String MR = "message_completed.wav";
        final String MF = "message_failure.wav";
        btns.getChildren().addAll(btnAdd, btnList, btnFind, btnRmv, 
                btnEdit, btnQuit);
        btns.setAlignment(Pos.CENTER_LEFT);
        btns.setTranslateX(10);
        
        btnFind.setOnAction(e -> {
            final String NAME;
            NAME = FindPage.display();
            try {
                if(list.Find(NAME) >= -1) {
                    output.setText("");
                    listEntry(list.Find(NAME), output);
                }
                else
                    output.setText(NAME + " Not Found.");
            } catch(Exception exc) {
                System.err.println(exc.getMessage());
            };
        });
        btnEdit.setOnAction(e -> {
            final int index;
            final String toEdit;
            final Entry holder;
            toEdit = EditPg.display();
            try {
                index = list.Find(toEdit);
                if (index < 0)
                    AlertBox.display(toEdit + " Not Found");
                else {
                    holder = EditPg2.display(toEdit);
                    list.setQnty(index, holder.getNumber());
                    list.setNotes(index, holder.getNotes());
                    Entry.decrement();
                }
            } catch(Exception nf){
                System.err.println(nf.getMessage());
            }
        });
        
        btnList.setOnAction(e -> {
            output.setText("");
            for(int i = 0; i < list.getNumEntries(); i++) {
                listEntry(i, output);
            }
        });
        
        btnAdd.setOnAction(e -> {
            try {
                int a;
                a = list.add(AddPage.display());
                if (a == 1)
                    AlertBox.display("Names Should be 1-8 Characters");
                else if (a == 2)
                    AlertBox.display("Entry Already Exists");
            } catch(Exception a){
                System.err.println(a.getMessage());
            };
                
            
        });
        
        btnRmv.setOnAction(e -> {
            try {
                list.remove(list.Find(RmvPage.display()));
            } catch(Exception r) {
                System.err.println(r.getMessage());
            }
        });
        
        btnQuit.setOnAction(e -> {
            try {
                list.save(FILENAME);
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
            primaryStage.close();});
        
        VBox welcome = new VBox(80);
        welcome.getChildren().addAll(lblWelcome, output);
        lblWelcome.setTranslateY(30);
        lblWelcome.setTranslateX(-13.5);
        lblWelcome.setId("Welcome");
        welcome.setAlignment(Pos.TOP_RIGHT);
        HBox root = new HBox(100);
        root.getChildren().addAll(btns, welcome);
        root.setId("main");
        Scene scene = new Scene(root, 600, 350);
        scene.getStylesheets().add("guiinventorymngr/Style.css");
        primaryStage.setTitle("Inventory Manager");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(
                "guiinventorymngr/Resources/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    void listEntry(int index, TextArea output) {
        output.appendText("--" + list.getName(index) + "\n" + 
                          "--" + list.getQnty(index) + "\n" +
                          "--" + list.getNotes(index) + "\n\n");        
    }
}
