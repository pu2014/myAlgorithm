package com.分类题型.字符串;

/**
 * description：假设我们有两个字符串A和B，那么如果想要将字符串A通过
 * 以下三种操作变换成B：删除、新增和修改，操作步骤的次数就称为 字符串 A 和 B 之间的距离。
 *
 * 现在给定两个字符串，求这两个字符串之间的最短距离。
 *
 * @author Pubojian
 * @date 2019/11/17 16:53
 */
public class 计算字符串之间的最短距离 {
    public static void main(String[] args) {
        String A = "fxpimu";
        String B = "xwrs";
        System.out.println(minStrDis(A,B));
    }

    private static int minStrDis(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        return process(a, b, 0, 0, a.length, b.length);
    }

    private static int process(char[] a, char[] b, int i, int j, int aLen, int bLen) {
        if(aLen == 0){
            if(bLen == 0){
                return 0;//都为null则无需操作
            }else{
                return bLen;//一个为null，距离就为另一个的长度。
            }
        }
        if(bLen == 0){
            if(aLen == 0){
                return 0;
            }else{
                return aLen;
            }
        }
        if(a[i] == b[j]){ //字符一样指针后移
            return process(a, b, i + 1, j + 1, aLen - 1, bLen - 1);
        }else{
            //删除b的第一个字符
            int t1 = process(a, b, i, j + 1, aLen, bLen - 1);
            //删除a的第一个字符
            int t2 = process(a, b, i + 1, j, aLen - 1, bLen);
            //修改第一个字符为一样的
            int t3 = process(a, b, i + 1, j + 1, aLen - 1, bLen - 1);
            return minValue(t1, t2, t3) + 1; //一步操作为0，需要加上1
        }
    }

    private static int minValue(int t1, int t2, int t3) {
        return t1 < t2 ? t1 < t3 ? t1 : t3 : t2 < t3 ? t2 : t3;
    }
}
