package Entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {

    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;


    public Order(String status, List<Product> products, Customer customer) {
        Random rnd = new Random();

        this.id = rnd.nextInt(10000000, 90000000);
        this.status = status;
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now();
        this.products = products;
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "\nOrder{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
