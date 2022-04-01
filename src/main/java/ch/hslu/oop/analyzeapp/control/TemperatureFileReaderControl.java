package ch.hslu.oop.analyzeapp.control;

import ch.hslu.oop.analyzeapp.model.TemperatureFileStatistic;
import ch.hslu.oop.analyzeapp.view.MainView;
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
import java.util.HashMap;
import java.util.Map;

public class TemperatureFileReaderControl extends Application implements EventHandler<ActionEvent>,
        PropertyChangeListener {

    private FileChooser fileChooser;
    private File file;
    private Stage stage;
    private MainView view;
    private int currentNumOfValues;
    private int currentNumOfConvertions;
    private int currentNumOfDataExceptions;
    private Map<String, TemperatureFileStatistic> statisticMap;

    private static final Logger LOG = LogManager.getLogger(TemperatureFileReaderControl.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.view = new MainView();
        view.addEventHandler(this);
        this.statisticMap = new HashMap<>();
        clearAnalyzeView();

        Scene scene = new Scene(this.view, 500, 300);
        stage.setScene(scene);
        stage.setTitle("Temperatur-App");
        stage.show();
    }

    private void clearAnalyzeView() {
        disableAnalyzeBtn();
        this.view.getAnalyzeView().disableClearBtn();
        this.view.getAnalyzeView().changeProgress(0);
        this.view.getAnalyzeView().clearFile();
        this.view.getAnalyzeView().setStatisticNameTextField("type here...");
        this.view.getAnalyzeView().setInfoText("");
    }

    private void disableAnalyzeBtn() {
        this.view.getAnalyzeView().disableAnalyzeBtn();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.view.getAnalyzeView().getChooseBtn())) {
            chooseFileSequence();
        } else if (actionEvent.getSource().equals(this.view.getAnalyzeView().getAnalyzeBtn())) {
            if (this.file != null) {
                analyzeFile();
            }
        } else if (actionEvent.getSource().equals(this.view.getStatisticView().getStatisticChoiceBox())) {
            showStatistic(this.view.getStatisticView().getStatisticChoiceBox().getSelectionModel().getSelectedItem());
        } else if (actionEvent.getSource().equals(this.view.getAnalyzeView().getClearBtn())) {
            clearAnalyzeView();
        }
    }

    private void analyzeFile() {
        String statisticName = getStatisticName();
        if (!statisticName.equalsIgnoreCase("invalid")) {
            startTheAnalysis(statisticName);
        } else {
            printInvalidStatisticMessage();
        }
    }

    private void startTheAnalysis(String statisticName) {
        TemperaturFileAnalyzer temperaturFileAnalyzer = new TemperaturFileAnalyzer();
        TemperatureFileStatistic statistic = temperaturFileAnalyzer.analyzeFile(this.file, statisticName, this);
        this.statisticMap.put(statisticName, statistic);
        this.view.getStatisticView().addStatisticOnChoiceBox(statisticName);
        printAnalysisSuccessfully();
        disableAnalyzeBtn();
        this.view.getAnalyzeView().enableClearBtn();
    }

    private String getStatisticName() {
        String statisticName = this.view.getAnalyzeView().getStaticName();
        if (statisticName != null && !statisticName.equalsIgnoreCase("type here...")) {
            statisticName = checkForValidStatisticName(statisticName);
            return statisticName;
        } else {
            return "invalid";
        }
    }

    private String checkForValidStatisticName(String statisticName) {
        if (this.statisticMap.containsKey(statisticName)) {
            return "invalid";
        } else {
            return statisticName;
        }
    }

    private void printInvalidStatisticMessage() {
        this.view.getAnalyzeView().setInfoText("please enter a valid name!");
    }

    private void printAnalysisSuccessfully() {
        this.view.getAnalyzeView().setInfoText("analysis was successful - click clear to continue");
    }

    private void chooseFileSequence() {
        this.fileChooser = new FileChooser();
        this.fileChooser.setTitle("Choose Temperature File");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV", "*.csv");
        this.fileChooser.getExtensionFilters().add(extensionFilter);
        this.file = this.fileChooser.showOpenDialog(this.stage);

        if (this.file != null) {
            this.view.getAnalyzeView().showFile(new File(this.file.toString()));
            this.view.getAnalyzeView().enableAnalyzeBtn();
        }
    }

    private void showStatistic(String selectedItem) {
        TemperatureFileStatistic selected = this.statisticMap.get(selectedItem);
        this.view.getStatisticView().showMaxima(selected.getMaximalMeasurementPoint());
        this.view.getStatisticView().showMinima(selected.getMinimalMeasurementPoint());
        this.view.getStatisticView().showAverage(selected.getAverageTemperature());
        this.view.getStatisticView().showNumOfValues(selected.getNumOfValues());
        this.view.getStatisticView().showNumOfDataException(selected.getNumOfDataExceptions());
        this.view.getStatisticView().showNumOfMeasurementPointConvertion(selected.getNumOfConvertions());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().getClass().getSimpleName().equalsIgnoreCase("TemperatureFileStatistic")) {
            updateProgressBar(evt);
        }
    }

    private void updateProgressBar(PropertyChangeEvent event) {
        checkEventTyp(event);
        int processedValues = this.currentNumOfConvertions + this.currentNumOfDataExceptions;
        double progress = (double) processedValues / this.currentNumOfValues;
        this.view.getAnalyzeView().changeProgress(progress);
    }

    private void checkEventTyp(PropertyChangeEvent event) {
        if (event.getPropertyName().equalsIgnoreCase("numOfValues")) {
            handleNumOfValuesEvent(event);
        } else if (event.getPropertyName().equalsIgnoreCase("numOfConvertions")) {
            handleNumOfConvertionsEvent(event);
        } else if (event.getPropertyName().equalsIgnoreCase("numOfDataExceptions")) {
            handleNumOfDataExceptionsEvent(event);
        }
    }

    private void handleNumOfDataExceptionsEvent(PropertyChangeEvent event) {
        this.currentNumOfDataExceptions = Integer.valueOf(event.getNewValue().toString());
    }

    private void handleNumOfConvertionsEvent(PropertyChangeEvent event) {
        this.currentNumOfConvertions = Integer.valueOf(event.getNewValue().toString());
    }

    private void handleNumOfValuesEvent(PropertyChangeEvent event) {
        this.currentNumOfValues = Integer.valueOf(event.getNewValue().toString());
    }
}
