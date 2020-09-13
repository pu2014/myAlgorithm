package com.笔试.vivo;

import java.io.*;
import java.util.*;
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String substring = input.substring(1, input.length() - 1);
        int[] nums = Arrays.stream(substring.split(",")).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        List<Integer> path;
        boolean[] isVis = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (!isVis[i]) {
                int cur = i;
                path = new ArrayList<>();
                while (nums[cur] != -1 && !isVis[cur]) {
                    path.add(cur);
                    isVis[cur] = true;
                    cur = nums[cur];
                }
                if(!isVis[cur]){
                    sb.append(cur).append(",");
                    isVis[cur] = true;
                }
                for(int k = path.size() - 1; k >= 0; k--){
                    sb.append(path.get(k)).append(",");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println('"' + sb.toString() + '"');
    }
}
