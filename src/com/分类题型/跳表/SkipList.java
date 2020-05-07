package com.分类题型.跳表;

import java.util.Random;

/**
 * description：跳表(SkipList)：增加了向前指针的链表叫做指针。
 * 跳表全称叫做跳跃表，简称跳表。跳表是一个随机化的数据结构，
 * 实质是一种可以进行二分查找的有序链表。跳表在原有的有序链表上
 * 增加了多级索引，通过索引来实现快速查询。
 * 跳表不仅能提高搜索性能，同时也可以提高插入和删除操作的性能。
 *
 * 目前在Redis和LevelDB中都有用到
 *
 * 时间复杂度：3O(logN) 空间复杂度：O(N)
 * @author Pubojian
 * @date 2019/11/7 16:48
 */
public class SkipList {

    private static final int MAX_LEVEL = 20;
    private int levelCount = 1;
    private Node head = new Node(null);
    private Random random = new Random();

    public class Node{
       private Integer data;
       private Node[] next;
       private int maxLevel;

        public Node(Integer data) {
            this.data = data;
            next = new Node[MAX_LEVEL];
            maxLevel = 0;
        }

        @Override
       public String toString() {
           StringBuilder str = new StringBuilder();
           str.append("{data:");
           str.append(data);
           str.append("; levels: ");
           str.append(maxLevel);
           str.append(" }");
           return str.toString();
       }
   }

   public Node find(int value){
        Node p = head;
        for(int i = levelCount - 1; i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
        }

        if(p.next[0] != null && p.next[0].data == value){
            return p.next[0];
        }else{
            return null;
        }
   }

   public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node(value);
        newNode.maxLevel = level;
        Node updata[] = new Node[level];
        for (int i = 0; i < level; i++){
            updata[i] = head;
        }

        Node p = head;
        for(int i = level - 1; i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
            updata[i] = p;
        }

        for(int i = 0; i < level; ++i){
            newNode.next[i] = updata[i].next[i];
            updata[i].next[i] = newNode;
        }

        if(levelCount < level){
            levelCount = level;
        }
   }

   public boolean delete(int value){
        Node[] updata = new Node[levelCount];
        Node p = head;
        for(int i = levelCount - 1; i>= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
            updata[i] = p;
        }
        if(p.next[0] != null && p.next[0].data == value){
            for(int i = levelCount - 1; i >= 0; --i){
                if(updata[i].next[i] !=  null &&
                        updata[i].next[i].data == value){
                    updata[i].next[i] = updata[i].next[i].next[i];
                }
            }
            return true;

        }else{
            return false;
        }
   }

   public void display(){
        Node p = head;
        while(p.next[0] != null){
            System.out.println(p.next[0]);
            p = p.next[0];
        }
   }

    private int randomLevel() {
        int level = 1;
        for(int i = 1; i< MAX_LEVEL; ++i){
            if((random.nextInt() & 1) == 1){
                level++;
            }
        }
        return level;
    }

    public static void main(String[] args){
        SkipList sl = new SkipList();
        sl.insert(3);
        sl.insert(4);
        sl.insert(5);
        sl.insert(2);
        sl.insert(9);
        sl.insert(6);
        sl.insert(11);
        sl.insert(12);
        sl.insert(13);
        sl.insert(14);
        sl.insert(15);
        sl.insert(16);
        sl.insert(17);

        sl.display();
//        System.out.println(sl.find(10));
//        System.out.println(sl.find(9));
//        System.out.println(sl.delete(9));
//        sl.display();

    }
}
