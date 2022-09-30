public class Java_DateTypeChange {
    public static void main(String[] args) {
        /* 默认数据类型转换：
        * 1. 如果一个操作数的类型为 double， 则整个表达式可提升为double型
        * 2. 满足自动类型转换的条件： 类型兼容、目标类型大于原类型
        * */
        double d1 = 42.12;
        int d2 = 4;
        System.out.println(d1 + d2);

        /* 数据类型强制转换
        * (目标数据类型)(表达式)
        * */
        System.out.println((int)d1);
    }
}
