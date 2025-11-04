
public class MidElement {
    public static String findMidElement(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // For 3x3 matrix, return the middle element
        if (rows == 3 && cols == 3) {
            return String.valueOf(matrix[1][1]);
        }
        // For 4x4 matrix, return the middle 4 elements
        else if (rows == 4 && cols == 4) {
            int r1 = 1, r2 = 2, c1 = 1, c2 = 2;
            return matrix[r1][c1] + ", " + matrix[r1][c2] + ", " +
                   matrix[r2][c1] + ", " + matrix[r2][c2];
        }
        return "-1"; // Should not reach here
    }

    public static void main(String[] args) {
        int[][] oddMatrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] evenMatrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("Mid element (3x3): " + MidElement.findMidElement(oddMatrix));
        System.out.println("Mid elements (4x4): " + MidElement.findMidElement(evenMatrix));
    }
}
