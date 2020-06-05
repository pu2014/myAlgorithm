package com.剑指Offer;

import com.tools.MyInput;

/**
 * @DESC 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/5 9:21
 */
public class _56数组中数字出现的次数2 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        SingleNumber proc = new SingleNumber();
        System.out.println(proc.fun(nums));
    }
}
class SingleNumber {
    /**
     * 根据二进制位置上的数来判断
     * @param nums
     * @return
     */
    public int fun(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        int res = 0;
        int index;
        for(int i = 0; i < 32; i++){
            count = 0;
            index = 1 << i;
            for(int num : nums){
                if((num & index) == index){
                    count++;
                }
            }
            if(count % 3 == 1){
                res |= index;
            }
        }
        return res;
    }
}
