import java.util.Scanner;

public class Main {
    public static Student[] student = new Student[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.Hiển thị danh sách sinh viên");
            System.out.println("2.Thêm mới sinh viên");
            System.out.println("3.Sửa thông tin sinh viên");
            System.out.println("4.Xoá sinh viên");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    if (currentIndex > 1) {
                        for (int i = 0; i < currentIndex; i++) {
                            student[i].displayData();
                        }
                    }
                    System.err.println("Không có dữ liệu sinh viên");
                    break;
                case 2:
                    student[currentIndex].inputData(scanner);
                    break;
                case 3:
                    findStudentById(scanner);
                    break;
                case 4:
                    deleteStudentById(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1 đến 5");
            }
        } while (true);
    }

    public static void findStudentById(Scanner scanner) {
        System.out.println("Mời bạn nhận vào mã sinh viên cần sửa");
        int findID = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (student[i].getId() == findID) {
                System.out.println("Nhập thông tin mới:");
                student[i].inputData(scanner);
                break;
            }
        }
    }
    public static void deleteStudentById(Scanner scanner) {
        System.out.println("Nhập vào id sinh viên muốn xoá");
        int deleteID = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (student[i].getId() == deleteID) {
                for (int j = i; j < currentIndex - 1; j++) {
                    student[j] = student[j + 1];
                }
                student[currentIndex - 1] = null;
                currentIndex--;
                break;
            }
        }
    }
}
