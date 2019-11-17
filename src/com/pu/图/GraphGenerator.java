package com.pu.图;

public class GraphGenerator {
    public static Graph createGraph(Integer[][] mat){
        Graph graph = new Graph();
        for(int i = 0; i < mat.length; i++){
            Integer weight = mat[i][0];
            Integer from = mat[i][1];
            Integer to = mat[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);

        }
        return graph;
    }
}
