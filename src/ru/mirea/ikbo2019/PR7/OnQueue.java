package ru.mirea.ikbo2019.PR7;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Queue;

public class OnQueue {
    private static Queue<Integer> firstPlayer = new ArrayDeque<>();
    private static Queue<Integer> secondPlayer = new ArrayDeque<>();
    private static int moves = 0;

    public static void startGame() {
        if (moves == 106) {
            System.out.println("botva");
            System.exit(0);
        }
        else if (firstPlayer.isEmpty()) {
            System.out.println("second " + moves);
            System.exit(0);
        }
        else if (secondPlayer.isEmpty()) {
            System.out.println("first " + moves);
            System.exit(0);
        }

        int firstcard = firstPlayer.poll();
        int secondcard = secondPlayer.poll();
        if (firstcard < secondcard) {
            firstPlayer.add(firstcard);
            firstPlayer.add(secondcard);
            moves++;
            startGame();
        }
        else if (secondcard < firstcard) {
            secondPlayer.add(secondcard);
            secondPlayer.add(firstcard);
            moves++;
            startGame();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Карточная игра \"Пьяница\", структура хранения Queue.");
        System.out.println("Введите значения 5ти карт для первого игрока:");
        for(int i = 0; i < 5; i++)
        {
            int temp = sc.nextInt();
            if (temp >= 0 && temp < 10)
                firstPlayer.add(temp);
            else {
                System.out.println("Карта должна иметь значение от 0 до 9! Повторите ввод.\n");
                firstPlayer.clear();
                main(null);
            }
        }

        System.out.println("Введите значения 5ти карт для второго игрока:");
        for(int i = 0; i < 5; i++)
        {
            int temp = sc.nextInt();
            if (temp >= 0 && temp < 10)
                secondPlayer.add(temp);
            else {
                System.out.println("Карта должна иметь значение от 0 до 9! Повторите ввод.\n");
                secondPlayer.clear();
                main(null);
            }
        }
        sc.close();
        startGame();
    }
}