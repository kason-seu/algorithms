package graph;

import java.util.List;

public interface IGraph<K> {

    static void graphMsg() {
        System.out.println("graph interface");
    }

    public boolean hasEdge(K v, K w);
    public Iterable<K> adj(K v);
    public int degree(K v);

    public int V();
    public int E();
    // 先序遍历
    public Iterable<K> preOrder();
    // 后续遍历
    public Iterable<K> afterOrder();

    public Iterable<K> preOrderWithLoop();
}
