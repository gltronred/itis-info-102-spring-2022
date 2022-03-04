import java.util.*;
import java.util.function.*;

public class L4 {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        l.replaceAll((x) -> x+2);
        l.removeIf((Integer x) -> {return x % 2 == 0;});

        System.out.println(l);
    }
}
