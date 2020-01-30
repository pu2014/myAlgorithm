package com.pu.数组;

import java.util.*;

/**
 * description：一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。请写程序找出这两个只出现一次的数
 *
 * method:xor
 *  一个数和0的异或是其本身
 *  一个数和自己的异或是0
 * @author Pubojian
 * @date 2020/1/30 15:34
 */
public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,6,3,7,5,4};
        int[] arr1 = {2,3,4,5,6,6,3,7,5,4};
        FindNumsAppearOnceV1(arr);
        FindNumsAppearOnceV2(arr1);
        FindNumsAppearOnceV3(arr);
        FindNumsAppearOnceV4(arr);

    }

    private static void FindNumsAppearOnceV4(int[] arr) {
        //the best method (xor)
        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
        }
        //xor = a ^ b
        //Judge the two different digits-->1
        int index = 1;
        while((xor & index) == 0){
            index = index << 1;
        }
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & index) == 0){
                res1 = res1 ^ arr[i];
            }else{
                res2 = res2 ^ arr[i];
            }
        }
        System.out.println("FindNumsAppearOnceV4(by xor):" + res1 + " " + res2);
    }

    private static void FindNumsAppearOnceV3(int[] arr) {
        //by map
        System.out.print("FindNumsAppearOnceV3(by map):");
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], 2);
            }else{
                map.put(arr[i], 1);
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]) == 1){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void FindNumsAppearOnceV2(int[] arr) {
        //by stack
        System.out.print("FindNumsAppearOnceV2(by stack):");
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty() || stack.peek() != arr[i]){
                stack.push(arr[i]);
            }else{
                stack.pop();
            }
        }
        Iterator it = stack.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    private static void FindNumsAppearOnceV1(int[] arr) {
        //by Arraylist
        System.out.print("FindNumsAppearOnceV1(by list):");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }else{
                list.remove(new Integer(arr[i]));//避免remove方法删除对象和索引混淆
            }
        }
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

}
