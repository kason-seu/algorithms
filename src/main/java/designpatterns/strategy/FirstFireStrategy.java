package designpatterns.strategy;

public class FirstFireStrategy implements FireStrategy {

    @Override
    public Tank fire(Tank tank) {

        tank.setX(tank.getX() + 1);
        tank.setY(tank.getY() + 10);
        tank.setWeight(10);
        return tank;
    }
}
