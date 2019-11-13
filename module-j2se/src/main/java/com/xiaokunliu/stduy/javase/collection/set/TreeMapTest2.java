package com.xiaokunliu.stduy.javase.collection.set;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest2 {

    public static void main(String[] args) {

        String str = "dwjiuweuhwwy	qddywyuwyq	qooagayytay		tyahsauhiwiue";
        char[] chs = str.toCharArray();

        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

        for (char key : chs) {
            if (key == '\t' || key == ' ')
                continue;
            if (map.get(key) == null) {
                map.put(key, 1);
                continue;
            }
            Integer value = map.get(key);
            value++;
            map.put(key, value);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + ")");
        }
    }
}
