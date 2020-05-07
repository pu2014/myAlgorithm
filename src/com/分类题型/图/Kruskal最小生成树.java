package com.分类题型.图;

import java.util.*;

/*
    必须无向图。
 */
public class Kruskal最小生成树 {
    //kruskal  （按照边考察）
    public static void kruskal(Graph graph){
        //初始化“回环判断”数组
        int[] fromTo = new int[graph.edges.size()];
        int sum = 0;
        //从权重最小的边挑选
        //利用TreeSet实现hashSet的排序
        TreeSet<Edge> ts = new TreeSet<>(new MyComparator());
        ts.addAll(graph.edges);
        //List 有get(index)  Set没有，转换为List
        List<Edge> list = new ArrayList<>(ts);
        for(Edge e : list){
            System.out.print(e.weight + "");
        }
        System.out.println();
        System.out.println(graph.nodes.size());
        int flag = 0;
        for(int i = 0; i < graph.edges.size(); i++){
            int n = find(fromTo,list.get(i).from.value);
            int m = find(fromTo,list.get(i).to.value);
            if(n != m){
                fromTo[n] = m;
                System.out.println(list.get(i).from.value + "-->" + list.get(i).to.value + " == " + list.get(i).weight);
                sum += list.get(i).weight;
                flag++;
                if(flag >= graph.nodes.size() - 1) {
                    System.out.println("已经把每个点覆盖，直接退出！");
                    break;
                }

            }else{
                System.out.println(list.get(i).from.value + "-->" + list.get(i).to.value + " == " + list.get(i).weight + " 出现回环");
            }
        }
        System.out.println("生成树总距离为：" + sum);
    }

    private static int find(int[] fromTo, int from) {
        while(fromTo[from] > 0){
            from = fromTo[from];
        }
        return from;
    }
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
        kruskal(graph);
    }

    public static class MyComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            if(o1.weight - o2.weight != 0) {
                return o1.weight - o2.weight;
            }else{
                if(o1.from.value - o2.from.value != 0){
                    return o1.from.value - o2.from.value;
                }else{
                    return o1.to.value - o2.to.value;
                }
            }
        }
    }
}
