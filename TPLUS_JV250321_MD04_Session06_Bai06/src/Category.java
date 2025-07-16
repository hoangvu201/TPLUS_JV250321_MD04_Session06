import java.util.Scanner;

public class Category {
    private String id;
    private String name;
    private String description;

    public Category() {
    }

    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào id sản phẩm");
        this.id = scanner.nextLine();
        System.out.println("Nhập vào tên sản phẩm");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào mô tả sản phẩm");
        this.description = scanner.nextLine();
    }

    public void displayData() {
        System.out.printf("ID: %s, Tên: %s, Mô tả: %s\n ", id, name,description);
    }

}
