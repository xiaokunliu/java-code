package com.xiaokunliu.study.datastruct.ch20;

import com.xiaokunliu.study.datastruct.ch03.MyStack;


public class Graph {

	private Vertex[] vertexList;

	private int[][] adjMat;

	private int maxSize = 20;

	private int nVertex;

	private MyStack stack;
	
	public Graph() {
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		for(int i = 0; i < maxSize; i++) {
			for(int j = 0; j < maxSize; j++) {
				adjMat[i][j] = 0;
			}
		}
		nVertex = 0;
		stack = new MyStack();
	}
	

	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}
	

	public void addEdge(int start,int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public int getadjUnvisitedVertex(int v) {
		for(int i = 0; i < nVertex; i++) {
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		while(!stack.isEmpty()) {
			int v = getadjUnvisitedVertex((int)stack.peek());
			if(v == -1) {
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
		}

		for(int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
		
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	public void mst() {

		vertexList[0].wasVisited = true;
		stack.push(0);
		while(!stack.isEmpty()) {
			int currentVertex = (int)stack.peek();
			int v = getadjUnvisitedVertex(currentVertex);
			if(v == -1) {
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				stack.push(v);
				displayVertex(currentVertex);
				System.out.print("-");
				displayVertex(v);
				System.out.print(" ");
			}
		}
		
		for(int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
}
