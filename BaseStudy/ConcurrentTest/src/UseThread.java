import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现接口 VS 继承Thread类
 * 1. Java不支持多继承，如果继承了Thread就不能继承其他类，但支持多接口
 * 2. 继承整个Thread类开销过大
 */
public class UseThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 当要启动一个线程时，需要一个任务实例以及一个线程实例
        RunnableTest rt = new RunnableTest();   // 任务实例
        Thread t1 = new Thread(rt); // 初始化任务为rt的线程实例
        t1.start();     // 启动线程

        /**
         * 注意！！！ Callable
         * 1. Callable主要是针对线程运行结果的返回值，将任务封装到FutureTask并通过FutureTask来实例化线程
         * 线程运行结束后通过FutureTask的get方法来获得返回值
         * 2. 在实例化FutureTask时需要提前指定返回值的类型
         *      1) 不能基本类型
         *      2） 如果与返回值类型不匹配，则将会抛出异常并终止程序
         *      3） 如果通过该FutureTask实例定义的线程没有运行，直接调用get方法，则会造成线程堵塞！！！
         * 3. FutureTask implement RunnableFuture
         *    RunnableFuture implement Runnable
         */
        CallableTest ct = new CallableTest();   // 任务实例
        FutureTask<Integer> ft = new FutureTask<Integer>(ct);
        Thread t2 = new Thread(ft);
        t2.start();
        System.out.println(ft.get());

        new ThreadTest().start();
    }
}

// 1. 实现Runnable接口
class RunnableTest implements Runnable {
    // 当一个类实现Runnable接口时，相当于将这个类定义为线程中的一共任务，任务的内容放在run方法中
    @Override
    public void run() {
        System.out.println("RunnableTest is running...");
    }
}

// 2. 实现Callable接口，与Runnable相比Callable有返回值，且返回值使用FutureTask<T>进行封装
class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("CallableTest is running...");
        return 10;
    }
}

// 3. 继承Thread类，由于Thread类实现了Runnable接口，可以直接通过start方法来启动进程
class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadTest is running...");
    }
}