package com.cs.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

public class Rivers {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1){
                    int size[] = new int[1];
                    dfs(matrix,i,j,size);
                    if(size[0] > 0){
                        sizes.add(size[0]);
                    }
                }
            }
        }

        return sizes;
    }

    public static void dfs(int[][] matrix, int i, int j, int[] size) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j]==0){
            return;
        }


        size[0] = size[0] + 1;
        matrix[i][j] = 0;
        dfs(matrix,i+1,j,size);
        dfs(matrix,i,j+1,size);
        dfs(matrix,i-1,j,size);
        dfs(matrix,i,j-1,size);
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };

        System.out.println(riverSizes(input));
        System.out.println();
    }
}
