package com.practice;

public class CircularMatrix {
    int[][] input;

    public CircularMatrix(int[][] input) {
        this.input = input;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // 1  2  3  4
        // 5  6  7  8
        // 9  10 11 12
        // 13 14 15 16
        CircularMatrix circularMatrix = new CircularMatrix(input);
        circularMatrix.print();
    }

    public void print() {
        int rowStart = 0;
        int rowEnd = input.length - 1;
        int columnStart = 0;
        int columnEnd = input[0].length - 1;

        while (columnStart <= columnEnd && rowStart <= rowEnd) {
            this.printForward(rowStart, rowEnd, columnStart, columnEnd);
            this.printBackward(rowStart, rowEnd, columnStart, columnEnd);
            rowStart++;
            rowEnd--;
            columnEnd--;
            columnStart++;
        }
    }

    private void printForward(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int index = columnStart; index < columnEnd; index++) {
            System.out.println(input[rowStart][index]);
        }
        for (int index = rowStart; index < rowEnd; index++) {
            System.out.println(input[index][columnEnd]);
        }
    }

    private void printBackward(int rowStart, int rowEnd, int colStart, int colEnd) {
        for (int index = colEnd; index > colStart; index--) {
            System.out.println(input[rowEnd][index]);
        }

        for (int index = rowEnd; index > rowStart; index--) {
            System.out.println(input[index][colStart]);
        }
    }
}