import java.util.List;

public class Utils {
    public static void checkout(Customer customer, Cart cart) {
        double cartPrice = cart.getTotalPrice();
        double customerBalance = customer.getBalance();

        if (cartPrice == 0) {
            throw new IllegalArgumentException("Cart is empty");
        }

        if (cartPrice > customerBalance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        customer.setBalance(customerBalance - cartPrice);

        System.out.println("** Shipment notice **");

        List<Pair<Product, Integer>> items = cart.getItems();

        ShippingService ss = new ShippingService("shipping service 1");
        for (Pair<Product, Integer> item : items) {
            Product product = item.key;
            int quantity = item.value;

            if (product.getQuantity() < quantity){
                throw new IllegalArgumentException(("out of stock!"));
            }

            if (product.isShippable()) {
                double weight = product.getShippable().getWeight();
                System.out.printf("%dx %-12s\t\t\t%.0fg", quantity, product.getName(), weight);
                System.out.println();
                ss.add(product, quantity);
            }
        }
        System.out.printf("Total package weight  \t%.1fkg", ss.getWeight()/1000);
        System.out.println();
        System.out.println();

        System.out.println("** Checkout receipt **");
        double subtotal = 0;
        for (Pair<Product, Integer> item : items) {
            Product product = item.key;
            int quantity = item.value;

            if (product.getQuantity() < quantity){
                throw new IllegalArgumentException(("out of stock!"));
            }
            product.setQuantity(product.getQuantity() - quantity);

            System.out.printf("%dx %-12s\t\t\t%.0f%n", quantity, product.getName(), product.getPrice());

            subtotal += product.getPrice() * quantity;
        }

        System.out.println("---------------------------------");
        System.out.printf("Subtotal\t\t\t\t%.0f%n", subtotal);

        System.out.printf("Shipping\t\t\t\t%.0f%n", 30.0);

        System.out.printf("Total\t\t\t\t\t%.0f%n", subtotal + 30.0);
        cart.clear();
    }
}
