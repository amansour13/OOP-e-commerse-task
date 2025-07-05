public class Shippable {
    private double weight;

    public Shippable(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive.");
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
