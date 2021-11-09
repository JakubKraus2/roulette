package com.company;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int balance = 1000;
    static int bet = 0;
    static float geneNum;
    static int quess;

    public static void main(String[] args) {
        System.out.println("mas " + balance);
        betting();
    }

    public static void betting() {
        System.out.println("cervena[1] | cerna[2]");
        quess = sc.nextInt();
        System.out.println("kolik sazis");
        bet = sc.nextInt();

        while (bet > balance || bet <= 0) {
            System.out.println("si blbecek blbeckovitej, zadej to jinak");
            bet = sc.nextInt();
        }
        generate();
    }

    public static void generate() {
        float max = 100;
        float min = 0;

        geneNum = (float) (Math.random() * max) + min;
        win();
    }

    public static void win() {
        if (quess == 1 && geneNum <= 47.4) {
            balance += bet * 2;
            System.out.println("vyhrals");
        } else if (quess == 2 && geneNum > 47.4 && geneNum <= 47.4 * 2) {
            balance += bet * 2;
            System.out.println("vyhrals");
        } else {
            balance -= bet;
            System.out.println("prohrals");
        }
        System.out.println("mas " + balance);
        again();
    }

    public static void again() {
        if (balance <= 0) {
            System.out.println("prohrals vsechno");
            System.exit(0);
        }

        System.out.println("znova?[1/2]");
        int decide = sc.nextInt();

        if (decide == 1) {
            betting();
        } else {
            System.exit(0);
        }
    }
}
