package com.pu.测试;

/**
 * @Description:test String Split()  and parseInt() and replace()
 * regex:
 * /t 相当于tab 缩进
 * /n 回车
 * /r 换行
 * \\s 作为分隔符表示空白
 *
 * str.trim(); //去掉首尾空格
 * str.replace(" ",""); //去除所有空格，包括首尾、中间
 * str.replaceAll(" ", ""); //去掉所有空格，包括首尾、中间
 * str.replaceAll(" +","");  //去掉所有空格，包括首尾、中间
 * str.replaceAll("\\s*", ""); //可以替换大部分空白字符， 不限于空格 ；
 * 　　　\\s* 可以匹配空格、制表符、换页符等空白字符的其中任意一个。
 *
 * replaceAll(regex, string) & replace(str, str) & repaceFirst(Regex, String)
 *不同点：replaceAll支持正则表达式，因此会对参数进行解析（两个参数均是），
 * 如replaceAll("\\d", "*")，而replace则不会，replace("\\d","*")就是替换"\\d"的字符串，而不会解析为正则。
 * 另外还有一个不同点：“\”在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println( "\\" ) ;只
 * 打印出一个"\"。但是“\”也是正则表达式中的转义字符，需要用两个代表一个。
 * 所以：\\\\被java转换成\\，\\又被正则表
 * 达式转换成\，因此用replaceAll替换“\”为"\\"，就要用replaceAll("\\\\","\\\\\\\\")，而replace则replace("\\","\\\\")。
 *
 * 如果只想替换第一次出现的，可以使用replaceFirst()，这个方法也是基于规则表达式的替换，但与replaceAll()不同的是，只
 * 替换第一次出现的字符串。
 * @Author:Pubojian
 * @Date: Created in 14:36 2019/11/28
 **/
public class 字符串的split {
    public static void main(String[] args) {
        String str = "    9090 wd";
        String[] strArray = str.split("");
        for (String s : strArray) {
            System.out.println(s);
        }
        System.out.println("去除头部空格-->" + str.trim());
        System.out.println("去除所有空格-->" + str.replace(" ", ""));
        System.out.println("去除所有空格-->" + str.replaceAll(" ", ""));
        System.out.println("去除所有空格-->" + str.replaceAll(" +", ""));
        System.out.println("去除所有空格-->" + str.replaceAll("\\s*", ""));
        System.out.println(Integer.parseInt(str.replaceAll(" ", ""), 10));
    }
}
