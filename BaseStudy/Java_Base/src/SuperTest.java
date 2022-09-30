public class SuperTest {
    public static void main(String[] args) {
        SuperExample e = new SuperExtendExample(1, 2, 3);
//        System.out.println(e.z);  此时e是父类的对象，没有成员z。如果将e强制转换成子类，但由于子类成员z为private，依旧不可使用！
        e.func();   // e调用的为子类的方法
        System.out.println(e.getClass());   // class SuperExtendExample
    }
}

// 父类
class SuperExample {
    protected int x;
    protected int y;

    public SuperExample(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void func() {
        System.out.println("SuperExample.func()");
    }
}

// 子类
class SuperExtendExample extends SuperExample {
    private int z;
    public SuperExtendExample(int x, int y, int z) {
        super(x, y);    // 使用super来调用父类构造函数
        this.z = z;
    }

    @Override
    public void func() {
        super.func();
        System.out.println("SuperExtendExample.func()");
    }
}
