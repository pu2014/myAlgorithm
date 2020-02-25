package com.pu.测试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/22 14:28
 */
public class newList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(new ArrayList<>(6));
        list.add(8);
        System.out.println(list);
    }
}
