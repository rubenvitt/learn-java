package de.rubeen.simulations.ilsalzgitter;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    BorderPane layout;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("DEBUG: ILSalzgitter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        IntegerProperty x = new SimpleIntegerProperty(1),
                        y = new SimpleIntegerProperty();
        y.bind(x.multiply(10));
        System.out.println("x = " + x.getValue() + " | y = " + y.getValue());
        x.setValue(50);
        System.out.println("x = " + x.getValue() + " | y = " + y.getValue());

        Button button = new Button("Submit");
        StackPane layout = new StackPane(button);
        window.setScene(new Scene(layout));
        window.show();
    }

*/
    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label labelName = new Label("Username");
        GridPane.setConstraints(labelName, 0, 0);
        TextField inputName = new TextField();
        GridPane.setConstraints(inputName, 1, 0);

        Label labelPassword = new Label("Password");
        GridPane.setConstraints(labelPassword, 0, 1);
        TextField inputPassword = new TextField();
        inputPassword.setPromptText("your'e password here");
        GridPane.setConstraints(inputPassword, 1, 1);

        Button buttonLogin = new Button("Login");
        buttonLogin.setOnAction(event -> {
            window.setTitle(isInt(inputPassword.getText()) ? inputName.getText() + " || " + inputPassword.getText() : "false input");
        });
        GridPane.setConstraints(buttonLogin, 1, 2);

        Button buttonSinUp = new Button("Sin Up");
        buttonSinUp.getStyleClass().add("button-blue");
        GridPane.setConstraints(buttonSinUp, 0, 2);


        gridPane.getChildren().addAll(labelName, inputName, inputPassword, labelPassword, buttonLogin, buttonSinUp);
        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add(getClass().getResource("Rubeen.css").toString());
        window.setScene(scene);
        window.show();
    }


    private boolean isInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    */

    /*
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Menu fileMenu = new Menu("_File");
        fileMenu.getItems().addAll(new MenuItem("New..."), new MenuItem("Open..."), new MenuItem("_Save"),
                new SeparatorMenuItem(), new MenuItem("Settings..."),
                new SeparatorMenuItem(), new MenuItem("Close"));
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().addAll(new MenuItem("Cut"), new MenuItem("Copy"), new MenuItem("Paste"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        window.setScene(new Scene(layout));
        window.show();
    }
*/

    /* @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("layouts");

        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        VBox leftMenu = new VBox();
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        window.setScene(new Scene(borderPane, 300, 250));
        window.show();
    }

    */

    /*
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Multiple Windows Test");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeHandler();
        });

        Label label = new Label("Drücke den Button");
        Button button = new Button("Click me");
        button.setOnAction(event -> closeHandler());
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, button);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 300, 250);

        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        System.out.println("wird beendet");
        window.close();
    }

    private void closeHandler() {
        String negative = "nein";
        String positive = "ja";
        boolean sure = ConfirmBox.display("Möchtest du das wirklich tun?", "Möchtest du wirklich das Programm beenden?", positive, negative);
        if(sure)
            closeProgram();
        else
            AlertBox.display("Okay", "Programm wird nicht geschlossen.");
    }

    */

    public static void main(String[] args) {
        launch(args);
    }
}
