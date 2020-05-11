package de.rubeen.simulations.ilsalzgitter;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Ruben Vitt - 14.02.17.
 */
public class ConfirmBox {

    private static boolean answer;

    public static boolean display(String title, String message, String optionPositive, String optionNegative) {
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button btnPos = new Button(optionPositive);
        Button btnNeg = new Button(optionNegative);
        btnPos.setOnAction(event -> {
            answer = true;
            window.close();
        });
        btnNeg.setOnAction(event -> {
            answer = false;
            window.close();
        });

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, btnPos, btnNeg);
        vBox.setAlignment(Pos.CENTER);

        window.setScene(new Scene(vBox));
        window.showAndWait();

        return answer;
    }
}
