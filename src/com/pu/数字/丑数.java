package com.pu.数字;

import java.util.ArrayList;

/**
 * description：把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author Pubojian
 * @date 2020/1/10 17:44
 */
public class 丑数 {
    public static void main(String[] args) {
        int index = 7;
        System.out.println(getUglyNumberV1(index));
        System.out.println(getUglyNumberV2(index));
    }

    private static int getUglyNumberV2(int index) {
        /**
         * Description:依次遍历，直到得到需要的数
         * @auther
         */
        if(index <= 0){
            return -1;
        }
        int count = 0;
        int i = 1;
        while(true){
            if(i == 1 || isUglyNumber(i)){
                count++;
                if(count >= index){
                    return i;
                }
            }
            i++;
        }
    }

    private static boolean isUglyNumber(int i) {
        if(i <= 0){
            return false;
        }
        if(i == 1 || (i % 2 == 0 && isUglyNumber(i / 2))
            ||(i % 3 == 0 && isUglyNumber(i / 3))
            ||(i % 5 == 0 && isUglyNumber(i / 5))){
                return true;
        }else {
            return false;
        }
    }

    private static int getUglyNumberV1(int index) {
        /**
         * Description:ugly_numbers include 1 和 2^x * 3^y * 5^z（x, y, z = 0,1,...n)的数。
         * idea 1:Exhaustive method, write down the corresponding ugly numbers in turn.
         * eg:
         * 7  [x, y, z] = 000 100 010 200 001 110 300 020 101 the answer is 300 --> 8
         * @auther pubojian
         */
        if(index < 7){
            return index;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        for(int i = 1; i < index; i++){
            list.add(Math.min(list.get(n2) * 2, Math.min(list.get(n3) * 3, list.get(n5) * 5)));
            if(list.get(i) == list.get(n2) * 2){
                n2++;
            }
            if(list.get(i) == list.get(n3) * 3){
                n3++;
            }
            if(list.get(i) == list.get(n5) * 5){
                n5++;
            }
        }
        return list.get(index - 1);
    }
}
