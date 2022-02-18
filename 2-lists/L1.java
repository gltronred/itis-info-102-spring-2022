import java.io.*;
import java.util.*;

public class L1 {
    // Сумму произведений соседних элементов
    // [1,2,3,5]
    // -> 23
    public static int sumProd1(List<Integer> l) {
        int result = 0;

        Iterator<Integer> i = l.listIterator();
        Iterator<Integer> j = l.listIterator();

        j.next();

        while (j.hasNext()) {
            result += i.next() * j.next();
        }

        return result;
    }
    public static int sumProd2(ArrayList<Integer> l) {
        int result = 0;

        for (int i = 0; i < l.size() - 1; i++) {
            int a = l.get(i);
            int b = l.get(i + 1);
            result += a * b;
        }

        return result;
    }

    // Из списка элементов удаляется каждый k элемент
    // Процесс повторяется пока не останется один элемент
    // Его вам и нужно вернуть
    public static <E> E last(int k, LinkedList<E> l) {
        int i=0;
        ListIterator<E> it = l.listIterator();

        while (l.size() > 1) {
            while (i != k) {
                if (!it.hasNext()) {
                    it = l.listIterator();
                }

                it.next();
                i++;
            }

            it.remove();
            i = 0;

            // DEBUG output
            System.out.println(l.toString());
        }

        return l.getFirst();
    }
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        for (Integer x : l) {
            System.out.println(x);
        }
        // k=3
        // [1,2,3,4,5]
        //  *   ^
        // [1,2,4,5]
        //  ^   *
        // [2,4,5]
        //  *   ^
        // [2,4]
        //  ^
        //  *
        // [4]
        System.out.println(last(3,l));
    }
}
