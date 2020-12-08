package com.笔试.jingdon;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/17 19:55
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        line = line.replace(".","");
        line = line.replace(",","");
        line = line.replace("?","");
        line = line.replace("!","");
        String[] strs = line.split(" ");
        String match = "[1-3][0-9]{3}";
        String match1 = "^[1-3][0-9]{3}[a-zA-Z]";
        String match2 = "[a-zA-Z][1-3][0-9]{3}$";
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            if(str.matches(match)){
                sb.append(str).append(" ");
            }else if(str.matches(match1)){
                sb.append(str.substring(0, 4)).append(" ");
            }else if(str.matches(match2)){
                sb.append(str.substring(str.length() - 5)).append(" ");
            }
        }
        if(sb.length() != 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }
}
