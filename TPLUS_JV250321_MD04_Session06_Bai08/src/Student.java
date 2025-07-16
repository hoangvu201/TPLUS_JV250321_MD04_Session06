import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public Student() {
    }

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào id học sinh: ");
        this.id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên học sinh");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào tuổi học sinh");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính học sinh(MALE | FEMALE | OTHER)");
        String gender = scanner.nextLine().toUpperCase();
        this.gender = Gender.valueOf(gender);
        System.out.println("Nhập địa chỉ học sinh");
        String address = scanner.nextLine();
        System.out.println("Nhập vào số điện thoại ");
        this.phoneNumber = scanner.nextLine();
    }
    public void displayData() {
        System.out.println("Id: " + this.id);
        System.out.println("Tên: " + this.name);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Giới tính: " + this.gender);
        System.out.println("Địa chỉ: " + this.address);
        System.out.println("Số điện thoại: " + this.phoneNumber);
    }
}
