package com.example.druzhinina_120_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.util.Objects;

public class HelloController {
    boolean forResult = true;
    double x = 0;
    double y = 0;
    double r = -999999991.12313243454546567676768778977453;
    String plusminus="";
    private String xAsString = "";
    @FXML
    private String yAsString = "";
    @FXML
    private Label resultWindow;
    @FXML
    private Button reset;
    @FXML
    private Button result;
    @FXML
    protected void proccesingForButtonResult() {
        if (forResult) {
            getResult();
            forResult=false;
        } else {resultWindow.setText(String.valueOf(r));}

    }
    //попробовать вынести в отдельный класс
    protected void getResult() {
        if (Objects.equals(plusminus, "")) {
            r=x;
        } else {
            if (Objects.equals(plusminus, "+")) {
                r = x + y;
                plusminus = "";
            } else if (Objects.equals(plusminus, "-")) {
                r = x - y;
                plusminus = "";
            } else if (Objects.equals(plusminus, "/")) {
                r = x / y;
                plusminus = "";
            } else if (Objects.equals(plusminus, "*")) {
                r = x * y;
                plusminus = "";
            }

        } resultWindow.setText(String.valueOf(r));
        xAsString = "";
        yAsString = "";
        y = 0;
        x = r;
    }
    @FXML
    protected void resultPlus() {
        if (y!=0 || r == -999999991.12313243454546567676768778977453 ) {
            getResult();
            plusminus = "+";
            x = r;
        } else {plusminus = "+";xAsString = "";
            yAsString = "";}
    }
    @FXML
    protected void resultMinus() {
        if (y!=0 || r == -999999991.12313243454546567676768778977453 ) {
            getResult();
        plusminus = "-";
        x=r;
        y=0; } else {plusminus = "-";xAsString = "";
        yAsString = "";}
    }
    @FXML
    protected void resultDivision() {
        if (y!=0 || r == -999999991.12313243454546567676768778977453 ) {
            getResult();
        plusminus = "/";
        x=r;
        } else {plusminus = "/";xAsString = "";
            yAsString = "";}
    }
    @FXML
    protected void resultMultiplication() {
        if (y!=0 || r == -999999991.12313243454546567676768778977453 ) {
            getResult();
        plusminus = "*";
        x=r;
        } else {plusminus = "*";xAsString = "";
            yAsString = "";}
    }
    @FXML
    protected double resultNull() {
        r = -999999991.12313243454546567676768778977453;
        reset.addEventHandler(MouseEvent.MOUSE_CLICKED, (mouseEvent -> resultWindow.setText("")));
        x = 0;
        y = 0;
        plusminus = "";
        xAsString = "";
        return x;
    }
    @FXML
    protected void yValue(ActionEvent event) {
        if (r == -999999991.12313243454546567676768778977453) {
                xAsString += ((Button) event.getSource()).getText();
                x = Double.parseDouble(xAsString);
                resultWindow.setText(String.valueOf(x));
                forResult=true;
        } else { x=r;
                yAsString += ((Button) event.getSource()).getText();
                y = Double.parseDouble(yAsString);
                resultWindow.setText(String.valueOf(y));
                forResult=true;
            }
    }
}
