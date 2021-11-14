package data.structure.segmenttree;

import com.google.common.base.Preconditions;

public class SegmentTree <E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] value, Merger<E> merger) {
        this.data = (E[])new Object[value.length];

        for (int i = 0; i < value.length; i++) {
            data[i] = value[i];
        }

        this.tree = (E[])new Object[4 * value.length];
        this.merger = merger;

        buildSegmentTree(0,0,this.data.length - 1);

    }


    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        Preconditions.checkArgument(index >= 0 && index < data.length, "index not valid");
        return data[index];
    }


    /**
     *
     * @param index: 该段的索引
     * @param left： 线段树的左段，对应data 里面的索引
     * @param right： 线段树的右段，对应data 里面的索引
     * @return: 该段存储的值
     */
    public E buildSegmentTree(int index, int left, int right) {
        if  (left == right) {
            tree[index] = data[left];
            return tree[index];
        }
        int mid = left + (right-left) / 2;

        // 分裂成2个段
        // 左段
        E leftValue = buildSegmentTree(2 * index + 1, left, mid);
        // 右段
        E rightValue =buildSegmentTree(2 * index + 2, mid + 1, right);

        // 聚合左段和右段的值
        tree[index] = this.merger.merge(leftValue, rightValue);

        return tree[index];
    }



    public E queryByRange(int index, int treeL, int treeR, int left, int right) {

        if (left == treeL && right == treeR) {
            return tree[index];
        }
        int mid = treeL + (treeR - treeL) / 2;
        if (right <= mid) {
            return queryByRange(2 * index + 1, treeL, mid, left, right);
        }
        if (left >= mid + 1) {
            return queryByRange(2 * index + 2, mid + 1, treeR, left, right);
        }

        // 即在左边又在右边
        return merger.merge(queryByRange(2 * index + 1, treeL, mid, left, mid) , queryByRange(2 * index + 2,mid + 1, treeR, mid + 1, right));
    }



    public void update(int index, E e) {

        updateDg(0, 0, data.length - 1, index , e);
    }

    private void updateDg(int treeIndex, int l, int r, int dataIndex, E e) {

        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;

        if (dataIndex > mid) {
            updateDg(2 * treeIndex + 2, mid + 1, r, dataIndex, e);
        } else {
            updateDg(2 * treeIndex + 1, l, mid, dataIndex, e);
        }
        tree[treeIndex] = merger.merge(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }


    public void display(int index) {


        if (index > tree.length - 1) {
            return;
        }

        System.out.println(tree[index]);
        display(2 * index  + 1);
        display(2 * index + 2);


    }
    public static void main(String[] args) {
        SegmentTree<Integer> segmentTree = new SegmentTree<>(new Integer[]{1,2,3,4,5}, Integer::sum);

        segmentTree.display(0);

        Integer integer = segmentTree.queryByRange(0, 0, segmentTree.getSize() - 1, 1, 3);

        System.out.println("range 1:3 sum = " + integer);

        segmentTree.update(2, 10);
        integer = segmentTree.queryByRange(0, 0, segmentTree.getSize() - 1, 1, 3);

        System.out.println("range 1:3 sum = " + integer);



    }
}
