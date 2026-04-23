/*
Problem: Set Matrix Zeroes
Platform: LeetCode
Topic: Array / Matrix

Approach:
Use the first row and first column to store states about whether that row/col should be zero.
Use an extra variable for the first column because matrix[0][0] overlaps for both.
Iterate through the matrix to mark the zeroes on the first row/col.
Then, zero out the interior based on the first row/col markers.
Finally, zero out the first row/col if needed.

Time Complexity: O(M * N)
Space Complexity: O(1) modifying the matrix in place
*/

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstColZero = false;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
