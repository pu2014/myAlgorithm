package com.笔试.bilibili;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/4 19:37
 */
public class Main3 {
    public static void main(String[] args) {
        String str = "aaabbaaac";
        List<Node> list = new ArrayList<>();
        char curChar = str.charAt(0);
        int curSum = 1;
        for(int i = 1; i < str.length(); i++){
            if(curChar != str.charAt(i)){
                list.add(new Node(curChar,curSum));
                curChar = str.charAt(i);
                curSum = 1;
            }else{
                curSum++;
            }
        }
        list.add(new Node(curChar, curSum));
        int res = 0;
        for(Node node : list){
            res += node.cnt;
        }
        System.out.println(res / list.size());
    }
    static class Node{
        Character ch;
        Integer cnt;
        public Node(Character ch, Integer cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
