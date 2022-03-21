package data.structure.unionfind.demos;

import data.structure.unionfind.UnionSet;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Demo1 {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(8);
        list.add(11);
        list.add(17);
        list.add(34);

        Demo1 demo1 = new Demo1();
        int i = demo1.getConnectedSize(list);

        System.out.println(i);

        int max = demo1.getConnectedMax(list);
        System.out.println("max " + max);
    }

    private int getConnectedSize(List<Integer> arr) {
        UnionSet<Integer> unionSet = new UnionSet<>(arr);

        for (int i = 0; i < arr.size() ; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int g = g(arr.get(i), arr.get(j));
                if (g > 1) {
                    unionSet.union(arr.get(i), arr.get(j));
                }
            }
        }

        return unionSet.getConnectedSize();
    }
    private int getConnectedMax(List<Integer> arr) {
        UnionSet<Integer> unionSet = new UnionSet<>(arr);

        for (int i = 0; i < arr.size() ; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int g = g(arr.get(i), arr.get(j));
                if (g > 1) {
                    unionSet.union(arr.get(i), arr.get(j));
                }
            }
        }

        Map<UnionSet<Integer>.Node<Integer>, Integer> rootSizeMap = unionSet.getRootSizeMap();

        return rootSizeMap.values().stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).get();


    }

    private int g(int m, int n) {
        if (n ==0) {
            return m;
        } else {
            return g(n, m % n);
        }
    }
}
