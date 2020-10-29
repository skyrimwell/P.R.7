package ru.mirea.ikbo2019.PR7;


import java.util.*;

public class OnDL {
    private static List<Double> firstPlayer = new ArrayList<>();
    private static List<Double> secondPlayer = new ArrayList<>();
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

        Double fstcard = firstPlayer.remove(0);
        Double sndcard = secondPlayer.remove(0);
        if (fstcard < sndcard) {
            firstPlayer.add(fstcard);
            firstPlayer.add(sndcard);
            moves++;
            startGame();
        }
        else if (sndcard < fstcard) {
            secondPlayer.add(sndcard);
            secondPlayer.add(fstcard);
            moves++;
            startGame();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Карточная игра \"Пьяница\", структура хранения Deque.");
        System.out.println("Введите значения 5ти карт для первого игрока:");
        for(int i = 0; i < 5; i++)
        {
            int temp = sc.nextInt();
            if (temp >= 0 && temp < 10)
                firstPlayer.add((double) temp);
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
                secondPlayer.add((double) temp);
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