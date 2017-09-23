package cn.imaq.java9demo;

public class StackWalkDemo {
    private static void dummyMethod(int depth) {
        if (depth == 3) {
            // Java 9 获取当前运行堆栈
            System.out.println("StackWalker:");
            StackWalker walker = StackWalker.getInstance();
            walker.forEach(System.out::println);
            // Java 8 获取当前运行堆栈
            System.out.println("getStackTrace:");
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                System.out.println(element);
            }
        } else {
            ((Runnable) () -> dummyMethod(depth + 1)).run();
        }
    }

    public static void main(String[] args) {
        dummyMethod(1);
    }
}
