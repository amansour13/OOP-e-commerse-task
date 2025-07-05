import java.util.ArrayList;
import java.util.List;

class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class Cart {
    private List<Pair<Product, Integer>> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0){
            throw new IllegalArgumentException("Invalid quantity.");
        }

        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("out of stock.");
        }

        if (product.getExpirable() != null && product.getExpirable().isExpired()) {
            throw new IllegalArgumentException("Product is expired.");
        }


        for (Pair<Product, Integer> item : items) {
            if (item.key.equals(product)) {
                int totalQty = item.value + quantity;
                if (totalQty > product.getQuantity()) {
                    throw new IllegalArgumentException("Not enough stock.");
                }

                items.remove(item);
                items.add(new Pair<>(product, totalQty));
                return;
            }
        }
        items.add(new Pair<>(product, quantity));
    }

    public double getTotalPrice() {
        double total = 0;
        for (Pair<Product, Integer> item : items) {
            double price = item.key.getPrice();
            int quatity = item.value;
            total += price * quatity;
        }
        return total;
    }

    public List<Pair<Product, Integer>> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
