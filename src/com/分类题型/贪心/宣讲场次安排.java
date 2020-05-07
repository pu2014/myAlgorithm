package com.分类题型.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 会议室不能同时容纳两个项目，给你一个项目开始的时间和结束时间（数组）  安排宣讲的
 * 日程，要求场次最多并返回。
 *
 * 重点：谁结束早先安排谁
 */
public class 宣讲场次安排 {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] pros, int start){
        Arrays.sort(pros,new ProgramComparator());
        int res = 0;
        for(int i = 0; i < pros.length; i++){
            if(start <= pros[i].start){
                res++;
                start = pros[i].end;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Program[] pros = {new Program(8,10),new Program(9,12),new Program(10,12),new Program(10,11)};
        System.out.println(bestArrange(pros,8));
    }
}
