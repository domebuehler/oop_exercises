package ch.hslu.oop.sw13.temperaturapp;

import ch.hslu.oop.sw11.MeasurementPoint;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Map;

public class TemperatureFileReaderControl extends Application implements EventHandler<ActionEvent>,
        PropertyChangeListener {

    private FileChooser fileChooser;
    private File file;
    private Stage stage;
    private TemperatureFileReaderView view;

    private static final Logger LOG = LogManager.getLogger(TemperatureFileReaderControl.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.view = new TemperatureFileReaderView();
        view.addEventHandler(this);

        initView();

        Scene scene = new Scene(this.view, 500, 300);
        stage.setScene(scene);
        stage.setTitle("Temperatur-App");
        stage.show();
    }

    private void initView() {
        this.view.disableAnalyzeBtn();
    }

    private void initViewBeforeAnalyze() {
        this.view.showAverageNA();
        this.view.showMaximaNA();
        this.view.showMinimaNA();
        this.view.showNumOfValues(0);
        this.view.showNumOfMeasurementPointConvertion(0);
        this.view.showNumOfDataException(0);
        this.view.changeProgress(0);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.view.getChooseBtn())) {
            chooseFileSequence();
        } else if (actionEvent.getSource().equals(this.view.getAnalyzeBtn())) {
            if (this.file != null) {
                analyzeFile();
            }
        }
    }

    private void analyzeFile() {
        initViewBeforeAnalyze();
        TemperaturFileAnalyzer temperaturFileAnalyzer = new TemperaturFileAnalyzer();
        temperaturFileAnalyzer.addPropertyChangeListener(this);
        Map<String, MeasurementPoint> map = temperaturFileAnalyzer.analyzeFile(this.file);
        processMapWithMeasurementPoints(map);
    }

    private void processMapWithMeasurementPoints(Map<String, MeasurementPoint> map) {
        processMaxima(map.get("maxima"));
        processMinima(map.get("minima"));
        processAverage(map.get("average"));
    }

    private void processAverage(MeasurementPoint average) {
        if (average.getTemperatur() != null) {
            this.view.showAverage(average);
        } else {
            this.view.showAverageNA();
        }
    }

    private void processMinima(MeasurementPoint minima) {
        if (minima != null) {
            this.view.showMinima(minima);
        } else {
            this.view.showMinimaNA();
        }
    }

    private void processMaxima(MeasurementPoint maxima) {
        if (maxima != null) {
            this.view.showMaxima(maxima);
        } else {
            this.view.showMaximaNA();
        }
    }

    private void chooseFileSequence() {
        this.fileChooser = new FileChooser();
        this.fileChooser.setTitle("Choose Temperature File");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV", "*.csv");
        this.fileChooser.getExtensionFilters().add(extensionFilter);
        this.file = this.fileChooser.showOpenDialog(this.stage);

        if (this.file != null) {
            this.view.showFile(new File(this.file.toString()));
            this.view.enableAnalyteBtn();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equalsIgnoreCase("numbOfValues")) {
            handleNumbOfValues(Integer.valueOf(evt.getNewValue().toString()));
        } else if (evt.getPropertyName().equalsIgnoreCase("numOfMeasurementPointConvertion")) {
            handleNumOfMeasurementPointConvertion(Integer.valueOf(evt.getNewValue().toString()));
        } else if (evt.getPropertyName().equalsIgnoreCase("numbOfDataException")) {
            handleNumOfDataException(Integer.valueOf(evt.getNewValue().toString()));
        }
    }

    private void handleNumOfDataException(int newValue) {
        this.view.showNumOfDataException(newValue);
        updateProgressBar();
    }

    private void handleNumOfMeasurementPointConvertion(int newValue) {
        this.view.showNumOfMeasurementPointConvertion(newValue);
        updateProgressBar();
    }

    private void handleNumbOfValues(int newValue) {
        this.view.showNumOfValues(newValue);
    }

    private void updateProgressBar() {
        int numOfValues = this.view.getNumOfValues();
        int processedValues = this.view.getNumOfDataException() + this.view.getNumOfMeasurementPointConvertion();
        double progress = (double) processedValues / numOfValues;
        LOG.info(progress);
        this.view.changeProgress(progress);
    }
}
