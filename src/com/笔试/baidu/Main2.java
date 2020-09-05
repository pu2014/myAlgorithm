package com.笔试.baidu;
import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/3 20:27
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            TreeSet<Integer> set = new TreeSet<Integer>((o1,o2)->{
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);
                if(str1.length() == str2.length()){
                    return o1 - o2;
                }else{
                    for(int i = 0; i < Math.min(str1.length(), str2.length()); i++){
                        if(str1.charAt(i) != str2.charAt(i)){
                            return str1.charAt(i) - str2.charAt(i);
                        }
                    }
                    return str1.length() - str2.length();
                }
            });
            StringBuilder sb = new StringBuilder();
            int res = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n + 1];
            for(int i = 0; i < m; i++){
                int k = sc.nextInt();
                for(int j = 0; j < k; j++){
                    int ll = sc.nextInt();
                    int rr = sc.nextInt();
                    for(int p = ll; p <= rr; p++){
                        nums[p]++;
                        if(nums[p] == m){
                            res++;
                            set.add(p);
                        }
                    }
                }
            }
            System.out.println(res);
            for(Integer i : set){
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
