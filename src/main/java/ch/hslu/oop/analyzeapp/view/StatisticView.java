package ch.hslu.oop.analyzeapp.view;

import ch.hslu.oop.analyzeapp.model.MeasurementPoint;
import ch.hslu.oop.analyzeapp.model.Temperatur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class StatisticView extends GridPane {

    private final List<EventHandler> handlerList = new ArrayList<>();
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
    private final ChoiceBox<String> statisticChoiceBox;
    //private final TableView<TemperatureFileStatistic> tableView;

    public StatisticView() {
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

        this.statisticChoiceBox = new ChoiceBox<>();
        this.add(this.statisticChoiceBox, 1, 1);

        this.statisticChoiceBox.setOnAction(actionEvent -> fireEvent(actionEvent));

        /*this.tableView = new TableView<>();
        this.tableView.autosize();
        this.add(this.tableView, 1, 1);
        initTable();*/

        this.setHgap(5);
        this.setVgap(5);
    }

    /*public void addStatistic(TemperatureFileStatistic temperatureFileStatistic){
        this.tableView.getItems().add(temperatureFileStatistic);
    }*/

    /*private void initTable() {
        TableColumn<TemperatureFileStatistic, String> statisticNameCol = new TableColumn<>("Name");
        TableColumn<TemperatureFileStatistic, MeasurementPoint> maximaCol = new TableColumn<>("Maxima");
        TableColumn<TemperatureFileStatistic, MeasurementPoint> minimaCol = new TableColumn<>("Minima");
        TableColumn<TemperatureFileStatistic, Temperatur> averageCol = new TableColumn<>("Average");
        TableColumn<TemperatureFileStatistic, Integer> numOfValuesCol = new TableColumn<>("Values");
        TableColumn<TemperatureFileStatistic, Integer> numOfConvertions = new TableColumn<>("Convertions");
        TableColumn<TemperatureFileStatistic, Integer> numOfDataExceptions = new TableColumn<>("Data Exceptions");

        this.tableView.getColumns().addAll(statisticNameCol, maximaCol, minimaCol, averageCol,
                numOfValuesCol, numOfConvertions, numOfDataExceptions);

        statisticNameCol.setCellValueFactory(new PropertyValueFactory<>("statisticName"));
        maximaCol.setCellValueFactory(new PropertyValueFactory<>("maximalMeasurementPoint"));
        minimaCol.setCellValueFactory(new PropertyValueFactory<>("minimalMeasurementPoint"));
        averageCol.setCellValueFactory(new PropertyValueFactory<>("averageTemperature"));
        numOfValuesCol.setCellValueFactory(new PropertyValueFactory<>("numOfValues"));
        numOfConvertions.setCellValueFactory((new PropertyValueFactory<>("numOfConvertions")));
        numOfDataExceptions.setCellValueFactory(new PropertyValueFactory<>("numOfDataExceptions"));
    }*/

    public void addStatisticOnChoiceBox(String statisticName) {
        this.statisticChoiceBox.getItems().add(statisticName);
    }

    public void showMaxima(MeasurementPoint measurementPoint) {
        this.maxima.setText(measurementPoint.toString());
    }

    public void showMinima(MeasurementPoint measurementPoint) {
        this.minima.setText(measurementPoint.toString());
    }

    public void showAverage(Temperatur measurementPoint) {
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

    public ChoiceBox<String> getStatisticChoiceBox() {
        return statisticChoiceBox;
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
