package c03_heap;

import c01_basic_sort.SortHelper;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> {
    public void heapSort(T[] arr,int n){
        //heapify
        for (int i = (n - 1)/2;i >= 0;i --) {
            shiftDown(arr,n,i);
        }
        for (int i = 1;i < n;i++){
            swap(arr,0,(n - i));
            shiftDown(arr,(n - i),0);
        }
    }


    private void shiftDown(T[] arr, int length, int i) {
        while (2 * i + 1 <= (length - 1)){
            int j = 2 * i + 1;
            if (j + 1 <= length - 1 && arr[j].compareTo(arr[j + 1]) < 0){
                j = j + 1;
            }
            if (arr[i].compareTo(arr[j])< 0){
                swap(arr,i,j);
                i = j;
            }else {
                break;
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(100, 0, 1000);
        System.out.println("排序前："+ Arrays.toString(integers));
        new HeapSort<Integer>().heapSort(integers,integers.length);
        System.out.println("排序后："+Arrays.toString(integers));
    }
}
