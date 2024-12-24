package MainPocket.Posilka;

public class Shipment {
        private final Dimensions dimensions;
        private final double weight;
        private final String description;

    public Shipment(Dimensions dimensions, double weight, String description) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.description = description;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}
