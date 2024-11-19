package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок для перевірки на наявність слова 'TEST':");
        String input = scanner.nextLine();

        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString(input);

        FiniteStateMachine.State finalState = fsm.getCurrentState();

        System.out.println("Кінцевий стан: " + finalState);

        if (fsm.isFinalState()) {
            System.out.println("Слово 'TEST' знайдено у рядку!");
        } else {
            System.out.println("Слово 'TEST' не знайдено.");
        }
    }
}
