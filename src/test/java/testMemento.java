import org.junit.Assert;
import org.junit.Test;

public class testMemento{
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

        Assert.assertEquals(expected,actual);
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

        Assert.assertEquals(expected,actual);
    }
}









