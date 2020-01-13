package c02_advanced_sort;

import c01_basic_sort.SortHelper;

import javax.activation.MailcapCommandMap;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void quickSort(Comparable[] arr,int n){
        quickSort(arr,0,n-1);
    }

    private void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int partition = partition(arr, l, r);
        quickSort(arr,l,partition - 1);
        quickSort(arr,partition + 1,r);
    }
    private int partition(Comparable[] arr,int l,int r){
        //使用随机生成的元素作为标杆
        int number = new Random().nextInt(r - l + 1) + l;
        swap(arr,l,number);
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1;i <= r;i ++) {
            if (arr[i].compareTo(v) < 0){
                swap(arr,i,j+1);
                j ++;
            }
        }
        swap(arr,l,j);
        return j;
    }

    private void swap(Comparable[] arr,int i,int j){
      Comparable temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(100, 0, 1000);
        new QuickSort().quickSort(integers,100);
        System.out.println(Arrays.toString(integers));
    }
}
