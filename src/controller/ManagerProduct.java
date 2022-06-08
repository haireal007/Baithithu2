package controller;

import Model.Product;
import io.ReaderAndWriteProduct;
import sort.SortByPricePGiam;
import sort.SortByPricePTang;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ValidateProduct validateProducts = new ValidateProduct();
    ReaderAndWriteProduct readerAndWriteProduct=new ReaderAndWriteProduct();

    public void menu() {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("1. Xem danh sách Sản Phẩm ");
        System.out.println("2. Thêm mới Sản Phẩm");
        System.out.println("3. Sửa Sản Phẩm");
        System.out.println("4.Xoá Sản Phẩm");
        System.out.println("5. Sắp xếp Sản Phẩm");
        System.out.println("6.Tìm Sản Phẩm đắt nhất");
        System.out.println("7.Đọc file");
        System.out.println("8.Ghi file");
        System.out.println("9. THOÁT");
        System.out.println("ChỌN CHỨC Năng");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("số sản phẩm  " + products.size());
                System.out.println("show ra 5 sản phẩm đầu, nhấn enter để hiện tiếp");
                show();
                break;
            case 2:
                addProduct(creatProduct());
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sortBypriceP();
                break;
            case 6:
                findMaxProduct();
                break;
            case 7:
                products =readerAndWriteProduct.reader();
                System.out.println("Đọc thành công");
                break;
            case 8:
                readerAndWriteProduct.Write(products);
                System.out.println("Ghi thành công");
                break;
            case 9:
                System.exit(0);
                break;

        }
    }

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            if ((i + 1) % 5 == 0) {
                System.out.println(products.get(i));
                scanner.nextLine();
            } else {
                System.out.println(products.get(i));
            }
        }
    }

    public Product creatProduct() {
        int id = validateProducts.validateID(products);
        String name = validateProducts.validateString("name:");
        int amountP = validateProducts.validateAmountP();
        double priceP = validateProducts.validatePriceP();
        String describeP = validateProducts.validateString("describeP :");
        return new Product(id, name, amountP, priceP, describeP);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct() {
        System.out.println("Nhập id cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProducts.getIndexId(id, products);
        if (index != -1) {
            products.set(index, creatProduct());
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProducts.getIndexId(id, products);
        if (index != -1) {
            products.remove(index);
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void sortBypriceP() {
        System.out.println("Chọn cách sắp xếp");
        System.out.println("1.sắp xếp giảm dần");
        System.out.println("2.sắp xếp tăng dần");
        int choice2 = Integer.parseInt(scanner.nextLine());

        switch (choice2) {
            case 1:
                products.sort(new SortByPricePTang());
                System.out.println("sắp xếp thành công");
            case 2:
                products.sort(new SortByPricePGiam());
                System.out.println("sắp xếp thành công");
        }
    }

    public void findMaxProduct() {
        products.sort(new SortByPricePTang());
        for (Product p : products) {
            if (p.getPriceP() == products.get(0).getPriceP()) {
                System.out.println("sản phẩm có giá lớn nhất");
                System.out.println(p);
            }
        }
    }
}
