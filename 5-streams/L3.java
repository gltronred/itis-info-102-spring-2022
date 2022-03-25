
import java.util.*;
import java.util.stream.*;

public class L3 {
    // Напишите, используя collect и Collectors,
    // получение по входному IntStream с
    // цифрами числа количества различных
    // цифр в числе
    public static int digits(IntStream s) {
        return 0;
    }
    // Напишите reduce, который по входному
    // IntStream с цифрами числа получит
    // само значение числа
    public static int number(IntStream s) {
        return s.reduce(0, (x,y) -> 10*x + y);
    }
    public static void main(String[] args) {
        // [1,2,3]
        // (((0 + 1) + 2) + 3)
        //     \ /      \  /
        System.out.println(
            Stream.of(1,2,3)
                  .reduce(0,(a,b) -> a+b));
        // 1234
        System.out.println(
            number(IntStream.of(1,2,3,4)));
        // 4
        System.out.println(
            digits(IntStream.of(1,2,3,4)));
        // 2
        System.out.println(
            digits(IntStream.of(1,1,1,4)));
    }
}
