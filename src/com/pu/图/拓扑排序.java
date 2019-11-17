package com.pu.图;

import com.tools.Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 例如编译问题  解决依赖项问题
 * 必须有向图，无向图无法判断出度和入度
 *
 * 由入度的顺序排
 */

public class 拓扑排序 {
    public static List<Node> sortedTopology(Graph graph){
        HashMap<Node,Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new Queue<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.offer(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.offer(next);
                }
            }
        }
        return result;
    }
}
