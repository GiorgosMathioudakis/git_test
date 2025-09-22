import java.util.ArrayList;

public class GenericClass<T> {

    public ArrayList<T> list = new ArrayList<>();

    public int count;

    GenericClass() {
        count = 0;
    }


    public void add(T t) {
        list.add(t);
        count++;
    }

    public void remove(T t) {
        list.remove(t);
        count--;
    }
}
