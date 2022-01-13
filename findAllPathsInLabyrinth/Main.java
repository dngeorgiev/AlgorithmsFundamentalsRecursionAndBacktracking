package findAllPathsInLabyrinth;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPath(labyrinth, 0, 0, ' ');
    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {
        if (!isInBounds(labyrinth, row, col)) return;

        path.add(direction);

        if (isEnd(labyrinth, row, col)) {
            printPath();
        } else if (!isVisited(labyrinth, row, col) && isFree(labyrinth, row, col)) {
            mark(labyrinth, row, col);

            findPath(labyrinth, row - 1, col, 'U');
            findPath(labyrinth, row + 1, col, 'D');
            findPath(labyrinth, row, col - 1, 'L');
            findPath(labyrinth, row, col + 1, 'R');

            unmark(labyrinth, row, col);
        }

        path.remove(path.size() - 1);
    }

    private static boolean isFree(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] != '*';
    }

    private static boolean isVisited(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == 'V';
    }

    private static void printPath() {
        for (Character character : path) {
            if (character == ' ') continue;

            System.out.print(character);
        }

        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length &&
                row >= 0 &&
                col < labyrinth[row].length &&
                col >= 0;
    }

    private static boolean isEnd(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static void mark(char[][] labyrinth, int row, int col) {
        labyrinth[row][col] = 'V';
    }

    private static void unmark(char[][] labyrinth, int row, int col) {
        labyrinth[row][col] = '-';
    }
}
