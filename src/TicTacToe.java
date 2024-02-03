import java.util.Scanner;

public class TicTacToe {
    public static final int rows = 3;
    public static final int columns = 3;
    public static final String[][] board = new String[rows][columns];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Variables
        String player1 = "X";
        String player2 = "O";
        int player1MoveRow = -1;
        int player1MoveCol = -1;
        int player2MoveRow = -1;
        int player2MoveCol = -1;
        boolean player1Move = false;
        boolean player2Move = false;
        boolean game = false;
        boolean round = false;
        boolean again;




        while (!game) {
            resetBoard();
            while (!round) {
                player1Move = false;
                player2Move = false;

                while (!player1Move) {
                    player1MoveRow = Helper.getRangedInt(scan, "Select the row for your move (Player 1)", 1, 3);
                    player1MoveCol = Helper.getRangedInt(scan, "Select the column for your move (Player 1)", 1, 3);

                    if (isValidMove(player1MoveRow - 1, player1MoveCol - 1)) {
                        player1Move = true;
                    } else {
                        System.out.println("Invalid move");
                    }
                }

                board[player1MoveRow - 1][player1MoveCol - 1] = player1;
                displayBoard();
                if (isWin(player1) || isTie()) {
                    break;
                }

                while (!player2Move) {
                    player2MoveRow = Helper.getRangedInt(scan, "Select the row for your move (Player 2)", 1, 3);
                    player2MoveCol = Helper.getRangedInt(scan, "Select the column for your move (Player 2)", 1, 3);

                    if (isValidMove(player2MoveRow - 1, player2MoveCol - 1)) {
                        player2Move = true;
                    } else {
                        System.out.println("Invalid move");
                    }
                }

                board[player2MoveRow - 1][player2MoveCol - 1] = player2;
                displayBoard();
                if (isWin(player2) || isTie()) {
                    break;
                }
            }

            if (isWin(player1)) {
                System.out.println("Player One Wins!");
                break;
            } else if (isWin(player2)) {
                System.out.println("Player Two Wins!");
                break;
            } else if (isTie()) {
                System.out.println("You Tied!");
                break;
            }

        }

        scan.nextLine();
        game = Helper.getYNConfirm(scan, "Play another game? [Y/N]");
    }

    // Printing the board
    public static void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    // Setting up a blank board
    public static void resetBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "-";
            }
        }
    }

    private static boolean isValidMove (int row, int column) {
        boolean valid = false;
        if (board[row][column] == "-") {
            valid = true;
        }
        return valid;
    }

    // Checks all win possibilities together
    private static boolean isWin (String player) {
        boolean win = false;
        if (isColWin(player) || isRowWin(player) || isDiagWin(player)) {
            win = true;
        }
        return win;
    }

    // Checks if the player wins by column
    private static boolean isColWin (String player) {
        boolean colWin = false;
        int counter = 0;
        for (int j = 0; j < board[0].length; j++) {
            counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[j][i].equals(player)) {
                    counter++;
                }
                if (counter == 3) {
                    colWin = true;
                    break;
                }
            }
        }
        return colWin;
    }

    // Checks if the player wins by row
    private static boolean isRowWin (String player) {
        boolean rowWin = false;
        int counter = 0;
        for (int j = 0; j < board[0].length; j++) {
            counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j].equals(player)) {
                    counter++;
                }
                if (counter == 3) {
                    rowWin = true;
                    break;
                }
            }
        }
        return rowWin;
    }

    // Checks if the player wins by diagonal
    private static boolean isDiagWin (String player) {
        boolean diagWin = false;

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            diagWin = true;
        } else if (board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player)) {
            diagWin = true;
        }

        return diagWin;
    }

    private static boolean isTie() {
        boolean tie = false;
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("-")) {
                    counter++;
                    break;
                }
            }
        }
        if (counter == 0) {
            tie = true;
        }
        return tie;
    }
}