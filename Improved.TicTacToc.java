import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Choose the board dimension (e.g., 3 for 3x3 board): ");
        int dimension = getValidDimension();

        char[][] board = createBoard(dimension);
        displayBoard(board);

        char currentPlayer = PLAYER_X;
        while (!isBoardFull(board) && !isGameOver(board)) {
            if (currentPlayer == PLAYER_X) {
                getPlayerMove(playerName, board);
            } else {
                getAIMove(board);
            }
            displayBoard(board);
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        displayGameResult(board);
        scanner.close();
    }

    private static int getValidDimension() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer for dimension:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static char[][] createBoard(int dimension) {
        char[][] board = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
        return board;
    }

    private static void displayBoard(char[][] board) {
        int dimension = board.length;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void getPlayerMove(String playerName, char[][] board) {
        System.out.println("Your turn, " + playerName + ". Enter row and column (1-indexed): ");
        int row = getPlayerInput("Row: ", board.length) - 1;
        int col = getPlayerInput("Column: ", board.length) - 1;
        while (board[row][col] != EMPTY_CELL) {
            System.out.println("Cell already occupied. Please choose another.");
            row = getPlayerInput("Row: ", board.length) - 1;
            col = getPlayerInput("Column: ", board.length) - 1;
        }
        board[row][col] = PLAYER_X;
    }

    private static int getPlayerInput(String prompt, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < 1 || input > max);
        return input;
    }

    private static void getAIMove(char[][] board) {
        // Implement AI move (e.g., random move for now)
        int dimension = board.length;
        int row, col;
        do {
            row = (int) (Math.random() * dimension);
            col = (int) (Math.random() * dimension);
        } while (board[row][col] != EMPTY_CELL);
        board[row][col] = PLAYER_O;
        System.out.println("AI played at row " + (row + 1) + ", column " + (col + 1));
    }

    private static boolean isGameOver(char[][] board) {
        return hasPlayerWon(board, PLAYER_X) || hasPlayerWon(board, PLAYER_O);
    }

    private static boolean hasPlayerWon(char[][] board, char player) {
        int dimension = board.length;
        // Check rows and columns
        for (int i = 0; i < dimension; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] != player) {
                    rowWin = false;
                }
                if (board[j][i] != player) {
                    colWin = false;
                }
            }
            if (rowWin || colWin) {
                return true;
            }
        }
        // Check diagonals
        boolean diag1Win = true;
        boolean diag2Win = true;
        for (int i = 0; i < dimension; i++) {
            if (board[i][i] != player) {
                diag1Win = false;
            }
            if (board[i][dimension - 1 - i] != player) {
                diag2Win = false;
            }
        }
        return diag1Win || diag2Win;
    }

    private static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayGameResult(char[][] board) {
        if (hasPlayerWon(board, PLAYER_X)) {
            System.out.println("Congratulations! You won!");
        } else if (hasPlayerWon(board, PLAYER_O)) {
            System.out.println("Sorry, you lost. Better luck next time!");
        } else {
            System.out.println("It's a tie! Game over.");
        }
    }
}
