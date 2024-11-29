package org.example;

public class FiniteStateMachine {

    public enum State {
        S, ONE, TWO, THREE, F
    }

    private State currentState;

    public FiniteStateMachine() {
        currentState = State.S;
    }

    public void processString(String input) {
        input = input.toLowerCase();
        for (char ch : input.toCharArray()) {
            processChar(ch);
        }
    }

    private void processChar(char ch) {
        switch (currentState) {
            case S:
                if (ch == 't') {
                    currentState = State.ONE;
                }
                break;
            case ONE:
                if (ch == 'e') {
                    currentState = State.TWO;
                } else if (ch == 't') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case TWO:
                if (ch == 's') {
                    currentState = State.THREE;
                } else if (ch == 't') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case THREE:
                if (ch == 't') {
                    currentState = State.F;
                } else {
                    currentState = State.THREE;
                }
                break;
            case F:
                break;
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public boolean isFinalState() {
        return currentState == State.F;
    }
}
