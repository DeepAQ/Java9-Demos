package cn.imaq.java9demo;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandleDemo {
    private static VHAtomicInteger count = new VHAtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    // 输出的结果未必有序，因为 System.out.println 并不是原子操作
                    System.out.println(count.addAndGet(1));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    static class VHAtomicInteger extends Number {
        private int value; // 注意这里并没有直接声明为 volatile

        private static VarHandle valueHandle;
        static {
            try {
                valueHandle = MethodHandles.lookup().findVarHandle(VHAtomicInteger.class, "value", int.class);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        public VHAtomicInteger(int value) {
            this.value = value;
        }

        public int get() {
            return (int) valueHandle.getVolatile(this);
        }

        public int getAndAdd(int delta) {
            int v;
            do {
                v = (int) valueHandle.getVolatile(this);
            } while (!valueHandle.compareAndSet(this, v, v + delta));
            return v;
        }

        public int addAndGet(int delta) {
            return getAndAdd(delta) + delta;
        }

        // 剩下的方法以此类推，懒得实现了（

        @Override
        public int intValue() {
            return get();
        }

        @Override
        public long longValue() {
            return (long) get();
        }

        @Override
        public float floatValue() {
            return (float) get();
        }

        @Override
        public double doubleValue() {
            return (double) get();
        }
    }
}
