import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class TestMemento {
    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();
    @Test
    public void testMemento_Scenario_Save ( ){
        originator.setState("state #1");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());

        String expected = "state #2";
        String actual = originator.getState();

        assertEquals(expected,actual);
    }
    @Test
    public  void testMemento_Scenario_GetFirstState(){
        originator.setState("state #1");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());

        originator.getStateFromMemento(careTaker.get(0));
        String actual = originator.getState();
        String expected = "state #1";

        assertEquals(expected,actual);
    }
}