
import java.io.*;
import java.util.*;

class Grandparent {
    private int tvHours;
    public Grandparent(int tvHours) {
        this.tvHours = tvHours;
    }
    public int getTvHours() { return tvHours; }
}
class Parent extends Grandparent {
    private int computerHours;
    public Parent(int tvHours, int computerHours) {
        super(tvHours);
        this.computerHours = computerHours;
    }
    public int getComputerHours() { return computerHours; }
}
class Child extends Parent {
    private int socialNetHours;
    public Child(int t, int c, int s) {
        super(t,c);
        this.socialNetHours = s;
    }
    public int getSocialNetHours() { return socialNetHours; }
}

class Coll<E> {
    void add(E e) {}
    void addAll(Coll<? extends E> c) {}
    void removeIf(Pred<? super E> pred) {}
}

interface Pred<E> {
    boolean test(E t);
}

class AdForSenior implements Pred<Grandparent> {
    public boolean test(Grandparent x) {
        return x.getTvHours() > 4;
    }
}
class AdForJunior implements Pred<Child> {
    public boolean test(Child x) {
        return x.getSocialNetHours() > 4;
    }
}

public class L2 {
    public static void main(String[] args) {
        Coll<Parent> coll = new Coll<>();

        Coll<Child> coll1 = new Coll<>();
        coll.add(new Child(1,2,3));
        coll.addAll(coll1);

        coll.removeIf(new AdForSenior());
        //coll.removeIf(new AdForJunior());
    }
}
