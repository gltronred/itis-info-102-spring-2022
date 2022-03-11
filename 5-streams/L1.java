import java.util.*;
import java.util.stream.*;

public class L1 {
    public static void task1(List<Integer> l) {
        l.removeIf((x) -> x%3 == 0);

        ListIterator<Integer> it = l.listIterator();
        while (it.hasNext()) {
            Integer x = it.next();
            it.set(Math.abs(x));
        }

        it = l.listIterator();
        while (it.hasNext()) {
            Integer x = it.next();
            for (int i=0; i<x; i++) {
                System.out.print("a");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(-3);
        l.add(2);
        l.add(1);
        l.add(2);
        l.add(6);

        task1(l);
    }
}
