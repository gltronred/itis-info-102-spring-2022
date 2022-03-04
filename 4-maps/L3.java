import java.util.*;
import java.util.function.*;

public class L3 {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        l.replaceAll((Integer x) -> {
                System.out.println(x);
                return x+3;
            });
        l.removeIf((Integer x) -> {
                System.out.println("test: " + x);
                return x % 2 == 0;
            });

        System.out.println(l);
    }
}
