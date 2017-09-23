package cn.imaq.java9demo;

public class SpinWaitDemo {
    private static volatile boolean full = false;

    public static void main(String[] args) {
        // Consumer
        new Thread(() -> {
            while (true) {
                while (!full) {
                    Thread.onSpinWait();
                }
                System.out.println("Consume");
                full = false;
            }
        }).start();

        // Producer
        new Thread(() -> {
            while (true) {
                while (full) {
                    Thread.onSpinWait();
                }
                System.out.println("Produce");
                full = true;
            }
        }).start();
    }
}
