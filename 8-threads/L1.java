import java.util.*;

// Добавить ещё один поток, который запустится
// после запуска всех потоков сортировки и
// подсчитает и выведет на экран, сколько в списке
// чисел, равных 1, равных 2 и т.д. равных 11
//
// 1 -> 1001
// 2 -> 998
// 3 -> 1230
// ...
// 11 -> ...

class MyThread extends Thread {
    private int x;
    private List<Integer> l;
    public MyThread(int x, List<Integer> l) {
        this.x = x;
        this.l = l;
    }
    public void run() {
        try {
            Thread.sleep(x*500);
        } catch (InterruptedException e) {}
        l.add(x);
    }
}

public class L1 {
    public static List<Integer> timeSort(int[] a) {
        List<Integer> l = Collections.synchronizedList(new LinkedList<>());
        MyThread[] threads = new MyThread[a.length];
        for (int i=0; i<a.length; i++) {
            threads[i] = new MyThread(a[i],l);
            threads[i].start();
        }
        // ЗАПУСК ПОТОКА ДЛЯ ЗАДАЧИ
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {}
        return l;
    }
    public static void main(String[] args) {
        int[] a = new int[10000];
        Random r = new Random();
        for (int i=0; i<a.length; i++) {
            a[i] = r.nextInt(10) + 1;
        }
        System.out.println("======");
        List<Integer> res = timeSort(a);
        System.out.println(res.get(0) + " " + res.get(1));
        System.out.println(res.size());
    }
}
