public class InterfaceModifiers {
    public static void main(String[] args) {
        System.out.println(InterfaceExample.x);     // 接口的字段默认是 public final static的
//        InterfaceExample.x = 230;
    }
}
interface InterfaceExample {
    void func1();
    default void func2() {
        System.out.println("func2");
    }
    int x = 123;

//    int y; Variable 'y' might not have been initialized
//    private int k = 0;  Modifier 'private' not allowed her
//    protected int j = 0; Modifier 'protected' not allowed here
//    private void func3();     Private methods in interfaces should have a body!!
}