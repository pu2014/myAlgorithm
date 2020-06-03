package com.tools;

import java.util.Scanner;

/**
 * Description: 工具类，返回scanner 输入的字符串或者数字
 * Created By @Author my on @Date 2020/5/28 15:36
 */
public class MyInput {
    static Scanner sc = new Scanner(System.in);
    public static int[] inputArray(){
        int N = sc.nextInt();
        int[] res = new int[N];
        for(int i = 0; i < N; i++){
            res[i] = sc.nextInt();
        }
        return res;
    }

    public static int inputInt(){
        return sc.nextInt();
    }

    public static String inputStr(){
        return sc.nextLine();
    }
 }
