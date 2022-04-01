package ch.hslu.oop.sw13.motorapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("DuplicatedCode")
public final class MotorView extends HBox implements PropertyChangeListener {

    private static final Logger LOG = LogManager.getLogger(MotorView.class);
    private final List<EventHandler> eventHandlers = new ArrayList<>();

    private final Label stateLabel;
    private final Label rpmLabel;
    private final Button btnOn;
    private final Button btnOff;
    private final Button btnReset;
    private final Button btnIncrease;
    private final Button btnDecrease;
    private final VBox switchButtonsContainer;
    private final VBox manipulateButtonsContainer;
    private final VBox labelContainer;
    private Alert alert;

    public MotorView() {
        this.stateLabel = new Label();
        this.rpmLabel = new Label();

        this.labelContainer = new VBox();
        this.labelContainer.getChildren().addAll(stateLabel, rpmLabel);

        this.btnOn = new Button("On");
        this.btnOn.setOnAction(actionEvent -> fireEvent(actionEvent));

        this.btnOff = new Button("Off");
        this.btnOff.setOnAction(actionEvent -> fireEvent(actionEvent));

        this.btnReset = new Button("Reset");
        this.btnReset.setOnAction(actionEvent -> fireEvent(actionEvent));

        this.switchButtonsContainer = new VBox();
        this.switchButtonsContainer.getChildren().addAll(btnOn, btnReset, btnOff);

        this.btnIncrease = new Button("increase rpm");
        this.btnIncrease.setOnAction(actionEvent -> fireEvent(actionEvent));

        this.btnDecrease = new Button("decrease rpm");
        this.btnDecrease.setOnAction(actionEvent -> fireEvent(actionEvent));

        this.manipulateButtonsContainer = new VBox();
        this.manipulateButtonsContainer.getChildren().addAll(btnIncrease, btnDecrease);

        this.getChildren().addAll(switchButtonsContainer, labelContainer, manipulateButtonsContainer);
    }

    public void addEventHandler(final EventHandler<ActionEvent> eventHandler) {
        if (eventHandler != null) {
            eventHandlers.add(eventHandler);
        } else {
            throw new NullPointerException("eventHandler was null");
        }
    }

    public void removeEventHandler(final EventHandler<ActionEvent> eventHandler) {
        if (eventHandler != null) {
            eventHandlers.remove(eventHandler);
        } else {
            throw new NullPointerException("listener was null");
        }
    }

    public void fireEvent(ActionEvent event) {
        for (EventHandler<ActionEvent> eventHandler : eventHandlers) {
            eventHandler.handle(event);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() == MotorState.ON) {
            showMotorOn();
        } else if (evt.getNewValue() == MotorState.OFF) {
            showMotorOff();
        } else if (evt.getNewValue() == MotorState.FAILURE) {
            showMotorError();
        } else if (evt.getPropertyName().equals("rpm")) {
            showRpm(Integer.valueOf(evt.getNewValue().toString()));
        }
    }

    public void showMotorOn() {
        this.stateLabel.setText("motor is on");
        this.stateLabel.setStyle("-fx-background-color: lightgreen;");
    }

    public void showMotorOff() {
        this.stateLabel.setText("motor is off");
        this.stateLabel.setStyle("-fx-background-color: red;");
    }

    public void showMotorError() {
        this.stateLabel.setText("ERROR");
        this.stateLabel.setStyle("-fx-background-color: red;");
    }

    public void showRpm(final int newValue) {
        this.rpmLabel.setText(String.valueOf(newValue));
    }

    public void showAlert(String title, String header, String content) {
        this.alert = new Alert(Alert.AlertType.WARNING);
        this.alert.setTitle(title);
        this.alert.setHeaderText(header);
        this.alert.setContentText(content);
        this.alert.show();
    }

    public void enableManipulateButtons() {
        this.btnDecrease.setDisable(false);
        this.btnIncrease.setDisable(false);
    }

    public void disableManipulateButtons() {
        this.btnDecrease.setDisable(true);
        this.btnIncrease.setDisable(true);
    }

    public void enableOnBtn() {
        this.btnOn.setDisable(false);
    }

    public void disableOnBtn() {
        this.btnOn.setDisable(true);
    }

    public void enableOffBtn() {
        this.btnOff.setDisable(false);
    }

    public void disableOffBtn() {
        this.btnOff.setDisable(true);
    }

    public void enableResetBtn() {
        this.btnReset.setDisable(false);
    }

    public void disableResetBtn() {
        this.btnReset.setDisable(true);
    }

    public Button getBtnOn() {
        return btnOn;
    }

    public Button getBtnOff() {
        return btnOff;
    }

    public Button getBtnReset() {
        return btnReset;
    }

    public Button getBtnIncrease() {
        return btnIncrease;
    }

    public Button getBtnDecrease() {
        return btnDecrease;
    }
}