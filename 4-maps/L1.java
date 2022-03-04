import java.util.*;
import java.util.function.*;

class Add3 implements UnaryOperator<Integer> {
    public Integer apply(Integer x) {
        return x+3;
    }
}

class Even implements Predicate<Integer> {
    public boolean test(Integer x) {
        return x % 2 == 0;
    }
}

public class L1 {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        l.replaceAll(new Add3());
        l.removeIf(new Even());

        System.out.println(l);
    }
}
