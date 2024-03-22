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
                button.setOnAction(e -> {
                    if (!((Button) e.getSource()).getText().isEmpty()) {
                        return;
                    }
                    if (playerX) {
                        ((Button) e.getSource()).setText("X");
                    } else {
                        ((Button) e.getSource()).setText("O");
                    }
                    if (checkForWinner()) {
                        String winner = playerX ? "Player X" : "Player O";
                        System.out.println(winner + " wins!");
                        primaryStage.close();
                    } else if (checkForDraw()) {
                        System.out.println("It's a draw!");
                        primaryStage.close();
                    } else {
                        playerX = !playerX;
                    }
                });
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean checkForWinner() {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (checkLine(buttons[i][0], buttons[i][1], buttons[i][2], buttons[i][3], buttons[i][4])) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (checkLine(buttons[0][i], buttons[1][i], buttons[2][i], buttons[3][i], buttons[4][i])) {
                return true;
            }
        }
        // Check diagonals
        if (checkLine(buttons[0][0], buttons[1][1], buttons[2][2], buttons[3][3], buttons[4][4])) {
            return true;
        }
        if (checkLine(buttons[0][4], buttons[1][3], buttons[2][2], buttons[3][1], buttons[4][0])) {
            return true;
        }
        return false;
    }

    private boolean checkLine(Button b1, Button b2, Button b3, Button b4, Button b5) {
        String text1 = b1.getText();
        String text2 = b2.getText();
        String text3 = b3.getText();
        String text4 = b4.getText();
        String text5 = b5.getText();
        return !text1.isEmpty() && text1.equals(text2) && text1.equals(text3) && text1.equals(text4) && text1.equals(text5);
    }

    private boolean checkForDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
