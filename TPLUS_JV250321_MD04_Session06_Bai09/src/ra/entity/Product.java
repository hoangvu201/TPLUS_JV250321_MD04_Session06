package ra.entity;

import ra.presentation.ShopManagement;
import ra.validator.Validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int categoryId;
    private int status;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int categoryId, int status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.price = inputPrice(scanner);
        this.description = inputDescription(scanner);
        this.categoryId = inputCategoryId(scanner);
        this.status = inputStatus(scanner);
    }

    public String inputProductId(Scanner scanner) {
        String productIdRegex = "[CSA]\\w{3}";
        System.out.println("Nhập vào mã sản phẩm");
        do {
            String productId = scanner.nextLine();
            if (!Validation.isEmpty(productId)) {
                if (Pattern.matches(productIdRegex, productId)) {
                    boolean isExit = false;
                    for (int i = 0; i < ShopManagement.currentProduct; i++) {
                        if (ShopManagement.products[i].getProductId().equals(productId)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (!isExit) {
                        return productId;
                    }
                    System.err.println("Mã sản phẩm tồn tại, vui lòng nhập lại");
                } else {
                    System.err.println("Mã sản phẩm gồm 4 kí tự bắt đầu là C | S | A, vui lòng nhập lại");
                }
            } else {
                System.err.println("Vui lòng nhập mã sản phẩm");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner) {
        String productNameRegex = "\\w{10,50}";
        System.out.println("Nhập vào tên sản phẩm: ");
        do {
            String productName = scanner.nextLine();
            if (!Validation.isEmpty(productName)) {
                if (Pattern.matches(productNameRegex, productName)) {
                    boolean isExit = false;
                    for (int i = 0; i < ShopManagement.currentProduct; i++) {
                        if (ShopManagement.products[i].getProductName().equals(productName)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (!isExit) {
                        return productName;
                    }
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                } else {
                    System.err.println("Tên sản phẩm có từ 10 đến 50 kú tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Vui lòng nhập tên sản phẩm");
            }
        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Nhập vào giá sản phẩm: ");
        do {
            if (scanner.hasNextFloat()) {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    return price;
                }
                System.err.println("Giá sản phẩm có giá trị lớn hơn 0, vui lòng nhập lại");
            } else {
                System.err.println("Giá sản phẩm là số thực, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả sản phẩm: ");
        do {
            String description = scanner.nextLine();
            if (!Validation.isEmpty(description)) {
                return description;
            }
            System.err.println("Vui lòng nhập mô tả sản phẩm");
        } while (true);
    }

    public int inputCategoryId(Scanner scanner) {
        for (int i = 0; i < ShopManagement.currentCategory; i++) {
            if (ShopManagement.categories[i].isCatalogStatus()) {
                System.out.printf("%d. %s\n", ShopManagement.categories[i].getCatalogId(), ShopManagement.categories[i].getCatalogName());
            }
        }
        System.out.print("Lựa chọn của bạn: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputStatus(Scanner scanner) {
        System.out.println("Lựa chọn trạng thái sản phẩm");
        System.out.println("1.Đang bán");
        System.out.println("2.Hết hàng");
        System.out.println("3.Không bán");
        return Validation.inputChoice(scanner, "Lựa chọn của bạn", 3) - 1;
    }

    public void displayData() {
        System.out.printf("Mã SP: %s - Tên SP: %s - Giá: %.1f", this.productId, this.productName, this.price);
        System.out.printf("Mô tả: %s - Danh mục: %s - Trạng thi: %s\n",
                this.description, Categories.getCatalogNameByID(this.categoryId),
                this.status == 0 ? "Đang bán" : (this.status == 1 ? "Hết hàng" : "Không bán"));
    }
}
