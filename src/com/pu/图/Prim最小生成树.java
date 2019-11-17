package com.pu.图;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prim最小生成树 {
    public static void main(String[] args){
        Integer [][] mat = {
                {4,0,1},
                {3,0,2},
                {1,0,3},
                {3,0,5},
                {2,1,2},
                {5,1,3},
                {3,2,3},
                {1,2,4},
                {7,2,5},
                {1,3,4},
                {4,1,0},
                {3,2,0},
                {1,3,0},
                {3,5,0},
                {2,2,1},
                {5,3,1},
                {3,3,2},
                {1,4,2},
                {7,5,2},
                {1,4,3},
        };
        Graph graph = GraphGenerator.createGraph(mat);
        System.out.println(graph.nodes.size() + "个点");
        prim(graph);
    }

    private static void prim(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight == 0 ?
                            o1.from.value - o2.from.value == 0 ?
                                o1.to.value - o2.to.value
                                    : o1.from.value - o2.from.value
                        : o1.weight - o2.weight;
            }
        });
        int sum = 0;
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        for(Node node : graph.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                for(Edge edge : node.edges){
                    pq.add(edge);
                }
                while(!pq.isEmpty()){
                    Edge edge = pq.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        System.out.println(edge.from.value + "-->" + edge.to.value + "===" + edge.weight);
                        sum += edge.weight;
                        set.add(toNode);
                        result.add(edge);
                        for(Edge e : toNode.edges){
                            pq.add(e);
                        }
                    }
                }
            }
        }
        System.out.println("总权重" + sum);
    }
}
