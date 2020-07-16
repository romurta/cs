package com.cs.algorithm.matrix;

public class SpiralPrinter {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 14, 15, 16, 5 },
                { 13, 20, 17, 6 },
                { 12, 19, 18, 7 },
                { 11, 10, 9, 8 } };
        solution(matrix);
    }

    private static void solution(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        int currentRow = 0;
        int currentColumn = 0;

        while (currentRow < totalRows && currentColumn < totalColumns) {

            for (int i = currentColumn; i < totalColumns; i++) {
                System.out.print(matrix[currentRow][i] + " ");
            }

            currentRow++; // walk currentRow since you printed the current one, otherwise you will print duplicate

            for (int i = currentRow; i < totalRows; i++) {
                System.out.print(matrix[i][totalColumns - 1] + " ");
            }

            totalColumns--; // remove 1 from the column since that finished

            if (currentRow < totalRows) {
                for (int i = totalColumns - 1; i >= currentColumn; i--) {
                    System.out.print(matrix[totalRows - 1][i] + " ");
                }
                totalRows--;
            }

            if (currentColumn < totalColumns) {
                for (int i = totalRows - 1; i >= currentRow; i--) {
                    System.out.print(matrix[i][currentColumn] + " ");
                }
                currentColumn++;
            }
        }
    }
}
