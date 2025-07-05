public class Product {
    private String name;
    private double price;
    private int quantity;
    private Expirable expirable;
    private Shippable shippable;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isExpirable() { return expirable != null; }
    public boolean isShippable() { return shippable != null; }
    public Expirable getExpirable() { return expirable; }
    public Shippable getShippable() { return shippable; }

    public void setExpirable(Expirable expirable) {
        this.expirable = expirable;
    }

    public void setShippable(Shippable shippable) {
        this.shippable = shippable;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
