package com.pu.图;

public class 图的遍历 {
    public static void main(String[] args) {
        Integer[][] mat = {
                {1,1,2},
                {1,1,3},
                {1,2,4},
                {1,4,6},
                {1,4,3},
                {1,3,5}
        };

        Graph graph = GraphGenerator.createGraph(mat);
        BFS.bfs(graph.nodes.get(1));
        DFS.dfs(graph.nodes.get(1));
    }
}
