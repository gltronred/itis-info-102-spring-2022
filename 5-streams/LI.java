
import java.util.*;
import java.util.stream.*;

/*
 * Написать функцию
 * `List<Integer> task(List<Integer> list)`,
 * которая список элементов
 * исходного списка, повторив каждый из них
 * столько раз, чему равен сам элемент.
 *
 * Использовать `java.util.stream.*`.
 *
 * Например,
 * `[1,2,3] -> [1,2,2,3,3,3]`.
 *
 * Подсказка: iterate.
 */

public class LI {
    public static List<Integer> task(List<Integer> list) {
        return
            list.stream()
            .flatMap((n) ->
                Stream.iterate(
                    new AbstractMap.SimpleEntry<Integer,Integer>(n,1),
                    (p) -> p.getValue()<=n,
                    (p) -> new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue()+1)))
            .map((p) -> p.getKey())
            .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        System.out.println(task(l));
    }
}
