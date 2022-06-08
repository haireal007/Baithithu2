package validate;

import Model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateProduct {
    Scanner scanner =new Scanner(System.in);

    public int validateID(ArrayList<Product>  products) {
        while (true) {
            try {
                System.out.println("Nhập id:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, products) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai id rồi");
            }
        }
    }

    public int getIndexId(int id, ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("không để trống");
                continue;
            } else {
                return str;
            }
        }
    }

    public double validatePriceP() {
        while (true) {
            try {
                System.out.println("Nhập priceP:");
                int priceP = Integer.parseInt(scanner.nextLine());
                return priceP;
            } catch (Exception e) {
                System.err.println("Nhập sai priceP rồi");
            }
        }
    }

    public int validateAmountP() {
        while (true) {
            try {
                System.out.println("Nhập AmountP");
                int AmountP = Integer.parseInt(scanner.nextLine());
                return AmountP;
            } catch (Exception e) {
                System.err.println("Nhập sai AmountPrồi");
            }
        }
    }

}
