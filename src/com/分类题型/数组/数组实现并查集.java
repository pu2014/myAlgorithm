package com.分类题型.数组;

public class 数组实现并查集 {
    public class UnionFind{
        int [] pre;

        public UnionFind() {
            pre = new int[1000];
        }

        public int find(int data){
            int cur = data;
            while(pre[cur] != cur){
                cur = pre[cur];
            }
            int i = data,j;
            while(i != cur){
                j = pre[i];
                pre[i] = cur;
                i = j;
            }
            return cur;
        }

        public void join(int x, int y){
            int xs = find(x);
            int ys = find(y);
            if(xs != ys){
                pre[xs] = pre[ys];
            }
        }
    }
}
