package domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Here, we are creating the array list with the name "catalog".
 */

public class Catalog {
    private ArrayList<Product> catalog = new ArrayList<>();

    /**
     *Here, we are creating the add function with the product parameter.
     */

    public void addProduct(Product product) {

        catalog.add(product);
    }

    /**
     *Here, we are creating the display function from the catalog array list.
     * Before its checks, is it empty? And in case it is not, it will show the message "Name:,""Price:", "ID:."
     */

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("Loading...");
            for (Product product : catalog) {
                System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", ID: " + product.getId());
            }
        }
    }

    /**
     *Here, we are creating the modify function with the id, newName and newPrice parameter.
     */

    public void modifyProduct(String id, String newName, String newPrice ) {
        for (Product product : catalog) {
            if (product.getName().equalsIgnoreCase(id)) {
                if (newName != null && !newName.isEmpty()) product.setName(newName);
                if (newPrice != null && !newPrice.isEmpty()) product.setPrice(newPrice);

                System.out.println("Product modified successfully.");
                dumpProducts();
                loadProducts();
                return;
            }
        }
        System.out.println("Product not found: " + id);
    }

    /**
     *Here, we are creating the delete function with the id parameter.
     */

    public void deleteProduct(String id) {
        Product target = new Product("", "",id );
        boolean removed = catalog.remove(target);

        if (removed) {
            System.out.println("Product removed successfully.");
            dumpProducts();
            loadProducts();
        } else {
            System.out.println("Product not found: " + id );
        }
    }

    /**
     *Here, we load products from a CSV file ("ProductFile.csv") into the catalog.
     *Each line separated by commas (name, price, and ID).
     */

    public void loadProducts() {
        try {
            Scanner sc = new Scanner(new File("ProductFile.csv"));
            sc.useDelimiter(",\n");
            while (sc.hasNext()) {
                String name = sc.next();
                String price = sc.next();
                String id = sc.next();
                Product product = new Product(name, price, id);
                catalog.add(product);
            }
            sc.close();
            System.out.println("Products loaded.");
        } catch (IOException a) {
            System.out.println("Error.");
        }
    }

    /**
     *Saves the current catalog to a CSV file ("ProductFile.csv").
     */

    public void dumpProducts() {
        try {
            FileWriter fw = new FileWriter("ProductFile.csv");
            for (Product product : catalog) {
                fw.write(product.getName() + "," + product.getPrice() + "," + product.getId());
            }
            fw.close();
            System.out.println("OK!");
        } catch (IOException a) {
            System.out.println("Error");
        }
    }

}

