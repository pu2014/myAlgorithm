package com.笔试.bigo;

import java.util.Comparator;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/18 20:13
 */
public class Main2 {
    public static<T> void select(T[] arr){
        process(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 < o2 ? -1 : o1.equals(o2) ? 0 : 1;
            }
        });
    }
    public static<T> void process(T[] arr, Comparator<Integer> comparator){
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++) {
                if(comparator.compare((Integer)arr[i], (Integer)arr[j]) > 0){
                    swap(arr,i,j);
                }
            }
        }
    }

    private static<T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
