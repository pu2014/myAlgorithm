package com.分类题型.测试;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/13 11:42
 */
public class MapOrDefaultTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.getOrDefault(1, 0);
        for(int key : map.keySet()){
            System.out.println(key + ' ' + map.get(key));
        }

    }
}
