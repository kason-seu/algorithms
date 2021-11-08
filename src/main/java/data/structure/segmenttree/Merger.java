package data.structure.segmenttree;

@FunctionalInterface
public interface Merger<E> {

    public E merge (E d1, E d2);
}


