import java.io.*;
import java.nio.file.*;
import java.util.*;

public class L4 {
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
        System.out.println(task3());
    }
}
