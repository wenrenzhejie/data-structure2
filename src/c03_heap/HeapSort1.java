package c03_heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class HeapSort1<T extends Comparable<T>> {
    public void heapSort(T[] arr,int n){
        MaxHeap<T> maxHeap = new MaxHeap<>(n);
        for (int i = 0;i < n;i++){
            maxHeap.insert(arr[i]);
        }
        for (int i = n-1;i >= 0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }
    public static void main(String[] args){
        Random random = new Random();
        Integer[] integers = new Integer[30];
        for (int i = 0;i < integers.length;i++){
            integers[i] = random.nextInt(300);
        }
        System.out.println("排序前："+Arrays.toString(integers));
        new HeapSort1<Integer>().heapSort(integers,integers.length);
        System.out.println("排序后:"+Arrays.toString(integers));
    }
}
