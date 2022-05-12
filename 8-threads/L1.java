
public class L1 {
    public static void timeSort(int[] a) {
        for (int x: a) {
            new Thread(() -> {
                    try {
                        Thread.sleep(x*500);
                    } catch (InterruptedException e) {}
                    System.out.println(x+" ");
            }).start();
        }
    }
    public static void main(String[] args) {
        int[] a = {5, 7, 20, 1};
        timeSort(a);
    }
}
