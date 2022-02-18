
import java.io.*;
import java.util.*;

class Grandparent {}
class Parent extends Grandparent {}
class Child extends Parent {}

class Coll<E> {
    void add(E e) {}
    void addAll(Coll<E> c) {}
}

class Pred<E> {
    boolean test(E t) {
        return true;
    }
}

public class L2 {
    public static void main(String[] args) {
        Coll<Parent> coll = new Coll<>();
        Coll<Child> coll1 = new Coll<>();

        coll.add(new Child());
        coll.addAll(coll1);
    }
}
