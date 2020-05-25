package com.分类题型.测试;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description：
 *
 * @author Pubojian
 * @date 2019/11/17 16:02
 */
public class testmap {
    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("c",4);
        map.put("b",2);
        map.put("a",5);
        map.put("b",7);
        for(String str : map.keySet()){
            System.out.println(str + ":" + map.get(str));
        }
    }
}
