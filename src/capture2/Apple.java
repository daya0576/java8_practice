package capture2;

public class Apple {
    String color;
    int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHeavyApple() {
        return weight > 1;
    }

    public boolean isGreenApple() {
        return color.equals("green");
    }
}
