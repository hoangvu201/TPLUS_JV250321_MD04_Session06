package ra.presentation;

import ra.entity.Categories;
import ra.entity.Product;
import ra.validator.Validation;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] categories = new Categories[100];
    public static Product[] products = new Product[100];
    public static int currentCategory = 0;
    public static int currentProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**********SHOP MENU*********");
            System.out.println("1.Quản lý danh mục sản phẩm");
            System.out.println("2.Quản lý sản phẩm");
            System.out.println("3.Thoát");
            int choice = Validation.inputChoice(scanner, "Lựa chọn của bạn", 3);
            switch (choice) {
                case 1:
                    displayCategoriesMenu(scanner);
                    break;
                case 2:
                    displayProductMenu(scanner);
                    break;
                default:
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayCategoriesMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("**********CATEGORIES MENU*********");
            System.out.println("1.Thêm mới danh mục");
            System.out.println("2.Danh sách danh mục");
            System.out.println("3.Cập nhật danh mục");
            System.out.println("4.Xoá danh mục");
            System.out.println("5.Cập nhật trạng thái danh mục");
            System.out.println("6.Thoát");
            int choice = Validation.inputChoice(scanner, "Lựa chọn của bạn", 6);
            switch (choice) {
                case 1:
                    createCategories(scanner);
                    break;
                case 2:
                    displayListCategories();
                    break;
                case 3:
                    updateCategories(scanner);
                    break;
                case 4:
                    deleteCategories(scanner);
                    break;
                case 5:
                    updateCatalogStatus(scanner);
                    break;
                default:
                    isExit = false;
            }
        } while (isExit);
    }

    public static void createCategories(Scanner scanner) {
        categories[currentCategory] = new Categories();
        categories[currentCategory].inputData(scanner);
        currentCategory++;
    }

    public static void displayListCategories() {
        for (int i = 0; i < currentCategory; i++) {
            categories[i].displayData();
        }
    }

    public static int findIndexByCatalogId(int catalogId) {
        for (int i = 0; i < currentCategory; i++) {
            if (categories[i].getCatalogId() == catalogId) {
                return i;
            }
        }
        return -1;
    }

    public static void updateCategories(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findIndexByCatalogId(catalogId);
        if (indexUpdate != -1) {
            boolean isExit = true;
            do {
                System.out.println("1.Cập nhật tên danh mục");
                System.out.println("2.Cập nhật mô tả");
                System.out.println("3.Cập nhật trạng thái");
                System.out.println("4.Thoát");
                int choice = Validation.inputChoice(scanner, "Lựa chọn của bạn", 3);
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên mới của danh mục: ");
                        String catalogName = categories[indexUpdate].checkCatalogName(scanner);
                        categories[indexUpdate].setCatalogName(catalogName);
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả mới của danh mục: ");
                        String description = categories[indexUpdate].checkDescription(scanner);
                        categories[indexUpdate].setDescription(description);
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái mới của danh mục: ");
                        categories[indexUpdate].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    default:
                        isExit = false;

                }
            } while (isExit);
        }
    }

    public static void deleteCategories(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xoá");
        int indexDelete = findIndexByCatalogId(Integer.parseInt(scanner.nextLine()));
        if (indexDelete != -1) {
            for (int i = indexDelete; i < currentCategory-1 ; i++) {
                categories[i] = categories[i+1];
            }
            categories[currentCategory - 1] = null;
            currentCategory--;
        }else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void updateCatalogStatus(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật trạng thái: ");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findIndexByCatalogId(catalogId);
        if (indexUpdate != -1) {
            categories[indexUpdate].setCatalogStatus(!categories[indexUpdate].isCatalogStatus());
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void displayProductMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("**********PRODUCTS MENU*********");
            System.out.println("1.Thêm mới sản phẩm");
            System.out.println("2.Danh sách sản phẩm");
            System.out.println("3.Sắp xếp sản phẩm theo giá");
            System.out.println("4.Cập nhật sản phẩm ");
            System.out.println("5.Xoá sản phẩm");
            System.out.println("6.Tìm kiếm sản phẩm theo tên");
            System.out.println("7.Tìm kiếm sản phẩm theo khoảng giá");
            System.out.println("8.Thoát");
            int choice = Validation.inputChoice(scanner, "Lựa chọn của bạn", 8);
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    isExit = false;
            }
        } while (isExit);

    }
    public static void createProduct(Scanner scanner) {
        products[currentProduct] = new Product();
        products[currentProduct].inputData(scanner);
        currentProduct++;
    }

    public static void displayListProduct(Scanner scanner) {
        for (int i = 0; i < currentProduct; i++) {
            products[i].displayData();
        }
    }

    public static void sortProductByPrice(Scanner scanner) {
        for (int i = 0; i < currentProduct -1; i++) {
            for (int j = i + 1; j < currentProduct; j++) {
                if (products[i].getPrice() > products[j].getPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }

    public static int findIndexByProductId(String productId) {
        for (int i = 0; i < currentProduct; i++) {
            if (products[i].getProductId().trim().toLowerCase().equals(productId)) {
                return i;
            }
        }
        return -1;
    }
}
