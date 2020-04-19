package com.pu.高级算法;

import java.util.*;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/9 17:41
 */
public class ConsistencyHashCluster {
    //待加入hash环的服务器列表
    private static String[] servers = {"192.168.0.0:8081", "192.168.0.1:8081", "192.168.0.2:8081", "192.168.0.3:8081", "192.168.0.4:8081"};

    //真实节点列表，因为服务器上下线很正常，添加删除比较多，用LinkedList会更好
    private static List<String> realNodes = new LinkedList<String>();

    //虚拟节点 key 服务器虚拟节点的hash值，value服务器名称
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<Integer, String>();

    //设置虚拟节点和真实节点的倍数，一个真实服务器有8个虚拟节点
    private static final int V_NODE_NUM = 8;

    static {
        for (int i = 0; i < servers.length; i++) {
            realNodes.add(servers[i]);
        }
        for (String str : realNodes) {
            for (int i = 0; i < V_NODE_NUM; i++) {
                String vNodeName = str + "&&VN" + i;
                int hash = getHash(vNodeName);
                System.out.println("虚拟节点[" + vNodeName + "]被添加, hash值为" + hash);
                virtualNodes.put(hash, vNodeName);
            }
        }

    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的hash值
     *
     * @param str
     * @return
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    /**
     * 应该路由到哪台服务器
     *
     * @param node
     * @return
     */
    private static String getServer(String node) {
        int hash = getHash(node);
        //得到大于该Hash值得所有Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();
        //获取虚拟节点
        String vNodeName = subMap.get(i);

        System.out.println(vNodeName);
        //截取真实节点
        return vNodeName.split("&&VN")[0];
    }

    public static void main(String[] args) {

        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "102.211.0.122:3333", "238.226.0.1:2222", "221.211.0.122:3333"};
        for (int i = 0; i < nodes.length; i++)
            System.out.println("[" + nodes[i] + "]的hash值为" + getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
    }
}

