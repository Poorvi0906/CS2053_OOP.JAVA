 
public class MatrixDiagonalSums {
    public static void main(String[] args) {
        // Example matrix (you can modify this as needed)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = matrix.length;

        int mainDiagonalSum = 0;
        int upperDiagonalSum = 0;
        int lowerDiagonalSum = 0;

        // Single pass to calculate all sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    mainDiagonalSum += matrix[i][j];
                } else if (i < j) {
                    upperDiagonalSum += matrix[i][j];
                } else if (i > j) {
                    lowerDiagonalSum += matrix[i][j];
                }
            }
        }

        System.out.println("Sum of main diagonal elements: " + mainDiagonalSum);
        System.out.println("Sum of upper diagonal elements: " + upperDiagonalSum);
        System.out.println("Sum of lower diagonal elements: " + lowerDiagonalSum);
    }
}
