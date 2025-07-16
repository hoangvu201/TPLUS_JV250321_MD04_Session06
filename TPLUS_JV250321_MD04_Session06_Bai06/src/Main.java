import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Category[] categories = new Category[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1.Thêm mới danh mục");
            System.out.println("2.Hiển thị danh sách danh mục");
            System.out.println("3.Cập nhật danh mục");
            System.out.println("4.Xoá danh mục");
            System.out.println("5.Tìm kiếm theo tên");
            System.out.println("6.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categories[currentIndex] = new Category();
                    categories[currentIndex].inputData(sc);
                    currentIndex++;
                    break;
                case 2:
                    for (int i = 0; i < currentIndex; i++) {
                        categories[i].displayData();
                    }
                    break;
                case 3:
                    updateProductById(sc);
                    break;
                case 4:
                    deleteProductById(sc);
                    break;
                case 5:
                    findProductByName(sc);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn từ 1 đến 5");
            }
        } while (true);
    }

    public static void updateProductById(Scanner sc) {
        System.out.println("Nhập vào id danh mục cần thay đổi: ");
        String id = (sc.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (categories[i].getId().trim().toLowerCase().equals(id)) {
                System.out.println("Nhập vào tên mới của sản phẩm");
                String newName = sc.nextLine();
                categories[i].setName(newName);
                System.out.println("Nhập vào mô tả mới của sản phẩm");
                String newDescription = sc.nextLine();
                categories[i].setDescription(newDescription);
                break;
            } else {
                System.err.println("ID không đúng hoặc không tồn tại");
            }
        }
    }

    public static void deleteProductById(Scanner sc) {
        System.out.println("Nhập vào id danh mục cần xoá: ");
        String id = sc.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (categories[i].getId().trim().toLowerCase().equals(id)) {
                categories[i] = categories[i + 1];
                categories[currentIndex - 1] = null;
                currentIndex--;
                break;
            } else {
                System.err.println("Id không đúng hoặc không tồn tại");
            }
        }
    }
    public static void findProductByName(Scanner sc) {
        System.out.println("Nhập vào tên danh mục cần tìm kiếm: ");
        String name = sc.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (categories[i].getName().trim().toLowerCase().equals(name)) {
               categories[i].displayData();
            }
        }
    }
}