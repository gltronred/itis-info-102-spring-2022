import java.util.*;
import java.util.function.*;

public class L2 {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        l.replaceAll(new UnaryOperator<Integer>() {
                public Integer apply(Integer x) {
                    return x+3;
                }
            });
        l.removeIf(new Predicate<Integer>() {
                public boolean test(Integer x) {
                    return x % 2 == 0;
                }
            });

        System.out.println(l);
    }
}
