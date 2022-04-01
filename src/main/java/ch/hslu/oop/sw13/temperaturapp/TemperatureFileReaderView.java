package ch.hslu.oop.sw13.temperaturapp;

import ch.hslu.oop.sw11.MeasurementPoint;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TemperatureFileReaderView extends GridPane {

    private final List<EventHandler> handlerList = new ArrayList<>();

    private final Button chooseBtn;
    private final Button analyzeBtn;
    private final Label fileLabel;
    private final Label maximaLabel;
    private final Label maxima;
    private final Label minimaLabel;
    private final Label minima;
    private final Label averageLabel;
    private final Label average;
    private final Label numOfValuesLabel;
    private final Label numOfValues;
    private final Label numOfMeasurementPointConvertionLabel;
    private final Label numOfMeasurementPointConvertion;
    private final Label numOfDataExceptionLabel;
    private final Label numOfDataException;
    private final Label progressBarLabel;
    private final ProgressBar progressBar;
    private final ProgressIndicator progressIndicator;

    public TemperatureFileReaderView() {
        this.chooseBtn = new Button("choose File");
        this.chooseBtn.setOnAction(actionEvent -> fireEvent(actionEvent));
        this.add(this.chooseBtn, 1, 1);

        this.fileLabel = new Label();
        this.add(this.fileLabel, 2, 1);

        this.analyzeBtn = new Button("analyze File");
        this.analyzeBtn.setOnAction(actionEvent -> fireEvent(actionEvent));
        this.add(this.analyzeBtn, 1, 2);

        this.maximaLabel = new Label("Maxima:");
        this.add(this.maximaLabel, 1, 3);

        this.maxima = new Label();
        this.add(this.maxima, 2, 3);

        this.minimaLabel = new Label("Minima:");
        this.add(this.minimaLabel, 1, 4);

        this.minima = new Label();
        this.add(this.minima, 2, 4);

        this.averageLabel = new Label("Average:");
        this.add(this.averageLabel, 1, 5);

        this.average = new Label();
        this.add(this.average, 2, 5);

        this.numOfValuesLabel = new Label("Values:");
        this.add(this.numOfValuesLabel, 1, 6);

        this.numOfValues = new Label();
        this.add(this.numOfValues, 2, 6);

        this.numOfMeasurementPointConvertionLabel = new Label("Convertions:");
        this.add(this.numOfMeasurementPointConvertionLabel, 1, 7);

        this.numOfMeasurementPointConvertion = new Label();
        this.add(this.numOfMeasurementPointConvertion, 2, 7);

        this.numOfDataExceptionLabel = new Label("Data Exceptions:");
        this.add(this.numOfDataExceptionLabel, 1, 8);

        this.numOfDataException = new Label();
        this.add(this.numOfDataException, 2, 8);

        this.progressBarLabel = new Label("Progress:");
        this.add(this.progressBarLabel, 1, 9);

        this.progressBar = new ProgressBar(0);
        this.add(this.progressBar, 2, 9);

        this.progressIndicator = new ProgressIndicator(0);
        this.add(this.progressIndicator, 3, 9);

        this.setHgap(5);
        this.setVgap(5);
    }

    public void showFile(File file) {
        this.fileLabel.setText(file.toString());
    }

    public void showMaxima(MeasurementPoint measurementPoint) {
        this.maxima.setText(measurementPoint.toString());
    }

    public void showMinima(MeasurementPoint measurementPoint) {
        this.minima.setText(measurementPoint.toString());
    }

    public void showAverage(MeasurementPoint measurementPoint) {
        this.average.setText(measurementPoint.toString());
    }

    public void showAverageNA() {
        this.average.setText("N/A");
    }

    public void showMinimaNA() {
        this.minima.setText("N/A");
    }

    public void showMaximaNA() {
        this.maxima.setText("N/A");
    }

    public void showNumOfValues(int value) {
        this.numOfValues.setText(String.valueOf(value));
    }

    public void showNumOfMeasurementPointConvertion(int value) {
        this.numOfMeasurementPointConvertion.setText(String.valueOf(value));
    }

    public void showNumOfDataException(int value) {
        this.numOfDataException.setText(String.valueOf(value));
    }

    public void changeProgress(double value) {
        this.progressBar.setProgress(value);
        this.progressIndicator.setProgress(value);
    }

    public void addEventHandler(EventHandler<ActionEvent> handler) {
        if (handler != null) {
            this.handlerList.add(handler);
        } else {
            throw new NullPointerException();
        }
    }

    public void removeEventHandler(EventHandler<ActionEvent> handler) {
        if (handler != null) {
            this.handlerList.remove(handler);
        } else {
            throw new NullPointerException();
        }
    }

    private void fireEvent(ActionEvent actionEvent) {
        if (this.handlerList.size() > 0) {
            for (EventHandler<ActionEvent> handler : this.handlerList) {
                handler.handle(actionEvent);
            }
        }
    }

    public void disableAnalyzeBtn() {
        this.analyzeBtn.setDisable(true);
    }

    public void enableAnalyteBtn() {
        this.analyzeBtn.setDisable(false);
    }

    public Button getChooseBtn() {
        return chooseBtn;
    }

    public Button getAnalyzeBtn() {
        return analyzeBtn;
    }

    public int getNumOfValues() {
        return Integer.parseInt(this.numOfValues.getText());
    }

    public int getNumOfMeasurementPointConvertion() {
        return Integer.parseInt(this.numOfMeasurementPointConvertion.getText());
    }

    public int getNumOfDataException() {
        return Integer.parseInt(this.numOfDataException.getText());
    }
}
