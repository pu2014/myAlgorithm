package com.笔试.didi;


import java.util.*;
/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/13 19:45
 */
public class Main2 {
    public static void main(String[] args) {
        /*
2
3 3 400
1 2 200
1 3 300
2 3 500
3 3 400
1 2 500
1 3 600
2 3 700
         */
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        while(times-- > 0){
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            int maxCost = sc.nextInt();
            Graph graph = new Graph();
            for(int i = 0; i < edges; i++){
                Integer from = sc.nextInt();
                Integer to = sc.nextInt();
                Integer weight = sc.nextInt();
                if(weight > maxCost){
                    continue;
                }
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
            int res = bfs(graph.nodes.get(1));
            if(res == nodes){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
    public static int bfs(Node node){
        if(node == null){
            return 0;
        }
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            cnt++;
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return cnt;
    }
    static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;
        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }
    static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<>();
            this.edges = new ArrayList<>();
        }
    }

    static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weigth, Node from, Node to) {
            this.weight = weigth;
            this.from = from;
            this.to = to;
        }
    }
}
