package com.笔试.oppo;


import java.math.BigDecimal;
import java.util.*;
/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/29 19:29
 */
public class OPMain1 {

    public static double add(double a, double b){
        return new BigDecimal(a).add(new BigDecimal(b)).doubleValue();
    }
}
