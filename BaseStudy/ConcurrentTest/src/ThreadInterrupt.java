public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();
        MyThread3 mt3 = new MyThread3();

        // 1. 如果线程中有InterruptedException的异常捕捉，则将会中断线程，并抛出异常
//        mt1.start();
//        mt1.interrupt();    // 对mt1进行中断

        // 2. 如果在线程中有死循环，则无法调用interrupt进行中断，但会更改interrupted的状态
//        mt2.start();
//        mt2.interrupt();

        // 3. 可以通过interrupted标记，来构建可以中断的死循环
//        mt3.start();
//        Thread.sleep(100);
//        mt3.interrupt();

        new Thread(()->{
            System.out.println("hhh");
        }).start();

    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(666);
        }
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(666);
        }
    }
}