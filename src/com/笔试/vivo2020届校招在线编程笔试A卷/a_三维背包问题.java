package com.笔试.vivo2020届校招在线编程笔试A卷;

import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.util.*;

/**
 * @DESC
 * 小v是公司的运维工程师，现有一个有关应用程序部署的任务如下：
 * 1、一台服务器的磁盘空间、内存是固定的，现在有N个应用程序要部署；
 * 2、每个应用程序所需要的磁盘、内存不同，每个应用程序允许访问的用户数也不同，且同一个应用程序不能在一台服务器上部署多个。
 * 对于一台服务器而言，如何组合部署应用程序能够使得单台服务器允许访问的用户数最多？
 * @CREATE BY @Author pbj on @Date 2020/6/6 22:12
 */

/**
 * Welcome to vivo !
 */

public class a_三维背包问题 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    /**
     * 输入例子1:
     * 15 10 5,1,1000#2,3,3000#5,2,15000#10,4,16000
     *
     * 输出例子1:
     * 31000
     * @param totalDisk
     * @param totalMemory
     * @param services
     * @return
     */
    private static int solution(int totalDisk, int totalMemory, List<Service> services) {

        // TODO Write your code here
        int len = services.size();
        int[][][] dp = new int[len + 1][totalDisk + 1][totalMemory + 1];
        for(int i = 1; i <= len; i++){
            for(int j = totalDisk; j >= 0; j--){
                for(int k = totalMemory; k >= 0; k--){
                    if(j >= services.get(i - 1).disk && k >= services.get(i - 1).memory){
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                dp[i - 1][j - services.get(i - 1).disk][k - services.get(i - 1).memory] + services.get(i - 1).users);
                    }else{
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[len][totalDisk][totalMemory];
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}
