import java.io.*;
import java.util.*;

public class L1 {
    // Сумму произведений соседних элементов
    // [1,2,3,5]
    // -> 23
    public static int sumProd1(List<Integer> l) {
        return 0;
    }
    // Из списка элементов удаляется каждый k элемент
    // Процесс повторяется пока не останется один элемент
    // Его вам и нужно вернуть
    public static <E> E last(int k, LinkedList<E> people) {
        return null;
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
