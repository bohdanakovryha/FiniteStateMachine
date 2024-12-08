import org.example.FiniteStateMachine;
import org.example.State;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteStateMachineTest {

    static Stream<Object[]> provideTestCases() {
        return Stream.of(
                new Object[]{"abcTESTabc", State.F},
                new Object[]{"abcTES", State.THREE},
                new Object[]{"abcTE", State.TWO},
                new Object[]{"abcT", State.ONE},
                new Object[]{"abc", State.S},
                new Object[]{"TEST", State.F},
                new Object[]{"TES", State.THREE},
                new Object[]{"TE", State.TWO},
                new Object[]{"T", State.ONE},
                new Object[]{"TETEST", State.F},
                new Object[]{"TEA", State.TWO},
                new Object[]{"TESA", State.THREE},
                new Object[]{"TESTING", State.F},
                new Object[]{"abcTESabc", State.THREE},
                new Object[]{"abcTEabc", State.TWO},
                new Object[]{"abcTabc", State.ONE}
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFiniteStateMachine(String input, State expectedState) {
        FiniteStateMachine fsm = new FiniteStateMachine();
        fsm.processString(input);
        assertEquals(expectedState, fsm.getCurrentState());
    }
}