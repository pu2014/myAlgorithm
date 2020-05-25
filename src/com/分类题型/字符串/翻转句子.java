package com.分类题型.字符串;

/**
 * description：
 *翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
 * 例如I am a original string翻转后的结果为string original a am I
 * @author Pubojian
 * @date 2019/11/17 16:20
 */
public class 翻转句子 {
    public static void main(String[] args) {
        String str = "I am a original string";
        String res = reverse(str);
        System.out.println(res);

        String res1 = reverse1(str);
        System.out.println(res1);

    }

    private static String reverse1(String str) {
        /**
         * Description:利用数组解决
         * @auther csdn
         */
        char[] chs = str.toCharArray();
        process(chs, chs.length);
        return new String(chs);

    }

    private static void process(char[] chs, int len) {
        reverseSub(chs, 0, len - 1);
        int p = 0; //start
        int q = p; //end
        while(p < len && q < len){
            if(chs[p] == ' '){
                p++;
                q++;
            }else if(chs[q] == ' ' || chs[q] == '\0'){
                reverseSub(chs, p, q - 1);
                p = ++q;
            }else{
                q++;
            }
        }
    }

    private static void reverseSub(char[] chs, int i, int j) {
        char tmp;
        while(i < j){
            tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;

            i++;
            j--;
        }
    }

    private static String reverse(String str) {
        /**
         * Description:利用正则式实现。
         * @auther pubojian
         */
        if(str == null){
            return null;
        }
        String res = "";
        String[] splitStr = str.split(" ");
        for (int i = splitStr.length - 1; i >= 0; i--){
            if(res == ""){
                res += splitStr[i];
            }else {
                res = res + " " + splitStr[i];
            }
        }
        return res;
    }
}
