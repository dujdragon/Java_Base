/**
 * Java线程优先级可以进行指定 范围为1~10.
 * Java线程优先级的设置只是给操作系统一个参考，实际的优先级还是由操作系统决定，所以并不可靠
 * Java线程的默认优先级是 5
 * 守护线程（daemon）的默认优先级比较低
 *
 * 如果某个线程的优先级大于所在线程阻的优先级，那么改线程的优先级将会失效，并采用线程组的优先级
 */
public class ThreadPriority {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(5);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);

        System.out.println("线程组的优先级：" + threadGroup.getMaxPriority());
        System.out.println("线程的优先级：" + thread.getPriority());
    }
}

/** Thread类的setPriority方法
 *     public static final int MIN_PRIORITY = 1;
 *     public static final int NORM_PRIORITY = 5;
 *     public static final int MAX_PRIORITY = 10;
 *
 *     public final void setPriority(int newPriority) {
 *         ThreadGroup g;
 *         checkAccess();
 *         if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
 *             throw new IllegalArgumentException();
 *         }
 *         if((g = getThreadGroup()) != null) {
 *             if (newPriority > g.getMaxPriority()) {   只对大于线程组优先级的情况进行判断
 *                 newPriority = g.getMaxPriority();
 *             }
 *             setPriority0(priority = newPriority);
 *         }
 *     }
 */