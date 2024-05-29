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
            System.out.println("1. Add product to the cart\n2. Create Order \n3. Show order\n4. Show all products from the category books \n5. Show orders containing at least one product in the category baby\n6. Check discount 10% on products from baby category \n0. Exit");
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
                    System.out.println("Enter the date of the order: (YYYY-MM-DD)");
                    orderDate = LocalDate.parse(sc.nextLine());
                    System.out.println("Enter the delivery date of the order: (YYYY-MM-DD) ");
                    deliveryDate = LocalDate.parse(sc.nextLine());
                    System.out.println("Enter your name: ");
                    name = sc.nextLine();
                    System.out.println("Enter your tier: ");
                    tier = Integer.parseInt(sc.nextLine());


                    orderList.add(new Order(status, productsList, orderDate, deliveryDate, new Customer(name, tier)));
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
                case 5:
                    List<Order> babyList = orderList.stream()
                            .filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("baby")))
                            .toList();
                    System.out.println(babyList);

                case 6:
                    List<Product> boysList = productsList.stream().filter(product -> product.getCategory().equals("boys")).toList();
                    boysList.forEach(product -> product.setPrice(product.getPrice() - ((product.getPrice() * 10) / 100)));
                    System.out.println(boysList);
                

            }


        }
    }
}
