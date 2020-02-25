package com.LeetCode;

import com.tools.Node;
import com.tools.Print;

import java.io.PrintWriter;

/**
 * description：数组的删除元素和移除特定元素的操作 o(n)时间 o(1)空间复杂度
 * 题目1：26. 删除排序数组中的重复项
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 题目2：27. 移除元素
 *      给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 题目3：203. 移除链表元素
 *      删除链表中等于给定值 val 的所有节点。
 *      输入: 1->2->6->3->4->5->6, val = 6
 *      输出: 1->2->3->4->5
 *
 * 题目4：80. 删除排序数组中的重复项 II
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *      示例 1:
 *      给定 nums = [1,1,1,2,2,3],
 *      函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * @author Pubojian
 * @date 2020/2/25 14:57
 */
public class _05数组的删除重复和移除元素 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        Print.printArray(nums);

        int[] nums2 = {3,4,2,5,3,7,9,8,3,4};
        System.out.println(removeElement(nums2, 4));
        Print.printArray(nums2);

        int[] nums3 = {3,4,2,5,3,7,9,8,3,4};
        System.out.println(removeElementV2(nums3, 4));
        Print.printArray(nums3);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Print.printNode(head);

        Node n1 = removeElements(head,3);
        Print.printNode(n1);

        int[] nums4 = {1,1,1,1,1,2,2,3,4,4,4,5};
        System.out.println(removeSomeDuplicates(nums4));
        Print.printArray(nums4);

        int[] nums5 = {1,1,1,1,1,2,2,3,4,4,4,5};
        System.out.println(removeSomeDuplicatesMy(nums5));
        Print.printArray(nums5);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        //有序数组 若有重复的值一定是一起出现
        int L = 0;
        for(int R = L + 1; R < nums.length; R++){
            if(nums[L] != nums[R]){
                nums[++L] = nums[R];
            }
        }
        return L + 1;
    }

    public static int removeElement(int[] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int L = 0;
        int R = nums.length;
        while(L < R){
            if(nums[R - 1] == val){
                R--;
                continue;
            }
            if(nums[L] == val){
                nums[L] = nums[--R];
            }
            L++;
        }
        return R;
    }

    public static int removeElementV2(int[] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        /*
        删除元素多使用：
         */
        int L = 0;
        for(int R = 0; R < nums.length; R++){
            if(nums[R] != val){
                nums[L++] = nums[R];
            }
        }
        return L;
    }

    public static Node removeElements(Node head, int val){
        Node newNode = new Node(-1);
        newNode.next = head;
        Node pre = newNode;
        Node cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return newNode.next;
    }



    public static int removeSomeDuplicates(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int L = 2;
        for(int R = 2; R < nums.length; R++){
            if(nums[L - 2] != nums[R]){
                nums[L++] = nums[R];
            }
        }
        return L;
    }

    public static int removeSomeDuplicatesMy(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int L = 1;
        int count = 1;
        for(int R = 1; R < nums.length; R++){
            if(nums[R - 1] == nums[R]){
                count++;
            }else{
                count = 1;
            }
            if(count <= 2){
                nums[L++] = nums[R];
            }
        }
        return L;
    }


}
