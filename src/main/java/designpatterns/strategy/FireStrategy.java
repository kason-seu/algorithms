package designpatterns.strategy;

@FunctionalInterface
public interface FireStrategy {

    public Tank fire(Tank tank);
}
