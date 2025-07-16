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
                    menuProducts(scanner);
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
            for (int i = indexDelete; i < currentCategory - 1; i++) {
                categories[i] = categories[i + 1];
            }
            categories[currentCategory - 1] = null;
            currentCategory--;
        } else {
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

    public static void menuProducts(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1.Nhập thông tin các sản phẩm");
            System.out.println("2.Hiển thị thông tin các sản phẩm");
            System.out.println("3.Sắp xếp các sản phẩm theo giá");
            System.out.println("4.Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5.Xoá sản phẩm theo mã sản phẩm");
            System.out.println("6.Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7.Tìm kiếm sản phẩm trong khoảng giá a-b ");
            System.out.println("8.Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    findAll();
                    break;
                case 3:
                    sortProductByPriceASC();
                    break;
                case 4:
                    updateProductByID(scanner);
                    break;
                case 5:
                    deleteProductByID(scanner);
                    break;
                case 6:
                    findProductByID(scanner);
                    break;
                case 7:
                    findProductByPrice(scanner);
                    break;
                case 8:
                    break;
            }
        } while (isExit);

    }

    public static void createProduct(Scanner scanner) {
        Product product = new Product();
        product.inputProductName(scanner);
        products[currentProduct] = product;
        currentProduct++;
    }

    public static void findAll() {
        for (Product product : products) {
            product.displayData();
        }
    }

    public static void sortProductByPriceASC() {
        for (int i = 0; i < currentProduct; i++) {
            for (int j = i + 1; j < currentProduct; j++) {
                if (products[j].getPrice() > products[i].getPrice()) {
                    Product temp = products[j];
                    products[j] = products[i];
                    products[i] = temp;
                }
            }
        }
    }

    public static void updateProductByID(Scanner scanner) {
        System.out.print("Nhập vào mã sản phẩm cần cập nhật: ");
        String productId = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < currentProduct; i++) {
            if (products[i].getProductId().equals(productId)) {
                System.out.print("Nhập vào tên mới sản phẩm: ");
                products[i].setProductName(scanner.nextLine());

                System.out.print("Nhập vào giá mới sản phẩm: ");
                products[i].setPrice(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập vào mô tả mới của sản phẩm: ");
                products[i].setDescription(scanner.nextLine());

                System.out.print("Nhập vào mã danh mục mới của sản phẩm: ");
                products[i].setCategoryId(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập vào trạng thái mới của sản phẩm (0 | 1 | 2): ");
                products[i].setStatus(Integer.parseInt(scanner.nextLine()));

                System.out.println("Cập nhật sản phẩm thành công.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sản phẩm với ID: " + productId);
        }
    }


    public static void deleteProductByID(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần xoá: ");
        String productId = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentProduct; i++) {
            if (products[i].getProductId().equals(productId)) {
                for (int j = i ; j < currentProduct - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[currentProduct-1] = null;
                currentProduct--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy sản phẩm có id " + productId);
        }
    }

    public static void findProductByID(Scanner scanner) {
        System.out.println("Nhập vào id sản phẩm muốn sửa: ");
        String productId = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentProduct; i++) {
            if (products[i].getProductId().equals(productId)) {
                products[i].displayData();
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy sản phẩm có id" + productId);
        }
    }

    public static void findProductByPrice(Scanner scanner) {
        System.out.println("Nhập vào giá bắt đầu");
        float priceStart = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào giá kết thúc");
        float priceEnd = Float.parseFloat(scanner.nextLine());
        System.out.println("Sản phẩm có giá trong khoảng " + priceStart + " đến khoảng " + priceEnd + " là: ");
        for (int i = 0; i < currentProduct; i++) {
            if (products[i].getPrice() >= priceStart && products[i].getPrice() <= priceEnd) {
                products[i].displayData();
            }
        }
    }


}
