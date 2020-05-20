package com.剑指Offer;

/**
 * @DESC 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @CREATE BY @Author pbj on @Date 2020/5/20 19:46
 */
public class _45把字符串转换成整数 {
    public static void main(String[] args) {
        String str = "-212";
        System.out.println(Integer.valueOf(str));
        System.out.println(new StrToInt().fun(str));
    }
}
class StrToInt {
    public int fun(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;
        if(len > 0){
            char firstChar = s.charAt(0);
            if(firstChar == '-'){
                if(firstChar == '-'){
                    negative = true;
                    limit = Integer.MIN_VALUE;
                }else if(firstChar != '+'){
                    return 0;
                }
                if(len == 1){
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while(i < len){
                digit = s.charAt(i++) - '0';
                if(digit < 0 || digit > 9){
                    return 0;
                }
                if(result < multmin){
                    return 0;
                }
                result *= 10;
                if(result < limit + digit){
                    return 0;
                }
                result -= digit;
            }
        }else{
            return 0;
        }
        return negative ? result : -result;
    }
}
/*
public static int parseInt(String s, int radix)
                throws NumberFormatException
    {
        if (s == null) {
                throw new NumberFormatException("null");
                }

        if (radix < Character.MIN_RADIX) {
        throw new NumberFormatException("radix " + radix +
        " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
        throw new NumberFormatException("radix " + radix +
        " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
        char firstChar = s.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
        if (firstChar == '-') {
        negative = true;
        limit = Integer.MIN_VALUE;
        } else if (firstChar != '+')
        throw NumberFormatException.forInputString(s);

        if (len == 1) // Cannot have lone "+" or "-"
        throw NumberFormatException.forInputString(s);
        i++;
        }
        multmin = limit / radix;
        while (i < len) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        digit = Character.digit(s.charAt(i++),radix);
        if (digit < 0) {
        throw NumberFormatException.forInputString(s);
        }
        if (result < multmin) {
        throw NumberFormatException.forInputString(s);
        }
        result *= radix;
        if (result < limit + digit) {
        throw NumberFormatException.forInputString(s);
        }
        result -= digit;
        }
        } else {
        throw NumberFormatException.forInputString(s);
        }
        return negative ? result : -result;
        }

 */