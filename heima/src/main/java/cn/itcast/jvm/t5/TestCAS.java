package cn.itcast.jvm.t5;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestCAS {
    public static void main(String[] args) throws InterruptedException {
        DataContainer dc = new DataContainer();
        int count = 5;
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> dc.increase());
            t1.start();
        }
//        t1.join();
        Thread.sleep(2000);
        System.out.println(dc.getData());
    }
}

class DataContainer {
    private volatile int data = 0;
    static final Unsafe unsafe;
    static final long DATA_OFFSET;

    static {
        try {
// Unsafe 对象不能直接调用，只能通过反射获得
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
        try {
// data 属性在 DataContainer 对象中的偏移量，用于 Unsafe 直接访问该属性
            DATA_OFFSET =
                    unsafe.objectFieldOffset(DataContainer.class.getDeclaredField("data"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public void increase() {
        int oldValue;
        while (true) {
// 获取共享变量旧值，可以在这一行加入断点，修改 data 调试来加深理解
            oldValue = data;
// cas 尝试修改 data 为 旧值 + 1，如果期间旧值被别的线程改了，返回 false
            if (unsafe.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue +
                    1)) {
                return;
            }
        }
    }

    public void increase2() {
        synchronized (TestCAS.class) {
            data++;
        }
    }

    public void decrease() {
        int oldValue;
        while (true) {
            oldValue = data;
            if (unsafe.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue -
                    1)) {
                return;
            }
        }
    }

    public int getData() {
        return data;
    }
}