package com.分类题型.数组;

import java.util.Arrays;

/**
 * description：
 *BFPRT算法步骤如下：
 * （1）：选取主元；
 *   （1.1）：将n个元素划分为⌊n5⌋⌊n5⌋个组，每组5个元素，若有剩余，舍去；
 *   （1.2）：使用插入排序找到⌊n5⌋⌊n5⌋个组中每一组的中位数；
 *   （1.3）：对于（1.2）中找到的所有中位数，调用BFPRT算法求出它们的中位数，作为主元；
 * （2）：以（1.3）选取的主元为分界点，把小于主元的放在左边，大于主元的放在右边；
 * （3）：判断主元的位置与k的大小，有选择的对左边或右边递归。
 * ————————————————
 * @author Pubojian
 * @date 2020/2/8 22:09
 */
public class Top_K问题BFPRT {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 8, 9, 9, 10, 6, 2, 6, 4, 5, 7, 1, 2, 3};
        //[1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 9, 9, 10]
        System.out.println(Arrays.toString(getMinKNums(arr, 10)));

    }
    public static int[] getMinKNums(int[] arr, int k){
        if(k < 1 || k > arr.length){
            return arr;
        }
        int minKth = getMinKthByBFPRT(arr, k);
        System.out.println("getMinKthByBFPRT" + minKth);
        int[] res = new int[k];
        int index = 0;
        for(int i = 0; i != arr.length; i++){
            if(arr[i] < minKth){
                res[index++] = arr[i];
            }
        }
        for(;index != res.length; index++){
            res[index] = minKth;
        }
        return res;
    }

    private static int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr = copArray(arr);
        return select(copyArr, 0, copyArr.length - 1, k - 1);
    }

    private static int select(int[] arr, int begin, int end, int i) {
        if(begin == end){
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end); // 得到中位数的
        System.out.println(pivot);
        int[] pivotRange = partition(arr, begin, end, pivot);
        System.out.println(Arrays.toString(pivotRange));
        if(i >= pivotRange[0] && i <= pivotRange[1]){
            return arr[i];
        }else if(i < pivotRange[0]){
            return select(arr, begin, pivotRange[0] - 1, i);
        }else{
            return select(arr, pivotRange[1] + 1, end, i);
        }
    }

    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int less = begin - 1;
        int cur = begin;
        int more = end + 1;
        while(cur != more){
            if(arr[cur] < pivot){
                swap(arr, ++less, cur++);
            }else if(arr[cur] > pivot){
                swap(arr, --more, cur);
            }else{
                cur++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for(int i = 0; i < mArr.length; i++){
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        System.out.println(Arrays.toString(mArr));
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int begin, int end) {
        Arrays.sort(arr, begin, end + 1);//快排
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    private static int[] copArray(int[] arr) {
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
}
