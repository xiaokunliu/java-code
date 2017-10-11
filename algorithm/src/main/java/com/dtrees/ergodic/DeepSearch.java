package com.dtrees.ergodic;

import java.util.LinkedList;

/**
 * Created by keithl on 2017/10/10.
 */

public class DeepSearch {

    // 深度优先算法
    private static LinkedList<DNode> queue = new LinkedList<>();

    static {

    }

    public static void main(String[] args) {

    }

    public static void dfs(int[] arr){
        //   A
        //B      C
        //DE     FG

    }
}


class DNode{

    private DNode left;

    private DNode right;

    public DNode getLeft() {
        return left;
    }

    public void setLeft(DNode left) {
        this.left = left;
    }

    public DNode getRight() {
        return right;
    }

    public void setRight(DNode right) {
        this.right = right;
    }
}