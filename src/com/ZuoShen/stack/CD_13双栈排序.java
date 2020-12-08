package com.ZuoShen.stack;
import java.io.*;
import java.util.*;

/**
 * @DESC 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * 输入描述:
 * 第一行输入一个N，表示栈中元素的个数
 * 第二行输入N个整数i表示栈顶到栈底的各个元素
 * 输出描述:
 * 输出一行表示排序后的栈中栈顶到栈底的各个元素。
 * 输入
 * 5
 * 5 8 4 3 6
 * 输出
 * 8 6 5 4 3
 * @CREATE BY @Author pbj on @Date 2020/12/8 15:11
 */
public class CD_13双栈排序 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().trim().split(" ");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack_in = new Stack<>();
        for(int i = N - 1; i >= 0; i--){
            stack_in.push(nums[i]);
        }
        sort(stack_in);
        System.out.print(stack_in.pop());
        while(!stack_in.isEmpty()){
            System.out.print(" " + stack_in.pop());
        }

    }
    //排序
    public static void sort(Stack<Integer> stack_in){
        if(stack_in.size() < 2){
            return;
        }
        Stack<Integer> stack_help = new Stack<>();
        while(!stack_in.isEmpty()){
            int cur = stack_in.pop();
            while(!stack_help.isEmpty() && stack_help.peek() < cur){
                stack_in.push(stack_help.pop());
            }
            stack_help.push(cur);
        }
        while(!stack_help.isEmpty()){
            stack_in.push(stack_help.pop());
        }
    }
}
