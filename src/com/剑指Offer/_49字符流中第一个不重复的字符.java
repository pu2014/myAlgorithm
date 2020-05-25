package com.剑指Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/21 14:52
 */
public class _49字符流中第一个不重复的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IOChar proc = new IOChar();
        while(sc.hasNext()) {
            char[] chs= sc.nextLine().toCharArray();
            for(char c : chs) {
                proc.insert(c);
                System.out.println(proc.firstAppearingOnce());
            }
        }
    }
}
class IOChar {
    //Insert one char from stringstream
    int[] isAppear = new int[256];
    Queue<Character> deque = new LinkedList<>();
    public void insert(char ch)
    {
        int index = ch; //65  ‘a' 97
        if(isAppear[index] < 2){
            isAppear[index]++;
            deque.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
        while(!deque.isEmpty() && isAppear[deque.peek()] != 1){
            deque.poll();
        }
        return deque.isEmpty() ? '#' : deque.peek();
    }
}
