package com.面试题;

/**
 * @DESC 单例模式的实现
 *      构造方法私有
 * @CREATE BY @Author pbj on @Date 2020/5/13 9:44
 */
public class SingleDemo{
    public static void main(String[] args) {

    }
}

/**
 * 饿汉式：线程安全，调用效率高，不能延时加载
 *      * 一上来就创建单列对象，要用时直接返回。用不用都会创建，会造成资源浪费
 */
class ImageLoader{
    private static ImageLoader loader = new ImageLoader();
    private ImageLoader(){}
    public static ImageLoader getInstance(){
        return loader;
    }

}

/**
 * 懒汉式： 线程安全，调用效率不高，但是能延时加载
 *      * 每次调用get时会同步，浪费资源
 */
class LazySingle{
    private static LazySingle lazy;
    private LazySingle(){}
    public static synchronized LazySingle getInstance(){
        if(lazy == null){
            lazy = new LazySingle();
        }
        return lazy;
    }
}

/**
 * 双重锁机制DCL，本质也是一种懒汉模式，性能较好
 */
class DclDemo{
    /**
     * 防止new时指令重排序
     */
    private static volatile DclDemo dcl;
    private DclDemo(){}
    public static DclDemo getInstance(){
        if(dcl == null){
            synchronized (DclDemo.class){
                if(dcl == null){
                    dcl = new DclDemo();
                }
            }
        }
        return dcl;
    }
}

/**
 * 线程安全， 调用效率高，可以延时加载
 */
class StaticSingle{
    private static class StaticSingleInstance{
        private static final StaticSingle staticSingleInstance = new StaticSingle();
    }

    private StaticSingle(){}

    public StaticSingle getInSingle(){
        return StaticSingleInstance.staticSingleInstance;
    }
}