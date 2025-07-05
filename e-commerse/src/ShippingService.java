import java.util.ArrayList;
import java.util.List;

interface  IShippingService{
    public double getWeight();
    public String getName();
    public void setName(String name);
}
public class ShippingService implements  IShippingService{
    private List<Pair<Product, Integer>> products;
    private String name;

    public ShippingService(String name){
        this.name = name;
        products = new ArrayList<>();
    }

    public void add(Product product, Integer quantity){
        products.add(new Pair<>(product, quantity));
    }

    @Override
    public double getWeight() {
        double weight = 0;
        for (Pair<Product, Integer> item : products) {
            weight += item.key.getShippable().getWeight() * item.value;
        }
        return weight;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
