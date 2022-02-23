import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> myList = new ArrayList<Memento>();

    public void add(Memento state){
        myList.add(state);
    }

    public Memento get(int index){
        return myList.get(index);
    }
}
