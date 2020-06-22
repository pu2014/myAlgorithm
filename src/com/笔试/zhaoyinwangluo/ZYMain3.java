package com.笔试.zhaoyinwangluo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC 洗牌问题
 *  牌面有 0123456789，现在需要洗n张牌，从上到下依次是第一张，第二张。。
 *  首先将牌分成两堆，左手拿上半堆，右手下半堆。如果n 为奇数， 左手比右手多一张牌
 *   开始洗牌，如果是第奇数次，先放右手最后一张牌，再放左手最后一张牌。接着放右手的倒数第二张牌
 *   偶数次 先放左手，再放右手
 *   直到洗完牌
 *
 *   求k次洗牌后的结果
 * @CREATE BY @Author pbj on @Date 2020/6/22 21:20
 */
public class ZYMain3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] leftArr;
        int[] rightArr;
        if(n % 2 == 0){
            leftArr = new int[n / 2];
            rightArr = new int[n / 2];
        }else{
            leftArr = new int[n / 2 + 1];
            rightArr = new int[n / 2];
        }
        for(int i = 0; i < leftArr.length; i++){
            leftArr[i] = sc.nextInt();
        }
        for(int i = 0; i < rightArr.length; i++){
            rightArr[i] = sc.nextInt();
        }
        int[] res = new int[n];
        int left, right, inx;
        for(int i = 1; i <= k; i++){
            left = leftArr.length - 1;
            right = rightArr.length - 1;
            inx = n - 1;
            if(i % 2 == 1){
                while(left >= 0 || right >= 0){
                    if(right >= 0) res[inx--] = rightArr[right--];
                    if(left >= 0) res[inx--] = leftArr[left--];
                }
            }else{
                while(left >= 0 || right >= 0){
                    if(left >= 0) res[inx--] = leftArr[left--];
                    if(right >= 0) res[inx--] = rightArr[right--];
                }
            }
            for(int m = 0; m < leftArr.length; m++){
                leftArr[m] = res[m];
            }
            for(int m = leftArr.length; m < n; m++){
                rightArr[m - leftArr.length] = res[m];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
