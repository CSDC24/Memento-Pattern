import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMemento {
    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();

    @BeforeEach
    void testSetState(){
        originator.setState("state #1");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());
    }

    @Test
    void testMemento_Scenario_Save() {
        String expected = "state #2";
        String actual = originator.getState();
        assertEquals(expected, actual);
    }

    @Test
    void testMemento_Scenario_GetFirstState() {
        originator.getStateFromMemento(careTaker.get(0));
        String actual = originator.getState();
        String expected = "state #1";
        assertEquals(expected, actual);
    }
}
