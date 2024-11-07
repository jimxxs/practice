
/*
Core Logic:

The provided code implements a backtracking algorithm to solve Sudoku puzzles. The key idea is to:

Find an empty cell: Locate an empty cell in the Sudoku board (a cell with the value 0).
Try a number: For each possible number (1-9), check if it's valid to place in that cell.
Recursively solve: If the number is valid, recursively call the solveSudoku function to solve the remaining part of the board.
Backtrack: If a solution isn't found, backtrack to the previous empty cell and try a different number. */


public class SudokuSolver {
    private static final int SIZE = 9;

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    /* this method ; solvesudoku
Iterates through each cell of the board.
If a cell is empty:
Tries numbers from 1 to 9.
For each number, checks its validity using the isValid method.
If valid, places the number in the cell and recursively calls solveSudoku.
If the recursive call returns true, a solution is found, and the function returns true.
If the recursive call returns false, the number is removed (backtracked), and the next number is tried.

 */
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /*isValid Method:
Checks if a given number is valid for a specific cell by:
Checking the row: Ensures the number doesn't exist in the same row.
Checking the column: Ensures the number doesn't exist in the same column.
Checking the 3x3 grid: Ensures the number doesn't exist in the same 3x3 grid.

 */
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check column
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /*printBoard Method:

Prints the solved Sudoku board in a formatted manner.
Key Points:

Backtracking: The core technique used to explore different possibilities and undo incorrect choices.
Constraint Satisfaction: The isValid method enforces the Sudoku rules to ensure valid placements.
Recursive Approach: The problem is broken down into smaller subproblems, and the solution is built recursively. */

    private static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % 3 == 0) {
                System.out.print("");
            }
        }
    }
}
