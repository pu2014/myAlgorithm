package com.pu.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入 "b" "ba"  --> "bab"
 * 输入 "ab" "cd" "ef" --> "abcdef"
 */

public class 字符串的按字典顺序拼接 {
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 +o1);  //而不是o1 - o2 因为"b" < "ba" 但是"bab" < "bba"
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return null;
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for(int i = 0; i < strs.length; i++){
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"dad","acb","ba","b"};
        System.out.println(lowestString(strs));
    }
}
