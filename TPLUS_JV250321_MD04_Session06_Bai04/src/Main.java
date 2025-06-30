import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Tạo mảng có sẵn các sinh viên
        Student[] students = new Student[5];
        students[0] = new Student("Bob", 21, "A1", 7.5);
        students[1] = new Student("John", 21, "B1", 6.8);
        students[2] = new Student("Stark", 19, "A2", 8.2);
        students[3] = new Student("Charlie", 22, "C1", 5.9);
        students[4]  = new Student("Eve", 20, "A1", 7.1);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vàp điểm min: ");
        float min = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập vào điểm max: ");
        float max = Float.parseFloat(sc.nextLine());
        System.out.println("\nDanh sách sinh viên có điểm trung bình từ " +min + "đến " +max +":");
        for (Student student : students) {
            if (student.getAvgScore() >= min && student.getAvgScore() <= max) {
                System.out.println(student);
            }
        }
    }
}