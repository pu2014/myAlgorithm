package com.pu.数组;

import java.util.HashMap;

/**
 * description：题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 *https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?answerType=1&f=discussion
 * @author Pubojian
 * @date 2019/12/19 22:40
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        数组中出现次数超过一半的数字 cls = new 数组中出现次数超过一半的数字();
        int [] array = {1,2,3,4,5,2,1,1,1,1,1};
        System.out.println(cls.MoreThanHalfNum_SolutionV1(array));
        System.out.println(cls.MoreThanHalfNum_SolutionV2(array));
    }
    /**
     * Description: 利用hashmap来做
     * @auther pubojian
     */
    public int MoreThanHalfNum_SolutionV1(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int len = array.length;
        double midLen = len / 2.0;
        int maxNum = array[0];
        //找出最多数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len ; i++){
            if(map.containsKey(array[i])){
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
                maxNum = count + 1 > map.get(maxNum) ? array[i] : maxNum;
            }else{
                map.put(array[i], 1);
            }
        }
        //判断
        if(map.get(maxNum) > midLen){
            return maxNum;
        }else{
            return 0;
        }
    }

    /**
     * Description:不用其余空间
     * @auther 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?answerType=1&f=discussion
     */
    public int MoreThanHalfNum_SolutionV2(int [] array) {
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
