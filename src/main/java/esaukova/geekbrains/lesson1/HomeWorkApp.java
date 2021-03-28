package esaukova.geekbrains.lesson1;

import java.util.Scanner;

public class HomeWorkApp {
    //main & print3words
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //checkSumSign
    public static void checkSumSign() {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println("Sum:" + (x+y));
        if ((x+y) > 0) {
            System.out.print("Сумма положительная");
        }
        if ((x+y) < 0) {
            System.out.print("Сумма отрицательная");
        }}
    //printColor
    public static void printColor() {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt ();
        if ((x) <= 0) {
            System.out.print("красный");}
        if ((x) > 0 && (x) <= 100) {
            System.out.println("жёлтый"); }
        if ((x) > 100) {
            System.out.println("Зелёный");}
    }

    public static void compareNumbers() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if ((a) >= (b)) {
            System.out.println("a >= b");}
            else {
                System.out.println("a < b");}


    }
}
