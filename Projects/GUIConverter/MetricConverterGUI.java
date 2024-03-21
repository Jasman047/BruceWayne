import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverterGUI extends Application {
    private TextField inputField;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label inputLabel = new Label("Enter value:");
        GridPane.setConstraints(inputLabel, 0, 0);

        inputField = new TextField();
        GridPane.setConstraints(inputField, 1, 0);

        Label unitLabel = new Label("Select unit:");
        GridPane.setConstraints(unitLabel, 0, 1);

        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Meters", "Centimeters", "Kilograms", "Grams");
        unitComboBox.setValue("Meters"); // Default selection
        GridPane.setConstraints(unitComboBox, 1, 1);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 0, 2);

        resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 1, 2);

        convertButton.setOnAction(e -> convert(unitComboBox.getValue()));

        grid.getChildren().addAll(inputLabel, inputField, unitLabel, unitComboBox, convertButton, resultLabel);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convert(String selectedUnit) {
        try {
            double value = Double.parseDouble(inputField.getText());
            double result;
            String resultUnit;

            switch (selectedUnit) {
                case "Meters":
                    result = value * 100;
                    resultUnit = "centimeters";
                    break;
                case "Centimeters":
                    result = value / 100;
                    resultUnit = "meters";
                    break;
                case "Kilograms":
                    result = value * 1000;
                    resultUnit = "grams";
                    break;
                case "Grams":
                    result = value / 1000;
                    resultUnit = "kilograms";
                    break;
                default:
                    result = 0;
                    resultUnit = "";
            }

            resultLabel.setText(String.format("%.2f %s is equal to %.2f %s.", value, selectedUnit.toLowerCase(), result, resultUnit));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
}
