import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên người thứ nhất: ");
        person1.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ nhất: ");
        person1.setAge(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhập tên người thứ hai: ");
        person2.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ hai: ");
        person2.setAge(Integer.parseInt(sc.nextLine()));
        System.out.println();
        if (person1.getAge() > person2.getAge()) {
            System.out.println(person1.getName() +" lớn tuổi hơn " +person2.getName());
        } else {
            System.out.println(person2.getName() +" lớn tuổi hơn " +person1.getName());
        }
    }
}