package data.structure.segmenttree;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import jdk.incubator.foreign.CLinker;

public class SegmentTree <E>{


    private E[] tree;
    private E[] data;


    public SegmentTree(E[] value) {
        this.data = (E[])new Object[value.length];

        for (int i = 0; i < value.length; i++) {
            data[i] = value[i];
        }

        this.tree = (E[])new Object[4 * value.length];

    }


    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        Preconditions.checkArgument(index >= 0 && index < data.length, "index not valid");
        return data[index];
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }
}
