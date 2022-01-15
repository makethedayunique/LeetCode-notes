/**
 * 51. N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * 
 * Example 1:
 * 
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * 
 */
class Solution {
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] row: chessboard) {
            Arrays.fill(row, '.');
        }
        backTrack(chessboard, 0, n);
        return result;
    }
    
    private void backTrack(char[][] chessboard, int row, int n) {
        if (row == n) {
            result.add(array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(chessboard, row, i, n)) {
                chessboard[row][i] = 'Q';
                backTrack(chessboard, row + 1, n);
                chessboard[row][i] = '.';
            }
        }
    }
    
    private List<String> array2List(char[][] chessboard) {
        List<String> temp = new ArrayList<>();
        for (char[] row: chessboard) {
            temp.add(String.copyValueOf(row));
        }
        return temp;
    }
    
    private boolean isValid(char[][] chessboard, int row, int col, int n) {
        /**
         * Check for the validation of the specific position
         */
        // Check the current col
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // Check the diagonal line
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}




