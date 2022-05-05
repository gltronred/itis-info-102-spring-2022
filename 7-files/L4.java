import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class L4 {
    @Test
    public void testOk() throws FormatException{
        assertEquals(List.of(2,3),
                     splitLast("1 2 3",2));
        assertEquals(List.of(1,2),
                     splitLast("1 2",5));
    }
    @Test
    public void testNull() throws FormatException{
        assertNull(splitLast("",3));
    }
    @Test
    public void testException() {
        assertThrows(FormatException.class,
                     () -> splitLast("asd",3));
        assertThrows(FormatException.class,
                     () -> splitLast("1 2",3));
        assertThrows(FormatException.class,
                     () -> splitLast("1",3));
    }

    public static List<Integer> splitLast(String s, int n) throws FormatException {
        return new LinkedList<>();
    }
    public static void task2() throws IOException {
        PrintWriter wrong = new PrintWriter(new FileOutputStream("wrong.txt"));
        Files.lines(Path.of("input.txt"))
            .map(s -> Arrays.stream(s.split(" +"))
                         .mapToInt(Integer::parseInt)
                         .toArray())
            .forEach(xs -> {
                    if (xs.length == 3) {
                        String url = "https://placekitten.com/" + xs[1] + "/" + xs[2];
                        try (InputStream fis = new URL(url).openStream()) {
                            Path target = Path.of(xs[0] + ".jpg");
                            Files.copy(fis, target, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    } else {
                        for (int x : xs) {
                            wrong.print(x + " ");
                        }
                        wrong.println();
                    }
                });
        wrong.close();
    }
    public static int task3() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("dir.txt"));
        String dir = sc.nextLine();
        return (int)Files.find(Path.of(dir), Integer.MAX_VALUE,
                   (path, attr) -> {
                                   String filename = path.getFileName().toString();
                                   String[] parts = filename.split("\\.");
                                   return parts.length == 2 &&
                                       parts[0].matches("[0-9]+") &&
                                       parts[1].equals("jpg");
                            })
            .mapToInt(p -> {
                    try { return (int)Files.size(p); }
                    catch (IOException e) { return 0; }
                })
            .sum();
    }
    public static void main(String[] args) throws IOException {
        task2();
        System.out.println(task3());
    }
}

class FormatException extends Exception {}
