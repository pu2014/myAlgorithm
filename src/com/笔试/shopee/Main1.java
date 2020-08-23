package com.笔试.shopee;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/19 15:29
 */
public class Main1 {
    static StringBuilder sb = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        process(str);
}

    private static void process(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('"');
        for (char ch : str.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                if (sb.length() <= 1) {
                    sb.append(ch);
                } else {
                    sb.append("\\n").append(ch);
                }
            }
        }
        sb.append('"');
        System.out.println(sb.toString());
    }
}
