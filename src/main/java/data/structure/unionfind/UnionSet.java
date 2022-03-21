package data.structure.unionfind;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionSet<V> {

    public class Node<V> {
        private V val;
        public Node(V val) {
            this.val = val;
        }
    }


    private Map<V, Node<V>> nodeMap;
    private Map<Node<V>, Node<V>> parents;
    @Getter
    private Map<Node<V>, Integer> rootSizeMap;


    public int getConnectedSize() {
        return rootSizeMap.size();
    }

    public UnionSet(List<V> vals) {
        nodeMap = new HashMap<>();
        parents = new HashMap<>();
        rootSizeMap = new HashMap<>();
        for (V val : vals) {
            Node<V> cur = new Node<>(val);
            nodeMap.put(val, cur);
            parents.put(cur,cur);// 开始自己指向自己
            rootSizeMap.put(cur, 1);
        }
    }

    public boolean unionFind(V val1, V val2) {

        if (!nodeMap.containsKey(val1) || !nodeMap.containsKey(val2)) {
            return false;
        }

        return findFather(val1) == findFather(val2);

    }

    public void union(V val1, V val2) {

        Node<V> fatherOfVal1 = findFather(val1);
        Node<V> fatherOfVal2 = findFather(val2);
        if (fatherOfVal1 == fatherOfVal2) {
            return;
        }
        Integer fatherOfVal1Size = rootSizeMap.get(fatherOfVal1);
        Integer fatherOfVal2Size = rootSizeMap.get(fatherOfVal2);

        // 大的节点
        Node<V> bigFather = fatherOfVal1Size >= fatherOfVal2Size ? fatherOfVal1 : fatherOfVal2;
        // 小的节点
        Node<V> smallFather = bigFather == fatherOfVal1 ? fatherOfVal2 : fatherOfVal1;
        // 小的节点指向大的节点
        parents.put(smallFather, bigFather);
        // 更新大的节点作为根节点维护的子元素的数量
        rootSizeMap.put(bigFather, rootSizeMap.get(bigFather) + rootSizeMap.get(smallFather));
        // 小的节点被吞并了，可以从Map里面剔除掉了
        rootSizeMap.remove(smallFather);
    }

    private Node<V> findFather(V val) {

        Stack<Node<V>> cacheNodeInList = new Stack<>();
        Node<V> cur = nodeMap.get(val);
        cacheNodeInList.push(nodeMap.get(val));
        while (parents.get(cur) != null && cur != parents.get(cur)) {
            Node<V> temp = parents.get(cur);
            cacheNodeInList.push(temp);
            cur = temp;
        }
        // 找到了根节点, 这里做一个优化，就是将整个链表上的节点展平， 都一度指向根节点（原先可能是个链）
        while (!cacheNodeInList.isEmpty()) {
            parents.put(cacheNodeInList.pop(), cur);
        }

        return cur;

    }

}
