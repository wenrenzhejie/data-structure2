package c02_advanced_sort;

import c01_basic_sort.SortHelper;

import java.util.Arrays;
import java.util.Random;
//三路快排算法
public class QuickSort3 {
    public void quickSort(Comparable[] arr,int n){
        quickSort(arr,0,n-1);
    }

    private void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        //使用随机生成的元素作为标杆
        int number = new Random().nextInt(r - l + 1) + l;
        swap(arr,l,number);
        Comparable v = arr[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt){
            if (arr[i].compareTo(v) < 0){
                swap(arr,lt + 1,i);
                i ++;
                lt ++;
            }else if (arr[i].compareTo(v) == 0){
                i ++;
            }else {
                swap(arr,gt - 1,i);
                gt --;
            }
        }
        swap(arr,l,lt);
        quickSort(arr,l,lt-1);
        quickSort(arr,gt,r);
    }


    private void swap(Comparable[] arr,int i,int j){
      Comparable temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(100, 0, 10);
        new QuickSort3().quickSort(integers,100);
        System.out.println(Arrays.toString(integers));
    }
}
