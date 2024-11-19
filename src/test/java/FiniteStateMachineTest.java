import org.example.FiniteStateMachine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FiniteStateMachineTest {

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "abcTES, THREE",
            "abcTE, TWO",
            "abcT, ONE",
            "abc, S",
            "TEST, F",
            "TES, THREE",
            "TE, TWO",
            "T, ONE",
            "E, S",
            "S, S",
            "TETEST, F"
    })
    void testFiniteStateMachine(String input, String expectedState) {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString(input);
        assertEquals(FiniteStateMachine.State.valueOf(expectedState), fsm.getCurrentState());
    }

    @Test
    void testFinalStateRecognition() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("abcTESTabc");
        assertTrue(fsm.isFinalState());
    }

    @Test
    void testDoesNotReachFinalState() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("abcTES");
        assertEquals(FiniteStateMachine.State.THREE, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }

    @Test
    void testOneStateRecognitionFromABC() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("abcT");
        assertEquals(FiniteStateMachine.State.ONE, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }

    @Test
    void testMultipleTransitions() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("TETEST");
        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
        assertTrue(fsm.isFinalState());
    }

    @Test
    void testTestStateRecognition() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("TEST");
        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
        assertTrue(fsm.isFinalState());
    }

    @Test
    void testThreeStateRecognition() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("TES");
        assertEquals(FiniteStateMachine.State.THREE, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }

    @Test
    void testTwoStateRecognition() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("TE");
        assertEquals(FiniteStateMachine.State.TWO, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }

    @Test
    void testOneStateRecognition() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("T");
        assertEquals(FiniteStateMachine.State.ONE, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }

    @Test
    void testSStateRecognition() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("abc");
        assertEquals(FiniteStateMachine.State.S, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }

    @Test
    void testEmptyInput() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("");
        assertEquals(FiniteStateMachine.State.S, fsm.getCurrentState());
        assertTrue(!fsm.isFinalState());
    }
    @Test
    void testRepeatedTInTheMiddle() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("TETTEST");
        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
        assertTrue(fsm.isFinalState());
    }

    @Test
    void testIncorrectTransitionAfterT() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString("TESTT");
        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
        assertTrue(fsm.isFinalState());
    }
}
