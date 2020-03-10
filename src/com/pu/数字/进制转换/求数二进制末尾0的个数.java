package com.pu.数字.进制转换;

/**
 * description：求数二进制末尾0的个数
 * 例如：
 * 3 011 0
 * 4 100 2
 *
 * @author Pubojian
 * @date 2020/3/8 17:28
 */
public class 求数二进制末尾0的个数 {
    public static void main(String[] args) {
        System.out.println(lowBit(3));
        System.out.println(lowBit(4));
        System.out.println(lowBit(6));

        System.out.println(lowBitMy(3));
        System.out.println(lowBitMy(4));
        System.out.println(lowBitMy(6));
    }

    /**
     * java 自带的算法
     * @param num
     * @return
     */
    public static int lowBit(int num){
        return Integer.numberOfTrailingZeros(num);
    }

    /**
     * 线性时间算法
     * @param num
     * @return
     */
    public static int lowBitMy(int num){
        int count = 0;
        int n = 1;
        for(int i = 0; i < 32; i++){
            if((num & n) == 0){
                count++;
                n = n << 1;
            }else{
                break;
            }
        }
        return count;
    }
}
