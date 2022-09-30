public class CachePoolTest {
    public static void main(String[] args) {
        Integer a = 123;
        Integer b = 123;
        // a和b在缓冲池 -128 ~ 127 中
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);

        System.out.println("##########################");

        // String 也有缓冲池，同样的字符串不会再创建一次
        // intern：如果cache pool中没有，就放进去，有就拿出来
        // 如果以字面量的形式创建字符串，会自动的放到cache pool中
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        String s5 = s3.intern();
        String s6 = s4.intern();


        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s5 == s6);

        System.out.println("##########################");

        String s7 = new String("efg");
        String s8 = new String(s7);
        System.out.println(s7 == s8);
    }
}
