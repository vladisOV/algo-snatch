package dev.algos.snatch.data_structures.union_find;

import java.util.Arrays;

public class UnionFind {
    int[] arr;
    int[] size;

    public UnionFind(int n) {
        this.arr = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Time complexity O(logn)
     */
    boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    /**
     * Time complexity O(logn)
     */
    public void union(int a, int b) {
        int i = root(a);
        int j = root(b);
        arr[i] = j;
    }

    /**
     * Time complexity O(logn)
     */
    public void weightedUnion(int a, int b) {
        int i = root(a);
        int j = root(b);
        if (size[i] < size[j]) {
            arr[i] = arr[j];
            size[j] += size[i];
        } else {
            arr[j] = arr[i];
            size[i] += size[j];
        }
    }

    /**
     * Time complexity O(N)
     * returns deepest tree
     */
    int maxUnion() {
        int max = 0;
        int[] freq = new int[arr.length];
        for (int i = 0; i < freq.length; i++) {
            freq[arr[i]]++;
            max = Math.max(max, freq[arr[i]]);
        }
        return max;
    }

    /**
     * Time complexity O(logn)
     */
    public int root(int i) {
        while (i != arr[i]) {

            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
