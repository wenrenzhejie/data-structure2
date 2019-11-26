package c01_basic_sort;
import java.util.Arrays;
//选择排序(从后面的元素中选择一个最小值，与当前元素交换)
public class SelectionSort<T extends Comparable<T>> {
    public T[] selectionSort(T[] arr){
        for (int i = 0;i < arr.length;i ++){
            int minIndex = i;
            for (int j = minIndex + 1;j < arr.length;j++){
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
    //选择排序的优化（同时找到最大值和最小值）
    public T[] selectionSort2(T[] arr){
        int left = 0,right = arr.length - 1;
        while (left < right){
            int minIndex = left,maxIndex = right;
            if (arr[left].compareTo(arr[right]) > 0){
                swap(arr,left,right);
            }
            for (int i = left + 1;i < right;i ++){
                if (arr[i].compareTo(arr[minIndex]) < 0){
                    minIndex = i;
                }else if (arr[i].compareTo(arr[maxIndex]) > 0){
                    maxIndex = i;
                }
            }
            swap(arr,left,minIndex);
            swap(arr,right,maxIndex);
            left ++;
            right --;
        }
        return arr;
    }
    public void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        Integer[] integers = new SelectionSort<Integer>().selectionSort(SortHelper.generateArray(1000,0,10000));
        System.out.println(Arrays.toString(integers));
    }
}
