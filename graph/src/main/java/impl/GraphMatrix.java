package impl;


import entity.Edge;
import entity.Vertex;
import interfaces.IGraph;
import org.checkerframework.checker.units.qual.K;

public class GraphMatrix implements IGraph<Integer, Void, Void> {
    @Override
    public void addVertex(Vertex<Integer, Void> v) {

    }

    @Override
    public void addEdge(Edge<Integer, Void> e) {

    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }

    @Override
    public int degree(Integer id) {
        return 0;
    }

    @Override
    public Iterable<Integer> adj(Integer id) {
        return null;
    }
}
