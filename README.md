# myAlgorithm
    主要是算法题的总结和归纳。包括leetcode/剑指offer
    
>## 数组问题
    数组问题常见问题：
    1. 排序
    2. 查找某一个数
    3. 迷宫问题
    4. 子数组问题
>### 1：排序
java 常用的排序有Collections.sort 和 Arrays.sort的排序方法其中Collections.sort()对集合实现排序，其源码为：
  ```
  @SuppressWarnings({"unchecked", "rawtypes"})
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
  ```
可以看出是内部是利用Arrays.sort()将集合转化的数组实现排序。Arrays.sort使用了两种排序方法，快速排序和优化的归并排序。快速排序主要是对那些基本类型数据（int,short,long等）排序， 而归并排序用于对Object类型进行排序。<br>
**排序原则**：
1. 若你需要排序的是基本数据类型，则选择快速排序。若你需要排序的是引用数据类型，则选择归并排序。(基于稳定性考虑)因为基本数据类型之间无差异，不需要考虑排序算法稳定性，而归并排序则可以实现算法的稳定性。
2. 当你需要排序的样本数量小于60，直接选择插入排序，虽然插入排序的时间复杂度为O(N²)，我们是忽略常数项得出来的O(N²)，但在魔数60以内，插入排序的时间复杂度为O(N²)的劣势体现不出来，反而插入排序常数项很低，导致在小样本情况下，插入排序极快。 如果一开始数组容量很大，但可以分治处理分<br>治后如果数组容量(L>R - 60)小于60，可以直接选择插排。当大样本下考虑情况1。

>#### 插入排序 N^2
```
private static void insertSort(int[] arr) {
        if(arr.length < 2 || arr == null)
            return;
        for (int i = 1; i < arr.length; i++) {  // 0 - (i- 1)已排好序，将新来元素arr[i]插入到已排好序的数组中
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[j + 1]){   
                    swap(arr,j,j+1);
                }
            }
        }
    }
```
>#### 快速排序 NlogN
```
private static void quickSort(int[] arr) {
        quickSorting(arr,0,arr.length - 1);

    }

    private static void quickSorting(int[] arr, int left, int right) {
        if(left < right) {
            int[] index = partition(arr, left, right);
            quickSorting(arr, left, index[0] - 1);
            quickSorting(arr, index[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        //随机选取，经典排序
        int pivot = arr[(int)Math.random()*(right - left + 1) + left]; // 随机选取基准值 做partition
        int i = left;
        while(i <= right){
            if(arr[i] < pivot){
                swap(arr,i++,left++);
            }else if(arr[i] > pivot){
                swap(arr,i,right--);
            }else {
                i++;
            }
        }
        return new int[]{left,right};
    }
```
>#### 归并排序 NlogN
```
private static void mergeSort(int[] arr,int L,int R) {
        if (L == R)
            return;
        int mid = L + ((R - L) >> 1);
        mergeSort(arr,L,mid);
        mergeSort(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] ex = new int[R - L + 1];
        int i = 0; //ex数组的坐标
        int p = L;
        int q = mid + 1;
        while(p <= mid && q <= R){
            ex[i++] = arr[p] < arr[q] ? arr[p++]:arr[q++];
        }
        while(p <= mid){
            ex[i++] = arr[p++];
        }
        while (q <= R){
            ex[i++] = arr[q++];
        }
        for (int j = 0; j < ex.length; j++) {
            arr[L + j] = ex[j];
        }
    }
```
>#### 选择排序和冒泡排序 N^2
```
private static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }


private static void bubbleSort(int[] arr) {
        if(arr.length < 2 || arr == null){
            return;
        }
        int temp = 0;
        for (int i = arr.length -1 ; i >= 0; i--) {
            for (int j = 0; j < i ; j++) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
```
>#### 桶排序 O(M + N) 
    先找出要排序的树的
```
public class 排序_桶排序 {
    public static void main(String[] args){
        int[] arr = createArr(10);
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bucketSort(int[] arr) {
        int min = getArrMin(arr);
        int max = getArrMax(arr);
        int len = (max -min)/10 + 1;
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>(len);
        for(int i = 0; i < len; i++){
            bucket.add(new LinkedList<Integer>());
        }
        enterBucket(arr,bucket,min,len);
        for(LinkedList<Integer> ll:bucket){
            Collections.sort(ll);
        }
        outBucket(arr,bucket);

    }

    private static void outBucket(int[] arr, ArrayList<LinkedList<Integer>> bucket) {
        int index = 0;
        for(LinkedList<Integer> ll:bucket){
            for(Integer i : ll){
                arr[index++] = i;
            }
        }
    }

    private static void enterBucket(int[] arr, ArrayList<LinkedList<Integer>> bucket,int min,int len) {
        for(int i = 0; i < arr.length; i++){
            bucket.get((arr[i] - min) / 10).add(arr[i]);
        }
    }

    private static int getArrMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    private static int getArrMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i <arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        return min;
    }

    private static int[] createArr(int n) {
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = (int)(Math.random() * 100);  // 0.0-0.99 包括0
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
```
