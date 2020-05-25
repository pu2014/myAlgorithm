package com.分类题型.图;

public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weigth, Node from, Node to) {
        this.weight = weigth;
        this.from = from;
        this.to = to;
    }
}
