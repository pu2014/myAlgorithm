package com.分类题型.集合;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集：1)检查两个元素是否属于一个集合  isSameSet（A，B）
 *        2)合并两个元素所在的集合 union（Set1，set2）
 */
public class UnionFind {
    public static class Node{

    }
    public static class UnionFindSet{
        public HashMap<Node,Node> fatherMap; //key:child  value:father
        public HashMap<Node,Integer> sizeMap;//key : node value : all nodes in the set

        public UnionFindSet(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for(Node node:nodes){
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            while(father != node){
               father =  findHead(father);
            }
            fatherMap.put(node,father); //Path compression
            return father;
        }

        public boolean isSameSet(Node a,Node b){
            return findHead(a) == findHead(b);
        }

        public void union(Node a,Node b){
            if(a == null || b == null){
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize < bSetSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSetSize + bSetSize);
                }else{
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSetSize + bSetSize);
                }
            }
        }

    }
}
