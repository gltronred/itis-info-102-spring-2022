
class MyThread extends Thread {
    private int x;
    public MyThread(int x) {
        this.x = x;
    }
    public void run() {
        try {
            Thread.sleep(x*500);
        } catch (InterruptedException e) {}
        System.out.println(x+" ");
    }
}

public class L1 {
    public static void timeSort(int[] a) {
        for (int x: a) {
            MyThread t = new MyThread(x);
            t.start();
        }
    }
    public static void main(String[] args) {
        int[] a = {5, 7, 20, 1};
        timeSort(a);
    }
}
