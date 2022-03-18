
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Up implements Supplier<Integer> {
    private int cur;
    public Up() {
        this.cur = 0;
    }
    public Integer get() {
        cur++;
        return cur;
    }
}

public class LI {
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

    // Последовательность Collatz
    // - чётное число n переходит в n/2
    // - нечётное число n - в 3*n+1
    //
    // 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 -> 4 -> 2 -> 1 -> ...
    //
    // Напишите, используя Stream.iterate или Stream.generate,
    // функцию int task2(int n), которая возвращает наибольшее число,
    // которое встретится в последовательностях для чисел от 1 до n
    //
    // 1
    // 2 -> 1
    // 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // 4 -> 2 -> 1
    // 5 -> 16 -> 8 -> 4 -> 2 -> 1
    //
    // Поэтому task2(5) == 16 и task2(2) == 2
    public static int task2(int max) {
        return Stream.generate(new Up())
            .limit(max)
            .flatMapToInt((n) ->
                IntStream.iterate(n,
                               (m) -> m!=1,
                               (m) -> m%2==0 ? m/2 : 3*m+1))
            .max()
            .getAsInt();
    }
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        System.out.println(task(l));

        System.out.println(task2(2));
        System.out.println(task2(5));
        System.out.println(task2(50));
    }
}
