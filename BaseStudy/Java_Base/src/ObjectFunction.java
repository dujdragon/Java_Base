import java.util.HashSet;

public class ObjectFunction {

    public static void main(String[] args) {
        /* equals()
        * 1. 对于基本类型，== 用于判断两个值是否相等，基本类型没有equals()方法！！
        * 2. 对于引用类型，== 用于判断两个变量是否引用同一个对象，而equals()用于判断引用的对象是否等价！！
        *
        * equals() 的实现：
        * 1. 检查是否为同一个对象的引用，如果是直接返回true
        * 2. 检查是否是同一个类型，如果不是，直接返回false
        * 3. 将Object对象进行转型
        * 4. 判断每个关键域是否相等
        * */
        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x == y); // false x、y指向不同对象
        System.out.println(x.equals(y)); // true x、y指向对象的值相同

        System.out.println("#################################");

        /*  hashCode()
         *  在覆盖equals()方法时应当总是覆盖hashCode()方法，保证等价的两个对象哈希值也相等
         */
        EqualsExample e1 = new EqualsExample(1, 1, 1);
        EqualsExample e2 = new EqualsExample(1, 1, 1);
        System.out.println(e1 == e2);   // false
        System.out.println(e1.equals(e2));  // true

        // 理想的哈希函数应当具有均匀性，即不相等的对象应当均匀分布到所有可能的哈希值上
        // 我们希望当两个对象一样时，只在集合中添加一个对象
        HashSet<EqualsExample> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        System.out.println("set.size(): " + set.size());    // 2 当更改hashCode()函数后，结果为1
    }

}

class EqualsExample {
    private int x;
    private int y;
    private int z;

    public EqualsExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // equals() 的实现
    @Override
    public boolean equals(Object obj) {
        // 实现equals的四大步骤
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EqualsExample o = (EqualsExample) obj;
        return (o.x == this.x && o.y == this.y && o.z == this.z);
    }

    /* hashCode() 的实现
     * 为了保证相同的两个对象（equals()返回true）的哈希值相等
     * 1. 把所有域的值都考虑进来
     * 2. 把每个域的值都当成R进制的某一位，然后组成一个R进制的整数
     * 3. R一般取31，是个奇素数
     */

    @Override
    public int hashCode() {
        // 把31换成10会好理解一点
        int res = 17;
        res = 31 * res + x;
        res = 31 * res + y;
        res = 31 * res + z;
        return res;
    }
}