package eightQueensPuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int chessBoardSize = 8;

    public static ArrayList<ArrayList<Character>> board = new ArrayList<>();
    public static Map<Integer, Boolean> attackedRows = new HashMap<>();
    public static Map<Integer, Boolean> attackedColumns = new HashMap<>();
    public static Map<Integer, Boolean> attackedLeftDiagonals = new HashMap<>();
    public static Map<Integer, Boolean> attackedRightDiagonals = new HashMap<>();

    public static void main(String[] args) {
        initData();

        findQueenPositions(0);
    }

    private static void findQueenPositions(int row) {
        if (row == chessBoardSize) {
            printSolution();
        } else {
            for (int col = 0; col < chessBoardSize; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositions(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        int leftDiagonalNumber = col - row;
        int rightDiagonalNumber = col + row;

        return !attackedRows.get(row)
                && !attackedColumns.get(col)
                && !attackedLeftDiagonals.get(leftDiagonalNumber)
                && !attackedRightDiagonals.get(rightDiagonalNumber);
    }

    private static void putQueen(int row, int col) {
        board.get(row).set(col, '*');

        markRow(row, true);
        markColumn(col, true);
        markLeftDiagonal(row, col, true);
        markRightDiagonal(row, col, true);
    }

    private static void removeQueen(int row, int col) {
        board.get(row).set(col, '-');

        markRow(row, false);
        markColumn(col, false);
        markLeftDiagonal(row, col, false);
        markRightDiagonal(row, col, false);
    }

    private static void printSolution() {
        for (int row = 0; row < chessBoardSize; row++) {
            for (int col = 0; col < chessBoardSize; col++) {
                System.out.print(board.get(row).get(col) + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void markRow(int row, boolean value) {
        attackedRows.put(row, value);
    }

    private static void markColumn(int col, boolean value) {
        attackedColumns.put(col, value);
    }

    private static void markLeftDiagonal(int row, int col, boolean value) {
        int calculatedLeftDiagonal = col - row;

        attackedLeftDiagonals.put(calculatedLeftDiagonal, value);
    }

    private static void markRightDiagonal(int row, int col, boolean value) {
        int calculatedRightDiagonal = col + row;

        attackedRightDiagonals.put(calculatedRightDiagonal, value);
    }

    private static void initData() {
        initializeChessBoard();
        initializeAttackedRows();
        initializeAttackedColumns();
        initializeAttackedLeftDiagonals();
        initializeAttackedRightDiagonals();
    }

    private static void initializeChessBoard() {
        for (int row = 0; row < chessBoardSize; row++) {
            ArrayList<Character> currentRow = new ArrayList<>();
            for (int col = 0; col < chessBoardSize; col++) {
                currentRow.add('-');
            }

            board.add(currentRow);
        }
    }

    private static void initializeAttackedRows() {
        for (int row = 0; row < chessBoardSize; row++) {
            attackedRows.put(row, false);
        }
    }

    private static void initializeAttackedColumns() {
        for (int col = 0; col < chessBoardSize; col++) {
            attackedColumns.put(col, false);
        }
    }

    private static void initializeAttackedLeftDiagonals() {
        int startOfDiagonal = (chessBoardSize - 1) * -1;
        int sizeOfLeftDiagonals = chessBoardSize * 2;

        for (int i = startOfDiagonal; i < sizeOfLeftDiagonals / 2; i++) {
            attackedLeftDiagonals.put(i, false);
        }
    }

    private static void initializeAttackedRightDiagonals() {
        int startOfDiagonal = 0;
        int sizeOfRightDiagonals = (chessBoardSize * 2) - 1;

        for (int i = startOfDiagonal; i < sizeOfRightDiagonals; i++) {
            attackedRightDiagonals.put(i, false);
        }
    }
}
