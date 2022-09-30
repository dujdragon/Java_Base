public class LimitedSwitch {
    public static void main(String[] args) {
        double d = 1.1;
//        switch (d) {
//            case 1.1:
//                System.out.println(d);
//                break;
//        }
        // switch 不支持 long、double、float，如果值过于复杂，使用if比较合适
        // Incompatible types. Found: 'double', required:
        // 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
    }
}
