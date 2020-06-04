package com.分类题型.动态规划.数组动态规划;

import java.util.Arrays;

/**
 * @DESC
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *  输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/4 19:38
 */
public class _354俄罗斯套娃信封问题 {
}
class MaxEnvelopes {
    public int fun(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null ||  envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
        int max = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i = 0; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}