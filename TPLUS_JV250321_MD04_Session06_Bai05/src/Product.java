import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product() {}
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào id sản phẩm");
        this.id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên sản phẩm");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm");
        this.price = Double.parseDouble(scanner.nextLine());
    }

    public void displayData() {
        System.out.printf("ID: %d, Tên: %s, GIá: %.1f\n ", id, name, price);
    }

}
