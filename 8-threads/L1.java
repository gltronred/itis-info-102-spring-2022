import java.util.*;

class MyThread extends Thread {
    private int x;
    private LinkedList<Integer> l;
    public MyThread(int x, LinkedList<Integer> l) {
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
    public static LinkedList<Integer> timeSort(int[] a) {
        LinkedList<Integer> l = new LinkedList<>();
        MyThread[] threads = new MyThread[a.length];
        for (int i=0; i<a.length; i++) {
            threads[i] = new MyThread(a[i],l);
            threads[i].start();
        }
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {}
        return l;
    }
    public static void main(String[] args) {
        int[] a = {5, 7, 20, 1};
        LinkedList<Integer> res = timeSort(a);
        System.out.println(res);
    }
}
