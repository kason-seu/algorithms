package interfaces;

import entity.Edge;
import entity.Vertex;

/**
 *
 * @param <K> 点的类型
 * @param <VV> 点的属性的类型
 * @param <EV> 边的属性的类型
 */

public interface IGraph <K, VV, EV>{
   void addVertex(Vertex<K,VV> v);
   void addEdge(Edge<K,EV> e);
   int V();
   int E();
   int degree(K id);
   Iterable<K> adj(K id);
}
