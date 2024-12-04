package presentation;
import domain.*;
import java.util.Scanner;

/**
 *Here, The Menu class provides a user interface for interacting with the catalog system.
 * It is the main class where all function meet.
 */

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalog catalog = new Catalog();

        while (true) {
            System.out.println("!Welcome to the Catalog! (to navigate the system, use numbers 1-5)");
            System.out.println("1 = Add a new product to the catalog");
            System.out.println("2 = Display products");
            System.out.println("3 = Modify product");
            System.out.println("4 = Delete product");
            System.out.println("5 = Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Please enter the name of the new product: ");
                    String name = sc.nextLine();
                    System.out.print("Please enter the price of the new product: ");
                    String price = sc.nextLine();
                    System.out.print("Please enter the ID of the new product(format: 123): ");
                    String colour = sc.nextLine();
                    catalog.addProduct(new Product(name, price, colour));
                    System.out.println("Product added.");
                    catalog.dumpProducts();
                    catalog.loadProducts();

                    break;

                case 2:
                    System.out.println("Displaying products...");
                    catalog.displayCatalog();
                    break;

                case 3:
                    System.out.println("Modifying...");
                    System.out.println("Please enter the ID of the product you want to modify:");
                    String Id = sc.nextLine();

                    System.out.print("Enter the new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter the new price: ");
                    String newPrice = sc.nextLine();

                    catalog.modifyProduct(Id, newName, newPrice);
                    break;

                case 4:
                    System.out.println("Deleting product...");
                    System.out.print("Please enter the ID of the product you want to delete: ");
                    String target = sc.nextLine();
                    catalog.deleteProduct(target);
                    break;


                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Please enter a number from 1 to 5.");
                    break;
            }
        }
    }
}
