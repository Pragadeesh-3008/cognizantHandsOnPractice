package EcommerceSearch;

import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {

        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = products[mid].getProductName().compareToIgnoreCase(name);

            if (result == 0)
                return products[mid];

            if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Phone", "Electronics"),
                new Product(3, "Shoes", "Fashion"),
                new Product(4, "Watch", "Accessories")
        };

        Product found = linearSearch(products, "Phone");

        if (found != null)
            System.out.println("Linear Search: " + found);

        Arrays.sort(products,
                Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        found = binarySearch(products, "Watch");

        if (found != null)
            System.out.println("Binary Search: " + found);
    }
}