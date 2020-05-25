package com.剑指Offer;

import java.util.Scanner;

/**
 * @DESC 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @CREATE BY @Author pbj on @Date 2020/5/21 9:28
 */
public class _48表示数值的字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IsNumeric proc = new IsNumeric();
        while(sc.hasNext()) {
            String str = sc.nextLine();
            char[] chs = str.toCharArray();
            System.out.println(proc.fun(chs));
        }
    }
}
class IsNumeric {
    public boolean fun(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        boolean hadP = false;
        boolean hadE = false;
        int zero = -1;
        int i = 0, len = str.length;
        while(i < len){
            //123.45e+6
            //600.0
            //-.123
            char ch = str[i];
            if((ch == '-' || ch == '+') && i != len - 1 && (i == 0 || (i > 0 && (str[i - 1] == 'e' || str[i - 1] == 'E')))){
                i++;
            }else if(ch == '0' && (i == 0 || (i > 0 && i != len - 1 && (str[i - 1] == '+' || str[i - 1] == '-')))){
                zero = i; //记录第一个0的位置
                i++;
            }else if(ch == '0' && i > 0 && i - 1 != zero && ((str[i - 1] >= '0' && str[i - 1] <= '9') || str[i - 1] == '.')){
                i++;
            } else if(ch == '.' && i > 0 && i != len - 1 && ((str[i - 1] >= '0' && str[i - 1] <= '9') || str[i - 1] == '-' || str[i - 1] == '+')&& !hadE && !hadP) {
                hadP = true;
                i++;
            }else if((ch == 'e' || ch == 'E') && i > 0  && i != len - 1 && str[i - 1] >= '0' && str[i - 1] <= '9' && !hadE){
                hadE = true;
                i++;
            }else if(ch > '0' && ch <= '9'){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }
}
