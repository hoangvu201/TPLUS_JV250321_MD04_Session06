import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chiều dài hcn");
        double x = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập vào chiều rộng hcn");
        double y = Double.parseDouble(scanner.nextLine());
        System.out.println("Hình chữ nhật 1:");
        rectangle.display();

        Rectangle rectangle1 = new Rectangle(x,y);
        System.out.println("Hình chữ nhật 2:");
        rectangle1.display();
    }
}
