package com.分类题型.图;

import java.util.HashSet;

public class dijkstra最短路径 {
    public static void main(String[] args) {
        Integer[][] mat = {
                {4, 0, 1},
                {3, 0, 2},
                {1, 0, 3},
                {3, 0, 5},
                {2, 1, 2},
                {5, 1, 3},
                {3, 2, 3},
                {1, 2, 4},
                {7, 2, 5},
                {1, 3, 4},
                {4, 1, 0},
                {3, 2, 0},
                {1, 3, 0},
                {3, 5, 0},
                {2, 2, 1},
                {5, 3, 1},
                {3, 3, 2},
                {1, 4, 2},
                {7, 5, 2},
                {1, 4, 3},
        };
        Graph graph = GraphGenerator.createGraph(mat);
        minPath(graph);
    }

    private static void minPath(Graph graph) {
        int vNum = graph.nodes.size();
        HashSet<Node> nodeSet = new HashSet<>();
        nodeSet.add(graph.nodes.get(0));
        int[] dis = new int[vNum];
        dis[0] = 0;
        for(int i = 1; i < vNum; i++){
        }
        for (int i = 0; i < vNum; i++) {

        }

    }
}
