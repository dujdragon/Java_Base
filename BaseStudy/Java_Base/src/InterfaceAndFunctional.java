public class InterfaceAndFunctional {
    public static void main(String[] args) {
        /* Function<Integer, String> f = i -> i + "hh"; 这个语句发生了什么？？
         * 将后面的lambda表达式，默认赋值给接口的唯一函数！！！
         * 1. 是下面语句的简化
        Function<Integer, String> f1 = new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return i + "hh";
            }
        };
         * 2. 实际发生的事
        class tmp implements Function<Integer, String> {
            @Override
            public String apply(Integer i) {
                return i + "hh";
            }
        }
        Function<Integer, String> f2 = new tmp();
         *
         * 当接口只有一个抽象方法时，可以简化成Lambda表达式形式的函数式编程，但实际上就是类的实例化以及抽象函数的重写
         */
        Function<Integer, String> f = i -> i + "hh";
        Function<Integer, String> f1 = new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return i + "hh";
            }
        };
        Function<Integer, String> f2 = new tmp();
        String s = f.apply(10);
        System.out.println(s);

        // 匿名的接口实例化
        test t = new test() {
            @Override
            public int testFunc() {
                return 10;
            }
        };
        System.out.println(t.testFunc());
        System.out.println("##############");

        FunctionTest<Integer, String> ft = new FunctionTest<>();
        ft.func(i -> i + "ll", 12);
    }


}

interface Function<T, R> {
    R apply(T t);
//    int test();
}

class FunctionTest<T, R>  {
    public void func(Function<T, R> function, T t) {
        R r = function.apply(t);
        System.out.println(r);
    }
}

interface test {
    int testFunc();
}

class tmp implements Function<Integer, String> {
    @Override
    public String apply(Integer i) {
        return i + "hh";
    }
}