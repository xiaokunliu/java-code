package com.dtrees.study.datastruct.ch18;

public class Graph {

	private Vertex[] vertexList;

	private int[][] adjMat;

	private int maxSize;

	private int nVertex;
	
	public Graph() {
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		for(int i = 0; i < maxSize; i++) {
			for(int j = 0; j < maxSize; j++) {
				adjMat[i][j] = 0;
			}
		}
		nVertex = 0;
	}
	

	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}
	

	public void addEdge(int start,int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
}
