package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок для перевірки на наявність слова 'TEST':");
        String input = scanner.nextLine().toLowerCase();

        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString(input);

        if (fsm.getCurrentState() == State.F) {
            System.out.println("Слово 'TEST' знайдено у рядку!");
        } else {
            System.out.println("Слово 'TEST' не знайдено.");
        }
    }
}
