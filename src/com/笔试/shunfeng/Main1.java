package com.笔试.shunfeng;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/20 20:29
 */


/**
 * @DESC
 * 小v是公司的运维工程师，现有一个有关应用程序部署的任务如下：
 * 1、一台服务器的磁盘空间、内存是固定的，现在有N个应用程序要部署；
 * 2、每个应用程序所需要的磁盘、内存不同，每个应用程序允许访问的用户数也不同，且同一个应用程序不能在一台服务器上部署多个。
 * 对于一台服务器而言，如何组合部署应用程序能够使得单台服务器允许访问的用户数最多？
 * @CREATE BY @Author pbj on @Date 2020/6/6 22:12
 */

/**
 * 小A的购买了一批服务器，他准备将这些服务器租用出去。每一个服务器有一个固定的带宽，人们根据自己需要的带宽来租用这些服务器。一台服务器只能租给一个人。
 * 小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。有m个客户来租服务器，第 i 位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。（服务器带宽独立不可叠加，若不能成功租出则输出0） 小A可以选择拒绝一些人，现在，小A想知道自己的服务器最多能租多少钱？
 * 输入描述
 * 输入第一行包含两个数n,m
 * 接下来1行n个数，第i个数ai代表第 i 个服务器的带宽大小。
 * 接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算。
 * n,m≤1000 , 1≤ai,bi,ci≤1000
 * 输出描述
 * 输出一个数，即小A最多能租多少元的服务器出去。
 * 样例输入
 * 3 4
 * 1 2 3
 * 2 1
 * 3 2
 * 3 3
 * 1 1
 * 样例输出
 * 5
 * 提示
 * 样例解释
 * 1号服务器租给4号客户
 * 2号服务器租给1号客户
 * 3号服务器租给3号客户
 */


public class Main1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] serves = new int[n];
        for(int i = 0; i < n; i++){
            serves[i] = sc.nextInt();
        }

    }


}
