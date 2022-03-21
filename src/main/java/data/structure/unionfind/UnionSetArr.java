package data.structure.unionfind;


import com.google.common.base.Preconditions;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Stack;

public class UnionSetArr<T> {


    private T[] arr;
    private int[] index;
    private int[] elementChildSize;


    public UnionSetArr(List<T> arrList) {

        Preconditions.checkArgument(arrList != null || arrList.size() > 0, "input list be not empty");
        arr = (T[])Array.newInstance(arrList.get(0).getClass(), arrList.size());
        index = new int[arrList.size()];
        elementChildSize= new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            index[i] = i;
            arr[i] = arrList.get(i);
            elementChildSize[i] = 1;
        }
    }


    public boolean isSameSet(int t1Index, int t2Index) {

        Preconditions.checkArgument(t1Index >= 0 && t1Index < index.length && t2Index >= 0 && t2Index < index.length, "t1 or t2 index not valid");
        return findFather(t1Index) == findFather(t2Index);

    }

    private int findFather(int nodeIndex) {
        Stack<Integer> indexInTheList = new Stack<>();
        int tempIndex = nodeIndex;
        while (index[tempIndex] != tempIndex) {

            indexInTheList.push(tempIndex);
            tempIndex = index[tempIndex];
        }
        while (!indexInTheList.isEmpty()) {
            Integer needUpdateFather = indexInTheList.pop();
            index[needUpdateFather] = tempIndex;
        }

        return tempIndex;
    }

    public void unionElement(int index1, int index2) {

        int fatherIndex1 = findFather(index1);
        int fatherIndex2 = findFather(index2);
        if (fatherIndex1 == fatherIndex2) {
            return;
        }
        int bigIndex = elementChildSize[fatherIndex1] > elementChildSize[fatherIndex2] ? fatherIndex1 : fatherIndex2;

        int smallIndex = bigIndex == fatherIndex1 ? fatherIndex2 : fatherIndex1;

        index[smallIndex] = bigIndex;
        elementChildSize[bigIndex] = elementChildSize[bigIndex] + elementChildSize[smallIndex];
        elementChildSize[smallIndex] = 0;
    }

    public int getClusterSize() {
        int result = 0;
        for (int i = 0; i < elementChildSize.length; i++) {
            if (elementChildSize[i] > 0) {
                result++;
            }
        }
        return result;
    }


}
