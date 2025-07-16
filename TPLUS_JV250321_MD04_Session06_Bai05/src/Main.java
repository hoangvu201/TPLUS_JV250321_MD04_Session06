import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Product[] products = new Product[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1.Thêm mới sản phẩm");
            System.out.println("2.Hiển thị danh sách sản phẩm");
            System.out.println("3.Cập nhật sản phẩm");
            System.out.println("4.Xoá sản phẩm");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    products[currentIndex] = new Product();
                    products[currentIndex].inputData(sc);
                    currentIndex++;
                    break;
                case 2:
                    for (int i = 0; i < currentIndex; i++) {
                        products[i].displayData();
                    }
                    break;
                case 3:
                    updateProductById(sc);
                    break;
                case 4:
                    deleteProductById(sc);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn từ 1 đến 5");
            }
        } while (true);
    }

    public static void updateProductById(Scanner sc) {
        System.out.println("Nhập vào id sản phẩm cần thay đổi: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getId() == id) {
                System.out.println("Nhập vào tên mới của sản phẩm");
                String newName = sc.nextLine();
                products[i].setName(newName);
                System.out.println("Nhập vào giá mới của sản phẩm");
                double newPrice = Double.parseDouble(sc.nextLine());
                products[i].setPrice(newPrice);
                break;
            } else {
                System.err.println("ID không đúng hoặc không tồn tại");
            }
        }
    }

    public static void deleteProductById(Scanner sc) {
        System.out.println("Nhập vào id sản phẩm cần xoá: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getId() == id) {
                products[i] = products[i + 1];
                products[currentIndex - 1] = null;
                currentIndex--;
                break;
            } else {
                System.err.println("Id không đúng hoặc không tồn tại");
            }
        }
    }
}