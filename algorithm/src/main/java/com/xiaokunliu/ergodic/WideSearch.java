package com.xiaokunliu.ergodic;

import java.util.LinkedList;

/**
 * Created by keithl on 2017/10/10.
 */

public class WideSearch {

    // 广度优先算法   -- 使用队列
    private static LinkedList<DNode> queue = new LinkedList<>();

    static {
        DNode d = new DNode("D");
        DNode e = new DNode("E");
        DNode f = new DNode("F");
        DNode g = new DNode("G");

        DNode b = new DNode(d,e,"B");
        DNode c = new DNode(f,g,"C");

        DNode root = new DNode(b,c,"A");
        queue.offer(root);
    }

    public static void main(String[] args) {
        // A-->B-->C-->D-->E-->F-->G
        //      A
        //  B       C
        //D   E    F   G
        wfs();
    }

    public static void wfs() {
        // 从队列中获取元素
        DNode dNode = queue.poll();
        if (dNode == null) return;

        System.out.print(dNode.getValue() + "-->");

        if (dNode.getLeft() != null){
            queue.offer(dNode.getLeft());
        }

        if (dNode.getRight() != null){
            queue.offer(dNode.getRight());
        }
        wfs();
    }
}


