package Entities;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;


    public Product(String name, String category, double price) {
        Random rnd = new Random();

        this.id = rnd.nextInt(10000000, 90000000);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static void createProduct(List<Product> list) {
        Scanner sc = new Scanner(System.in);
        String name, category;
        double price;
        System.out.println("Enter the name of the product: ");
        name = sc.nextLine();
        System.out.println("Enter the category of the product: ");
        category = sc.nextLine();
        System.out.println("Enter the price of the product: ");
        price = Double.parseDouble(sc.nextLine());

        list.add(new Product(name, category, price));


    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
