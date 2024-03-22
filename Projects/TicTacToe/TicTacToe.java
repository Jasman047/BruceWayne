import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    private static final int BOARD_SIZE = 5;
    private Button[][] buttons;
    private boolean playerX = true; // Player X starts the game

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        buttons = new Button[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Button button = new Button();
                button.setPrefSize(50, 50);
                int row = i;
                int col = j;
                button.setOnAction(e -> handleButtonClick(row, col));
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(int row, int col) {
        Button button = buttons[row][col];
        if (!button.getText().isEmpty()) {
            return;
        }
        if (playerX) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        if (checkForWinner()) {
            String winner = playerX ? "Player X" : "Player O";
            System.out.println(winner + " wins!");
            // You can add a message dialog or other actions here to handle the end of the game.
        } else if (checkForDraw()) {
            System.out.println("It's a draw!");
            // You can add a message dialog or other actions here to handle the end of the game.
        } else {
            playerX = !playerX;
        }
    }

    private boolean checkForWinner() {
        // Implementation of checkForWinner remains the same as before
    }

    private boolean checkForDraw() {
        // Implementation of checkForDraw remains the same as before
    }

    public static void main(String[] args) {
        launch(args);
    }
}

