package easterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    public Egg(String color, int strength, String shape) {
        setColor(color);
        setStrength(strength);
        setShape(shape);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return String.format("%s egg, with %d strength and %s shape.", color, strength, shape);
    }
}
