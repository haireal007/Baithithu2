package sort;

import Model.Product;

import java.util.Comparator;

public class SortByPricePTang implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPriceP() < o2.getPriceP()) {
            return 1;
        }
        return -1;
    }
}
