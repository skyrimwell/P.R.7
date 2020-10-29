package ru.mirea.ikbo2019.PR7;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class OnStack {
    private static Stack<Integer> firstPlayer = new Stack<>();
    private static Stack<Integer> secondPlayer = new Stack<>();
    private static int moves = 0;

    public static void startGame() {
        if (moves == 106) {
            System.out.println("botva");
            System.exit(0);
        }
        else if (firstPlayer.empty()) {
            System.out.println("second " + moves);
            System.exit(0);
        }
        else if (secondPlayer.empty()) {
            System.out.println("first " + moves);
            System.exit(0);
        }

        Collections.reverse(firstPlayer);
        int firstcard = firstPlayer.pop();
        Collections.reverse(firstPlayer);


        Collections.reverse(secondPlayer);
        int secondcard = secondPlayer.pop();
        Collections.reverse(secondPlayer);

        if (firstcard < secondcard) {
            firstPlayer.push(firstcard);
            firstPlayer.push(secondcard);
            moves++;
            startGame();
        }
        else if (secondcard < firstcard) {
            secondPlayer.push(secondcard);
            secondPlayer.push(firstcard);
            moves++;
            startGame();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Карточная игра \"Пьяница\"");
        System.out.println("Введите значения 5ти карт для первого игрока:");
        for(int i = 0; i < 5; i++)
        {
            int temp = sc.nextInt();
            if (temp >= 0 && temp < 10)
                firstPlayer.push(temp);
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
                secondPlayer.push(temp);
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