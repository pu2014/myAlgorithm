package com.剑指Offer;

import com.tools.ListNode;

import java.util.Scanner;

/**
 * @DESC 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,
 * 自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,
 * 让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可
 * 以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这
 * 份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 * @CREATE BY @Author pbj on @Date 2020/5/19 20:36
 */
public class _42孩子们的游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LastRemainingSolution proc = new LastRemainingSolution();
        System.out.println(proc.fun(n,m));
    }
}
class LastRemainingSolution {
    public int fun(int n, int m) {
        if(n < 1 || m < 0){
            return -1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 1; i < n; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        int count = 0;
        while(n != 1){
            count = (m - 2)%n;
            while(count-- > 0){
                head = head.next;
            }
            head.next = head.next.next;
            n--;
            head= head.next;
        }
        return head.val;

    }
}