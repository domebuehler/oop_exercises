package ch.hslu.oop.sw13.motorapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class MotorControl extends Application implements EventHandler<ActionEvent>, PropertyChangeListener,
        ReachedMaxRpmEventListener {

    private static final Logger LOG = LogManager.getLogger(MotorControl.class);

    private Motor motor;
    private MotorView motorView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.motor = new Motor();
        this.motorView = new MotorView();
        this.motorView.addEventHandler(this);
        this.motor.addPropertyChangeListener(motorView);
        this.motor.addPropertyChangeListener(this);
        this.motor.addReachedMaxRmpEventListener(this);

        initView();

        Scene scene = new Scene(this.motorView);
        stage.setScene(scene);
        stage.setTitle("Motor-App");
        stage.show();
    }

    private void initView() {
        if (this.motor.isSwitchedOff()) {
            motorView.showMotorOff();
            initViewSwitchOn();
        } else if (motor.isSwitchedOn()) {
            motorView.showMotorOn();
            initViewSwitchOff();
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.motorView.getBtnOn())) {
            handelMotorOnClick();
        } else if (actionEvent.getSource().equals(this.motorView.getBtnOff())) {
            handelMotorOffClick();
        } else if (actionEvent.getSource().equals(this.motorView.getBtnReset())) {
            resetMotor();
        } else if (actionEvent.getSource().equals(this.motorView.getBtnIncrease())) {
            increaseRPM();
        } else if (actionEvent.getSource().equals(this.motorView.getBtnDecrease())) {
            decreaseRPM();
        }
    }

    private void decreaseRPM() {
        LOG.info("decrease");
        this.motor.decreaseRpm();
    }

    private void increaseRPM() {
        LOG.info("increase");
        this.motor.increaseRpm();
    }

    private void resetMotor() {
        LOG.info("reset");
        this.motor.resetMotor();
    }

    private void handelMotorOnClick() {
        LOG.info("motor on");
        this.motor.switchOn();
    }

    private void handelMotorOffClick() {
        LOG.info("motor off");
        this.motor.switchOff();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() == MotorState.FAILURE) {
            initViewReset();
        } else if (evt.getNewValue() == MotorState.OFF) {
            initViewSwitchOn();
        } else if (evt.getNewValue() == MotorState.ON) {
            initViewSwitchOff();
        }
    }

    @Override
    public void handleRpmEvent(ReachedMaxRpmEvent event) {
        showAlertMaxReached();
    }

    private void showAlertMaxReached() {
        this.motorView.showAlert("Warning", "Warning regarding RPM", "max RPM is reached!");
    }

    private void initViewSwitchOn() {
        motorView.enableOnBtn();
        motorView.disableOffBtn();
        motorView.disableResetBtn();
        motorView.disableManipulateButtons();
    }

    private void initViewSwitchOff() {
        motorView.enableOffBtn();
        motorView.disableOnBtn();
        motorView.disableResetBtn();
        motorView.enableManipulateButtons();
    }

    private void initViewReset() {
        motorView.enableResetBtn();
        motorView.disableOnBtn();
        motorView.disableOffBtn();
    }
}