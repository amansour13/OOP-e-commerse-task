import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();
        Customer customer = new Customer(100000);

        Product cheese = new Product("cheese", 200.0, 10);
        cheese.setExpirable(new Expirable(LocalDate.of(2025, 7, 10)));
        cheese.setShippable(new Shippable(400));

        Product biscuits = new Product("biscuits", 100.0, 10);
        biscuits.setExpirable(new Expirable(LocalDate.of(2025, 12, 5)));
        biscuits.setShippable(new Shippable(700));

        Product tv = new Product("tv", 10000.0, 10);
        tv.setShippable(new Shippable(5000));

        Product scratchCard = new Product("Mobile Scratch Card", 50.0, 10);

        cart.add(cheese, 2);
        cart.add(biscuits, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);

        Utils.checkout(customer, cart);
    }
}