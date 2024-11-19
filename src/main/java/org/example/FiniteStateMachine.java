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
        for (char ch : input.toCharArray()) {
            processChar(ch);
        }
    }

    private void processChar(char ch) {
        switch (currentState) {
            case S:
                if (ch == 'T') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case ONE:
                if (ch == 'E') {
                    currentState = State.TWO;
                } else if (ch == 'T') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case TWO:
                if (ch == 'S') {
                    currentState = State.THREE;
                } else if (ch == 'T') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case THREE:
                if (ch == 'T') {
                    currentState = State.F;
                } else {
                    currentState = State.S;
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
