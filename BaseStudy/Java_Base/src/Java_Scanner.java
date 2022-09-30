import java.util.Scanner;

public class Java_Scanner {
    public static void main(String[] args) {
        // 键盘输入功能 Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入你的身高：");
        double length = scanner.nextDouble();
        System.out.println("你的姓名是：" + name + " 年龄为：" + age + " 身高为：" + length);
    }
}