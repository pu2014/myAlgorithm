package com.笔试.bigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/10 19:37
 * [ab,ab];
 */
public class Main4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> data = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        data.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("D");
        data.add(list2);
        System.out.println(data);
        System.out.println(solution.mirror(data));
    }
    static class Solution{
        List<List<String>> mirror(List<List<String>> data){
            List<List<String>> reverse = new ArrayList<>();
            for(int i = 0; i < data.size(); i++){
                List<String> cur = new ArrayList<>();
                for(int k = data.get(i).size() - 1; k >= 0; k--){
                    cur.add(data.get(i).get(k));
                }
                reverse.add(cur);
            }
            List<List<String>> res = new ArrayList<>();
            for(int i = 0; i < data.size(); i++){
                List<String> cur = new ArrayList<>();
                for(String str : data.get(i)){
                    cur.add(str);
                }
                for(String str : reverse.get(i)){
                    cur.add(str);
                }
                res.add(cur);
            }
            for(int i = data.size() - 1; i >= 0; i--) {
                List<String> cur = new ArrayList<>();
                for(String str : data.get(i)){
                    cur.add(str);
                }
                for(String str : reverse.get(i)){
                    cur.add(str);
                }
                res.add(cur);
            }
            return res;
        }
    }
}
