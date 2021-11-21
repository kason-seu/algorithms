package data.structure.heap;

public class MinHeap<E extends Comparable<E>> {

    private E[] data;
    int size;

    public MinHeap(int size) {
        this.size = size;
    }

    private int parent(int index) {
        return (index + 1) / 2;
    }

    private int left (int index) {
        return 2 * index + 1;
    }

    private int right (int index) {
        return 2 * index + 2;
    }

    public int add(E e) {

        return 0;
    }
}
