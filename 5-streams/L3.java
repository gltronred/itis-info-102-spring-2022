
import java.util.*;
import java.util.stream.*;

public class L3 {
    public static void main(String[] args) {
        // [1,2,3]
        // (((0 + 1) + 2) + 3)
        //     \ /      \  /
        System.out.println(
            Stream.of(1,2,3)
                  .reduce(0,(a,b) -> a+b));
    }
}
