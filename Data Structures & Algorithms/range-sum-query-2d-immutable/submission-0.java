
class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        // Add an extra row and column to simplify boundary handling.
        prefixSum = new int[numberOfRows + 1][numberOfColumns + 1];

        // Build the 2D prefix sum matrix.
        for (int row = 1; row <= numberOfRows; row++) {
            for (int column = 1; column <= numberOfColumns; column++) {

                int currentElement = matrix[row - 1][column - 1];

                int sumAbove = prefixSum[row - 1][column];
                int sumLeft = prefixSum[row][column - 1];
                int overlappingSum = prefixSum[row - 1][column - 1];

                prefixSum[row][column] =
                    currentElement + sumAbove + sumLeft - overlappingSum;
            }
        }
    }

    public int sumRegion(int firstRow, int firstColumn,
                         int lastRow, int lastColumn) {

        // Sum of everything from the origin to the bottom-right corner.
        int totalSum = prefixSum[lastRow + 1][lastColumn + 1];

        // Remove the area above the requested rectangle.
        int sumAboveRegion = prefixSum[firstRow][lastColumn + 1];

        // Remove the area to the left of the requested rectangle.
        int sumLeftRegion = prefixSum[lastRow + 1][firstColumn];

        // Add back the overlapping area removed twice.
        int overlappingSum = prefixSum[firstRow][firstColumn];

        return totalSum - sumAboveRegion - sumLeftRegion + overlappingSum;
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */