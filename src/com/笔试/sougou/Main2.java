package com.笔试.sougou;

import java.util.ArrayList;
import java.util.List;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/5 18:36
 */
public class Main2 {
    public static void main(String[] args) {
        int t = 2;
        int[] xa = {-1, 4, 5, 2};
        System.out.println(getHouses(t, xa));
    }
    public static int getHouses(int t, int[] xa){
        if(xa == null || xa.length == 0){
            return 0;
        }
        if(xa.length <= 2){
            return 2;
        }
        double ll, rr;
        int res = 0;
        for(int i = 2; i < xa.length; i += 2){
            ll = xa[i - 2] + (double)xa[i - 1]/2;
            rr = xa[i] - (double)xa[i + 1]/2;
            if(rr - ll == t){
                res++;
            }else if(rr - ll > t){
                res += 2;
            }
        }
        res += 2;
        return res;
    }
}
