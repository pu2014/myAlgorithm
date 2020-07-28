package com.笔试.bytedance.面试;

import java.util.Random;

/**
 * @DESC  让你设计一个微信发红包的api，你会怎么设计，不能有人领到的红包里面没钱，红包数值精确到分。
 * Math.round(redPackage.remainMoney * 100 ) / 100;  为了精确到分 Math.floor(x+0.5)
 * @CREATE BY @Author pbj on @Date 2020/7/28 9:45
 */
public class _3微信抢红包设计 {
    public static void main(String[] args) {

    }

    public static double getRandomMoney(RedPackage redPackage){
        if(redPackage.remainSize == 1){
            return (double) Math.round(redPackage.remainMoney * 100 ) / 100;
        }
        Random r = new Random();
        double min = 0.01;
        double max = redPackage.remainMoney / redPackage.remainSize * 2;
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        redPackage.remainSize--;
        redPackage.remainMoney -= money;
        return money;

    }
}
class RedPackage{
    int remainSize;
    double remainMoney;

    public RedPackage(int remainSize, double remainMoney) {
        this.remainSize = remainSize;
        this.remainMoney = remainMoney;
    }
}
