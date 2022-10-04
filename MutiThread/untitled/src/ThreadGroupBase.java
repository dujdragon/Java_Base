/**
 * 每个线程都所属一个线程组，线程不能脱离ThreadGroup而存在！
 * 线程所属的线程组默认为父线程的线程组
 * main方法：所在线程为main，线程组为main
 */
public class ThreadGroupBase {
    public static void main(String[] args) {
        // Thread有静态方法currentThread来获得 当前线程对象的引用
        Thread testThread = new Thread(() -> {
            System.out.println("testThread所在线程组：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread所在线程：" + Thread.currentThread().getName());
        });

        Thread testThread2 = new Thread(testThread::start);
        testThread2.start();

        System.out.println("main 方法所在线程组：" + Thread.currentThread().getThreadGroup().getName());
        System.out.println("main 方法所在线程：" + Thread.currentThread().getName());
    }
}

/** Thread 的构造函数
 *     private Thread(ThreadGroup g, Runnable target, String name,
 *                    long stackSize, AccessControlContext acc,
 *                    boolean inheritThreadLocals) {
 *         if (name == null) {
 *             throw new NullPointerException("name cannot be null");
 *         }
 *
 *         this.name = name;
 *
 *         Thread parent = currentThread();
 *         SecurityManager security = System.getSecurityManager();
 *         if (g == null) {
 *            if (security != null) {
 *                 g = security.getThreadGroup();
 *             }
 *             if (g == null) {
 *                 g = parent.getThreadGroup();
 *             }
 *         }
 *         g.checkAccess();
 *         if (security != null) {
 *             if (isCCLOverridden(getClass())) {
 *                 security.checkPermission(
 *                         SecurityConstants.SUBCLASS_IMPLEMENTATION_PERMISSION);
 *             }
 *         }
 *
 *         g.addUnstarted();
 *
 *         this.group = g;
 *         this.daemon = parent.isDaemon();
 *         this.priority = parent.getPriority();
 *         if (security == null || isCCLOverridden(parent.getClass()))
 *             this.contextClassLoader = parent.getContextClassLoader();
 *         else
 *             this.contextClassLoader = parent.contextClassLoader;
 *         this.inheritedAccessControlContext =
 *                 acc != null ? acc : AccessController.getContext();
 *         this.target = target;
 *         setPriority(priority);
 *         if (inheritThreadLocals && parent.inheritableThreadLocals != null)
 *             this.inheritableThreadLocals =
 *                 ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);
 */