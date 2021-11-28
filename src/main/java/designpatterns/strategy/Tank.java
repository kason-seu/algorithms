package designpatterns.strategy;

public class Tank {


    private double x;
    private double y;
    private int weight;

    public void fire(FireStrategy fireStrategy) {

        Tank fire = fireStrategy.fire(this);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
