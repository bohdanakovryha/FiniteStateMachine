package org.example;

public class FiniteStateMachine {

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
        currentState = switch (currentState) {
            case S -> (ch == 't') ? State.ONE : State.S;
            case ONE -> (ch == 'e') ? State.TWO : State.ONE;
            case TWO -> (ch == 's') ? State.THREE : State.TWO;
            case THREE -> (ch == 't') ? State.F : State.THREE;
            case F -> State.F;
        };
    }
    public State getCurrentState() {
        return currentState;
    }
}
