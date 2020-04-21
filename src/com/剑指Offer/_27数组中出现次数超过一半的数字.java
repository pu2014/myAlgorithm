package com.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数
 * 字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * Created By @Author my on @Date 2020/4/21 17:01
 */
public class _27数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5,2,2,2,3,2};
        MoreThanHalfNum_Solution fun = new MoreThanHalfNum_Solution();
        System.out.println(fun.method1(nums));

        int[] nums2 = {1,2,2,3,4,5,2,2,2,3,2};
        System.out.println(fun.method2(nums2));
    }
}

class MoreThanHalfNum_Solution {

    //利用哈希map
    public int method2(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap();
        for(int num : array){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key).intValue() > array.length / 2){
                return key;
            }
        }
        return -1;
    }

    //不用额外空间
    public int method1(int [] array) {
        if(array == null || array.length == 0)return 0;
        int preValue = array[0];//用来记录上一次的记录
        int count = 1;//preValue出现的次数（相减之后）
        for(int i = 1; i < array.length; i++){
            if(array[i] == preValue)
                count++;
            else{
                count--;
                if(count == 0){
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;//需要判断是否真的是大于1半数
        for(int i=0; i < array.length; i++)
            if(array[i] == preValue)
                num++;
        return (num > array.length/2)?preValue:0;

    }
}

