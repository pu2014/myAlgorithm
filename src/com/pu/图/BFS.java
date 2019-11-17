package com.pu.图;

import com.tools.Queue;

import java.util.HashSet;

public  class BFS {
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new Queue<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
    }
}
