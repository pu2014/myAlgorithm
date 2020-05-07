package com.分类题型.单调栈;


import java.util.Stack;

/**
 * description：环形山  例如 3 - 5 - 4 - 2 - 1 -  例如 数字代表高度
 * 3 - 4 不可见因为5 挡住。。 求最多可以互见的值。
 *
 * @author Pubojian
 * @date 2020/2/12 22:10
 */
public class 网易环形山 {
    public static void main(String[] args) {
        int[] crater = {3, 4, 1, 3 , 5, 2, 5};
        System.out.println(getTheNumOfMoun(crater));
    }

    public static long getTheNumOfMoun(int[] crater){
        if(crater == null || crater.length < 2){
            return 0;
        }
        //get the index of maxValue
        int maxIndex = 0;
        int size = crater.length;
        for(int i = 0; i < size; i++){
            maxIndex = crater[maxIndex] < crater[i] ? i : maxIndex;
        }
        int value = crater[maxIndex];
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));
        int index = nextIndex(size, maxIndex);
        long res = 0L;
        while(index != maxIndex){
            value = crater[index];
            while(!stack.isEmpty() && stack.peek().value < value){
                int times = stack.pop().times;
                res += getInternalSum(times) + times;
                res += stack.isEmpty() ? 0 : times;
            }
            if(!stack.isEmpty() && stack.peek().value == value) {
                stack.peek().times++;
            }else{
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }
        while(!stack.isEmpty()){
            int times = stack.pop().times;
            res += getInternalSum(times);
            if(!stack.isEmpty()){
                res += times;
                if(stack.size() > 1){
                    res += times;
                }else{
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }

    public static int getInternalSum(int times){
        return times == 1 ? 0 : times * (times - 1) >> 1;
    }

    public static int nextIndex(int size, int index){
        return index < (size - 1) ? index + 1 : 0;
    }

    static class Pair{
        public int value;
        public int times;

        public Pair(int value){
            this.value = value;
            this.times = 1;
        }
    }
}
