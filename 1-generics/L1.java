import java.io.*;
import java.util.*;

//// Pair without generics
// class Pair {
//     Object fst;
//     Object snd;
//
//     Pair(Object fst, Object snd) {
//         this.fst = fst;
//         this.snd = snd;
//     }
//
//     Object getFirst() { return fst; }
//     Object getSecond(){ return snd; }
//
//     void setFirst(Object fst) { this.fst = fst; }
//     void setSecond(Object snd) { this.snd = snd; }
// }

class Pair<U,V> {
    U fst;
    V snd;

    Pair(U fst, V snd) {
        this.fst = fst;
        this.snd = snd;
    }

    U getFirst() { return fst; }
    V getSecond(){ return snd; }

    void setFirst(U fst) { this.fst = fst; }
    void setSecond(V snd) { this.snd = snd; }
}

public class L1 {
    static <U,V,W> void move(Pair<U,V> p1, Pair<V,W> p2) {
        p2.setFirst(p1.getSecond());
    }
    public static void main(String[] args) {
        //// Working with Pair without generics
        // Pair p1 = new Pair("abc", "def");
        // System.out.println(p1.getFirst());
        // System.out.println(p1.getSecond());

        // p1.setSecond(new Integer(123));
        // System.out.println(p1.getFirst());
        // System.out.println(p1.getSecond());
        // //Integer x = "123";

        // Pair p2 = new Pair("abc", new Pair("def", "ghi"));
        // System.out.println(p2.getFirst());
        // Pair p21 = (Pair)p2.getSecond();
        // System.out.println(p21.getFirst());
        // System.out.println(p21.getSecond());

        //// Working with generic Pair
        Pair<String,String> p1 = new Pair<String,String>("abc", "def");
        System.out.println(p1.getFirst());
        System.out.println(p1.getSecond());

        // // Compilation error! Can't convert Integer to String
        // p1.setSecond(new Integer(123));
        // System.out.println(p1.getFirst());
        // System.out.println(p1.getSecond());
        //Integer x = "123";

        Pair<String,Pair<String,String>> p2 = new Pair<>("abc", new Pair<>("def", "ghi"));
        System.out.println(p2.getFirst());
        System.out.println(p2.getSecond().getFirst());
        System.out.println(p2.getSecond().getSecond());

        Pair<Integer,Integer> p3 = new Pair<>(3,4);
        Pair<Integer,String> p4 = new Pair<>(3,"def");
        //move(p3,p4);
        L1.<Integer,Integer,String>move(p3,p4);
        System.out.println(p4.getFirst());
        System.out.println(p4.getSecond());

        // Compilation error!
        //move(p1,p3);
    }
}
