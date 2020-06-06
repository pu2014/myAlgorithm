package com.笔试.vivo2020届校招在线编程笔试A卷;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @DESC一行字符串，仅有'('、')'、'0' 组成，其中一对'(' ')'表示一个礼品盒，‘0’表示奖品；输入的字符串一定是有效的，即'(' ')'一定是成对出现的。
 *
 * 输出描述:
 * 输出结果为一个数字，表示小v要拆的最少礼品盒数量
 *
 * 输入例子1:
 * (()(()((()(0)))))
 *
 * 输出例子1:
 * 5
 * @CREATE BY @Author pbj on @Date 2020/6/6 23:53
 */
public class c_拆礼盒 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here
        int cnt = 0;
        for(char ch : str.toCharArray()){
            if(ch == '0'){
                break;
            }else if(ch == '('){
                cnt++;
            }else if(ch == ')'){
                cnt--;
            }
        }
        return cnt;

    }
}