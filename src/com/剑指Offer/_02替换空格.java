package com.剑指Offer;

/**
 * description：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author Pubojian
 * @date 2020/2/21 20:10
 */
public class _02替换空格 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println("the standard answer: " + replaceAll(str));
        System.out.println("my method: " + replaceSpace(str));
    }

    private static String replaceAll(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
        //System.out.println(str.toString().replace(" ","20%"));
        /**
         * 1. String   replace(char oldChar, char newChar)
         *     描述：Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.
         *     谷歌翻译：返回使用newChar替换此字符串中所有出现的oldChar而产生的字符串。
         * 2. String   replace(CharSequence target, CharSequence replacement)
         *     描述：Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.
         *     谷歌翻译： 将与该文字目标序列匹配的此字符串的每个子字符串替换为指定的文字替换序列。
         * 3. String   replaceAll(String regex, String replacement)
         *     描述：Replaces each substring of this string that matches the given regular expression with the given replacement.
         *     谷歌翻译：将给定替换的给定正则表达式匹配的此字符串的每个子字符串替换。
         * 4. String   replaceFirst(String regex, String replacement)
         *     描述：Replaces the first substring of this string that matches the given regular expression with the given replacement.
         */
    }

    private static String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return null;
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
