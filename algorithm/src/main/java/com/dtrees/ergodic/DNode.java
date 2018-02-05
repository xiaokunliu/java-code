package com.dtrees.ergodic;

/**
 * Created by keithl on 2017/11/14.
 */
public final class DNode{

    private DNode left;

    private DNode right;

    private String value;

    public DNode getLeft() {
        return left;
    }

    public DNode getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    public DNode(DNode left, DNode right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public DNode(String value) {
        this.value = value;
    }
}
