
    
    import java.util.Scanner;

public class TicTacToeWithComputer {

    // Display the game board
    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }
    
    // Check if a player has won
    public static boolean isWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }
        
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        
        return false;
    }
    
    // Check if the board is full (draw)
    public static boolean isFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
    
    // Computer makes a random move
    public static void computerMove(char[][] board) {
        int row, col;
        do {
            row = (int)(Math.random() * 3);
            col = (int)(Math.random() * 3);
        } while (board[row][col] != ' ');
        
        board[row][col] = 'O';
        System.out.println("Computer's turn");
        System.out.println("Computer chose row " + row + ", column " + col);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Initialize empty board
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        boolean gameOver = false;
        
        // Game loop
        while (!gameOver) {
            // Display board
            displayBoard(board);
            
            // Player's turn
            System.out.println("Player's turn");
            int row, col;
            
            // Get valid input from player
            do {
                System.out.print("Enter a row (0, 1 or 2): ");
                row = input.nextInt();
                System.out.print("Enter a column (0, 1 or 2): ");
                col = input.nextInt();
                
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid input. Please enter 0, 1, or 2.");
                } else if (board[row][col] != ' ') {
                    System.out.println("This cell is already occupied. Try again.");
                }
            } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');
            
            // Place player's move
            board[row][col] = 'X';
            
            // Check if player wins
            if (isWin(board, 'X')) {
                System.out.println();
                displayBoard(board);
                System.out.println("X player wins!");
                gameOver = true;
                break;
            }
            
            // Check for draw
            if (isFull(board)) {
                System.out.println();
                displayBoard(board);
                System.out.println("It's a draw!");
                gameOver = true;
                break;
            }
            
            System.out.println();
            
            // Computer's turn
            computerMove(board);
            
            // Check if computer wins
            if (isWin(board, 'O')) {
                System.out.println();
                displayBoard(board);
                System.out.println("O player wins!");
                gameOver = true;
                break;
            }
            
            // Check for draw
            if (isFull(board)) {
                System.out.println();
                displayBoard(board);
                System.out.println("It's a draw!");
                gameOver = true;
                break;
            }
            
            System.out.println();
        }
        
        input.close();
    }
}

