package Process;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class Controller implements Initializable {
    Double temp = 0.0D;
    String temp2 = "";
    Double temp3 = 0.0D;
    boolean isOperatorPressed;
    String operatorPressed = "";

    @FXML
    TextField outputTF;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outputTF.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            }
        });
    }

    @FXML
    private void onNumberClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button btn = (Button) event.getSource();
            if (isOperatorPressed) {
                outputTF.setText(btn.getText().trim());
            } else {
                outputTF.setText(outputTF.getText().trim() + btn.getText().trim());
            }
            isOperatorPressed = false;
        }
    }

    @FXML
    private void onOperatorClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button btn = (Button) event.getSource();
            if (temp == 0.0D) {
                temp = Double.valueOf(outputTF.getText().trim());
            }
            if (temp2 == "" && temp2 != "=") {
                temp2 = btn.getText().trim();
                outputTF.setText(temp2);
            } else {
                temp3 = Double.valueOf(outputTF.getText().trim());
                switch (temp2) {
                    case "%":
                        temp3 = (temp3 * temp) / 100;
                        break;
                    case "/":
                        temp3 = temp / temp3;
                        break;
                    case "X":
                        temp3 = temp3 * temp;
                        break;
                    case "+":
                        temp3 = temp3 + temp;
                        break;
                    case "-":
                        temp3 = temp - temp3;
                        break;
                    default:
                        temp3 = temp;
                }
                outputTF.setText(String.valueOf(temp3));
                temp= temp3;
                 temp2 = btn.getText().trim();

            }


            isOperatorPressed = true;
        }
    }

    @FXML
    private void onDELClick(ActionEvent event) {
        if (outputTF.getText().length() > 0) {
            outputTF.setText(outputTF.getText(0, outputTF.getText().length() - 1));
        }
    }

    @FXML
    private void onCEClick(ActionEvent event) {
        outputTF.setText("");
        temp = 0.0;
        temp2 = "";
        temp3 = 0.0;
        isOperatorPressed = false;
        operatorPressed = "";
    }


}
