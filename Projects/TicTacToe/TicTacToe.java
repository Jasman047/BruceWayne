import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    private static final int SIZE = 5;
    private static final int CELL_SIZE = 100;
    private static final int WIN_COUNT = 5;

    private Tile[][] board = new Tile[SIZE][SIZE];
    private boolean playerXTurn = true;
    private boolean gameEnded = false;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Tile tile = new Tile();
                board[i][j] = tile;
                root.add(tile, j, i);
            }
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe (5x5)");
        primaryStage.show();
    }

    private void checkWin(int x, int y) {
        int dx[] = {1, 0, 1, 1}; // horizontal, vertical, diagonal 1, diagonal 2
        int dy[] = {0, 1, 1, -1};

        char currentPlayer = playerXTurn ? 'X' : 'O';

        for (int i = 0; i < 4; i++) {
            int count = 1;
            for (int j = 1; j < WIN_COUNT; j++) {
                int newX = x + dx[i] * j;
                int newY = y + dy[i] * j;
                if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE &&
                        board[newX][newY].getValue() == currentPlayer) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = 1; j < WIN_COUNT; j++) {
                int newX = x - dx[i] * j;
                int newY = y - dy[i] * j;
                if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE &&
                        board[newX][newY].getValue() == currentPlayer) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= WIN_COUNT) {
                endGame(currentPlayer + " wins!");
                return;
            }
        }

        // Check for draw
        boolean draw = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getValue() == ' ') {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            endGame("It's a draw!");
        }
    }

    private void endGame(String message) {
        gameEnded = true;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private class Tile extends Rectangle {
        private char value;

        public Tile() {
            super(CELL_SIZE, CELL_SIZE);
            setFill(Color.WHITE);
            setStroke(Color.BLACK);
            setOnMouseClicked(e -> handleClick());
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        private void handleClick() {
            if (gameEnded || value != ' ') {
                return;
            }
            value = playerXTurn ? 'X' : 'O';
            setFill(playerXTurn ? Color.BLUE : Color.RED);
            playerXTurn = !playerXTurn;
            checkWin(GridPane.getRowIndex(this), GridPane.getColumnIndex(this));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
