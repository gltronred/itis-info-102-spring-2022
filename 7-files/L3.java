import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/*
 * Рекурсивно пройтись по всем файлам в sourceDir,
 * скопировать их в подпапку targetDir, названную
 * по расширению файла.
 *
 * Если какие-то исходные файлы при этом
 * перезаписывают результат, вывести сообщение на
 * экран.
 *
 * Например, такая структура папок в source
 *
 *   source
 *   |
 *   +- dir1
 *   |
 *   +- dir2
 *   |  |
 *   |  +- f1.txt
 *   +- f2.bmp
 *   |
 *   +- L.java
 *   |
 *   +- f1.txt
 *
 * должна преобразоваться в следующую структуру в
 * target:
 *
 *   target
 *   |
 *   +- bmp
 *   |  |
 *   |  +- f2.bmp
 *   +- java
 *   |  |
 *   |  +- L.java
 *   +- txt
 *      |
 *      +- f1.txt
 *
 * При этом файл f1.txt будет перезаписан (он есть
 * два раза), поэтому во второй раз об этом должно
 * быть написано в консоль
 */
public class L3 {
    public static String getFileExt(Path path) {
        String filename = path.getFileName().toString();
        String[] components = filename.split("\\.");
        if (components.length == 1) {
            return "";
        }
        return components[components.length-1];
    }
    public static void task(Path sourceDir, Path targetDir) throws IOException {
        System.out.println("Copy by types from " +
                           sourceDir + " to " +
                           targetDir);
        try (Stream<Path> paths = Files.walk(sourceDir)) {
            paths
                .filter(Files::isRegularFile)
                .forEach(source -> {
                        Path target = targetDir
                            .resolve(getFileExt(source))
                            .resolve(source.getFileName());
                        try {
                            Files.createDirectories(target.getParent());
                            if (Files.exists(target)) {
                                System.out.println("File " + target + " is overwritten");
                            }
                            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    });
        }
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java L3 <source> <target>");
            return;
        }

        Path sourceDir = Path.of(args[0]);
        Path targetDir = Path.of(args[1]);

        task(sourceDir, targetDir);
    }

    @Test
    public void simpleExtTest() {
        assertEquals("txt", getFileExt(Path.of("some.txt")));
        assertEquals("class", getFileExt(Path.of("some.class")));
        assertEquals("TXT", getFileExt(Path.of("some.TXT")));
    }
    @Test
    public void doubleExtTest() {
        assertEquals("txt", getFileExt(Path.of("some.other.txt")));
    }
    @Test
    public void noExtTest() {
        assertEquals("", getFileExt(Path.of("some")));
    }
    @Test
    public void noNameTest() {
        assertEquals("git", getFileExt(Path.of(".git")));
    }
}
