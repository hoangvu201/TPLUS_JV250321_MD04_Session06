package ra.entity;

import ra.presentation.ShopManagement;
import ra.validator.Validation;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String description, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public int checkCatalogId(Scanner scanner) {
        if (ShopManagement.currentCategory == 0) {
            return 1;
        }
        int idMax = ShopManagement.categories[0].getCatalogId();
        for (int i = 0; i < ShopManagement.currentCategory; i++) {
            if (ShopManagement.categories[i].getCatalogId() > idMax) {
                idMax = ShopManagement.categories[i].getCatalogId();
            }
        }
        return idMax + 1;
    }

    public String checkCatalogName(Scanner scanner) {
        System.out.println("Nhập vào tên danh mục:");
        do {
            String catalogName = scanner.nextLine();
            if (Validation.isEmpty(catalogName)) {
                System.err.println("Vui lòng nhập tên danh mục");
            } else {
                if (catalogName.length() <= 50) {
                    boolean isExit = false;
                    for (int i = 0; i < ShopManagement.currentCategory; i++) {
                        if (ShopManagement.categories[i].getCatalogName().equals(catalogName)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (!isExit) {
                        return catalogName;
                    }
                    System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                } else {
                    System.err.println("Tên danh mục có độ dài tối đa 50 ký tự, vui lòng nhập lại");
                }
            }
        } while (true);
    }

    public String checkDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả danh mục");
        do {
            String description = scanner.nextLine();
            if (!Validation.isEmpty(description)) {
                return description;
            }
            System.err.println("Vui lòng nhập mô tả danh mục");
        } while (true);
    }

    public boolean checkCatalogStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái danh mục (true|false):");
        do {
            String catalogStatus = scanner.nextLine();
            if (!Validation.isEmpty(catalogStatus)) {
                if (catalogStatus.equalsIgnoreCase("true") || catalogStatus.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(catalogStatus.toLowerCase());
                }
                System.err.println("trạng thái chỉ nhận giá trị true | false, vui lòng nhập lại");
            } else {
                System.err.println("Vui lòng nhập mô tả danh mục");
            }
        } while (true);
    }

    public void inputData(Scanner scanner) {
        this.catalogId = checkCatalogId(scanner);
        this.catalogName = checkCatalogName(scanner);
        this.description = checkDescription(scanner);
        this.catalogStatus = checkCatalogStatus(scanner);
    }

    public void displayData() {
        System.out.printf("Mã DM: %d - Tên DM: %s - Mô tả: %s - Trạng thái: %s\n",
                this.catalogId, this.catalogName, this.description, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }

    public static String getCatalogNameByID(int catalogId) {
        for (int i = 0; i < ShopManagement.currentCategory;i++){
            if (ShopManagement.categories[i].getCatalogId() == catalogId){
                return ShopManagement.categories[i].getCatalogName();
            }
        }
    }
}
