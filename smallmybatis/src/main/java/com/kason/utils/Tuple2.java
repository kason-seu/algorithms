package com.kason.utils;

public class Tuple2<T, R> {
    private T left;
    private R right;

    public Tuple2(T left, R right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }
}
