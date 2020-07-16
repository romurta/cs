package com.cs.algorithm.matrix;

public class DiagonalPrinter {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  6},
                {3,  5,  7},
                {4,  8, 11},
                {9, 10, 12}};
        int[] diagonal = solution(matrix);
        for (int i : diagonal) {
            System.out.print(i + " ");
        }
    }

    enum DIR {
        UP, DOWN
    }

    private static int[] solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        DIR dir = DIR.UP; // go up

        int[] ansArray = new int[totalRows * totalColumns];

        int currentRow = 0;
        int currentColumn = 0;

        int index = 0;


        while (currentRow < totalRows && currentColumn < totalColumns) {
            ansArray[index++] = matrix[currentRow][currentColumn];

            //calculate new row and new column
            // going up mean decrease row
            int newRow = currentRow + (dir == DIR.UP ? -1 : 1);

            // going up mean increase column
            int newColumn = currentColumn + (dir == DIR.UP ? 1 : -1);

            if (newRow < 0 || newRow == totalRows || newColumn < 0 || newColumn == totalColumns) {

                if (dir == DIR.UP) { // if going up calculate row/column based on column
                    currentRow = currentRow + (currentColumn < totalColumns - 1 ? 0 : 1);
                    currentColumn = currentColumn + (currentColumn < totalColumns - 1 ? 1 : 0);
                } else { // if going down calculate row/column based on row
                    currentRow = currentRow + (currentRow < totalRows - 1 ? 1 : 0);
                    currentColumn = currentColumn + (currentRow < totalRows - 1 ? 0 : 1);
                }

                //if I am out of bound I need to change direction
                dir = dir == DIR.UP ? DIR.DOWN : DIR.UP;
            } else {
                currentRow = newRow;
                currentColumn = newColumn;
            }

        }
        return ansArray;

    }
}
