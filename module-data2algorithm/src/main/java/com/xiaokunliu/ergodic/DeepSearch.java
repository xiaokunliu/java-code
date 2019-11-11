package com.xiaokunliu.ergodic;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by keithl on 2017/10/10.
 */

public class DeepSearch {

    // 深度优先算法  -- 使用栈
    private static LinkedList<DNode> stack = new LinkedList<>();

    static {
        DNode d = new DNode("D");
        DNode e = new DNode("E");
        DNode f = new DNode("F");
        DNode g = new DNode("G");

        DNode b = new DNode(d,e,"B");
        DNode c = new DNode(f,g,"C");

        DNode root = new DNode(b,c,"A");
        stack.push(root);
    }

    public static void main(String[] args) {
        //A-->B-->D-->E-->C-->F-->G-->
        dfs();
    }

    public static void dfs(){
        //   A
        //B      C
        //DE     FG
        DNode node = getDNode();
        if (node == null) return;

        System.out.print(node.getValue()+"-->");
        if (node.getRight() != null){
            stack.push(node.getRight());
        }
        if (node.getLeft() != null){
            stack.push(node.getLeft());
        }
        dfs();
    }

    private static DNode getDNode(){
        DNode node = null;
        try {
            node = stack.pop();
        } catch (NoSuchElementException e) {}
        return node;
    }
}


