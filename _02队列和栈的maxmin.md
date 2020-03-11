# 栈的最大最小值 O(1)
  栈的最大
  >利用双栈实现,栈栈顶存放最小或者最大值。
  
## 队列的最大最小值返回O(1)
  队列的最值<br>
  例如数组[2,3,4,5,1,5,2]<br>
  最大值分别为[2,3,4,5,5,5,5]<br>
  依次出栈后的最大值为[5,5,5,5,5,5,2];
  
### 设计思路
    利用维护一个单调双向队列实现
    2开始进队 单调队列进入2  最大值为2
    然后3进队 单调队列peek() < 3 , 2出单调队列, 最大值为3;
    4 5 类似
    1进队  1 < peek() 进单调队列
    
    最后单调队记录为：552;
    出队时，如果出队元素 == 队顶元素 队顶元素出，否则不出。
    
```
class MaxQueue {
    private LinkedList<Integer> maxQueue;
    private Queue<Integer> queue;
    public MaxQueue() {
        maxQueue = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.size() > 0 ? maxQueue.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while(maxQueue.size() > 0 && maxQueue.peekLast() < value){
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        int tmp = queue.poll();
        if(maxQueue.size() > 0 && maxQueue.peek() == tmp){
            maxQueue.poll();
        }
        return tmp;
    }
}
```
