/**
 * 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *  
 * Time Complexity: O(9 ^ m) m = number of empty cells
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }
    
    private boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(board, i, j, val)) {
                        board[i][j] = val;
                        if (backTrack(board)) return true;
                        board[i][j] = '.';             
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == val) {
                return false;
            }
        }
        // 0,1,2 -> 0; 3,4,5 -> 3; 6,7,8 -> 6;
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}


