package com.xiaokunliu.study.datastruct.ch07;

public class HanoiTower {
	

	public static void doTower(int topN,char from,char inter,char to) {
		if(topN == 1) {
			System.out.println("from:"+ from + "to:" + to );
		} else {
			doTower(topN - 1, from, to, inter);
			System.out.println("topN:" + topN +",from:" + from + "to:" + to);
			doTower(topN - 1, inter, from, to);
		}
	}
}
