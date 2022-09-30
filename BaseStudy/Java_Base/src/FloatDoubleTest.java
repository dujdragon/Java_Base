public class FloatDoubleTest {
    public static void main(String[] args) {
//        float f = 1.1;  (no) java: 不兼容的类型: 从double转换到float可能会有损失
        float f = 1.1f; // (yes) 字面量 1.1 默认为double，不能默认向下类型转换为float

    }
}
