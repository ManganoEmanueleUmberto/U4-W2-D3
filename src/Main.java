import Entities.Customer;
import Entities.Order;
import Entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, category, status;
        LocalDate orderDate, deliveryDate;
        double price;
        int choice, tier;

        List<Product> productsList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        while (true) {
            System.out.println("1. Add product to the cart\n2. Create Order \n3. Show order\n4. Show all products from the category books \n0. Exit");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;

            switch (choice) {

                case 1:
                    System.out.println("Enter the name of the product: ");
                    name = sc.nextLine();
                    System.out.println("Enter the category of the product: ");
                    category = sc.nextLine();
                    System.out.println("Enter the price of the product: ");
                    price = Double.parseDouble(sc.nextLine());

                    productsList.add(new Product(name, category, price));
                    break;

                case 2:
                    if (productsList.isEmpty()) {
                        System.out.println("Add at least one product to the cart!");
                        break;
                    }
                    System.out.println("Enter the status of the order: ");
                    status = sc.nextLine();
                    System.out.println("Enter your name: ");
                    name = sc.nextLine();
                    System.out.println("Enter your tier: ");
                    tier = Integer.parseInt(sc.nextLine());


                    orderList.add(new Order(status, productsList, new Customer(name, tier)));
                    break;

                case 3:
                    System.out.println(orderList);
                    break;

                case 4:
                    List<Product> booksList = productsList.stream().filter(product -> product.getCategory().equals("books") && product.getPrice() > 100).collect(Collectors.toList());
                    if (booksList.isEmpty()) {
                        System.out.println("Category books not found or the price is less than 100");
                        break;
                    } else {
                        System.out.println(booksList);
                        break;
                    }


            }


        }
    }
}
