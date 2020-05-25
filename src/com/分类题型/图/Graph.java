package com.分类题型.图;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
