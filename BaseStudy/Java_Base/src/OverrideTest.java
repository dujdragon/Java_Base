import java.util.ArrayList;
import java.util.List;

public class OverrideTest {
    /* 重写原则
     * 为了满足里氏替换原则，重写有以下三个限制：
     * 里氏替换原则：
     * 所有父类实例都可以用子类实例去替换
     * 1. 子类方法的访问权限必修大于或等于父类方法。     能用父类的都能用子类
     * 2. 子类方法的返回类型，必须是父类方法返回类型或者其子类。   子类返回的都是父类返回的。
     * 3. 子类抛出的异常类型，必须是父类抛出的异常类型或者其子类。
     */

    /* 函数在继承、重写中调用的顺序
     * 先从本类中查找是否有对应的方法
     * 如果没有再到父类中查看，看是否虫父类中继承来
     * 否则对参数进行转型，将参数转成其父类看有无对应方法
     * 1. this.func(this)
     * 2. super.func(this)
     * 3. this.func(super)
     * 4. super.func(super)
     */

    /* 声明为父类，但初始化为子类
     * 调用方法和成员时，按照父类的规则
     * 具体实现时，按照子类的规则
     *
     * 根本原因在于父类引用对象，指向的子类的内存地址
     */
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.show(a);  // 类A中存在show(A obj)方法，直接进行调用
        a.show(b);  // 类A中没有show(B obj)方法，首先从A的父类Object中找，如果没找到，则将B转换成父类A，找到show(A obj)方法。
        b.show(c);  // 类B中没有show(C obj)方法，从B的父类A中找到该方法
        b.show(d);  // 相当于将d强制类型转换成c，然后调用b.show(c)

        System.out.println("#######################");
        A ba = new B(); // 父类对象初始化为子类。父类的调用，子类的实现
        ba.show(a);
        ba.show(c);
        // ba.show(); Cannot resolve method 'show()'
    }
}

class SuperClass {
    protected List<Integer> func() throws Throwable {
        return new ArrayList<>();
    }
}

class SubClass extends SuperClass {
    /* 重写父类方法
     * 1. protected -> public
     * 2. List -> ArrayList
     * 3. Throwable -> Exception
     */
    @Override
    public ArrayList<Integer> func() throws Exception {
        return new ArrayList<>();
    }
}

class A {
    public void show(A obj) {
        System.out.println("A.show(A)");
    }

    public void show(C obj) {
        System.out.println("A.show(C)");
    }
}
class B extends A {
    public void show(A obj) {
        System.out.println("B.show(A)");
    }
    public void show() {
        System.out.println("B.show(D)");
    }
}

class C extends B {

}
class D extends C {

}