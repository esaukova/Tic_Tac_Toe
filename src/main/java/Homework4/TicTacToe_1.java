package Homework4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe_1 {
    private static final char Default = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int SIZE = 3;


    private static char[][] MAP = new char[SIZE][SIZE];

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = Default;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isCellValid(int x, int y) {
        boolean isInMap = x > 0 && x <= SIZE && y > 0 && y <= SIZE;
        return isInMap && MAP[x-1][y-1] == Default;
    }

    private static void makeMove(int x, int y, char value) {
        MAP[x - 1][y - 1] = value;
    }

    private static void pcAI() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;
        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(SIZE);
                y = rnd.nextInt(SIZE);
            } while (isCellValid(x, y));
        }
        MAP[x][y] = DOT_O;
    }

    private static boolean checkWin(char value) {
        for (int i = 0; i < SIZE ; i++)
            if ((MAP[i][0] == value && MAP[i][1] == value &&
                    MAP[i][2] == value) ||
                    (MAP[0][i] == value && MAP[1][i] == value &&
                            MAP[2][i] == value))
                return true;
        if ((MAP[0][0] == value && MAP[1][1] == value &&
                MAP[2][2] == value) ||
                (MAP[2][0] == value && MAP[1][1] == value &&
                        MAP[0][2] == value))
            return true;
        return false;
    }

    private static void startGame () {
        initMap();
        System.out.println("You have joined the tic-tac-toe game!");
        System.out.println("To win the game you need to put 3 tics in one line.");
        System.out.println("To make a move enter 2 digits: number of row and number of column.");
        System.out.println("Let's start the game!");
        printMap();
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        while (true) {
            System.out.println("Your move");
            String[] values = in.nextLine().split(" ");
            if (values.length !=2) {
                System.out.println("You have entered wrong data!\n Pls Enter 2 digits from 1 to 3!");
                continue;
            }
            try {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                if (isCellValid(x, y)) {
                    makeMove(x, y, DOT_X);
                    cnt++;
                    if (cnt == 9) {
                        System.out.println("Draw!");
                        showEndGameDialog(in);
                        break;
                    }
                    if (checkWin(DOT_X)) {
                        System.out.println("You won!");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                    System.out.println("PC's move");
                    pcAI();
                    cnt++;
                    if (checkWin(DOT_O)) {
                        System.out.println("Wasted!");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                } else {
                    System.out.println("Not possible to make this move!\n Enter another digits from 1 to 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered wrong data!\n Pls Enter digits from 1 to 3!");

            }
        }

    }
    private static void showEndGameDialog(Scanner in) {
        System.out.println("To start new game press 1");
        System.out.println("To exit the game press any other button");

        System.out.println("Enter command");
        String command = in.next ();
        if (command.equals("1")) {
            startGame();
            return;
        }
        System.out.println("Game Over");

    }


    public static void main(String[] args) {
        startGame();
    }
}