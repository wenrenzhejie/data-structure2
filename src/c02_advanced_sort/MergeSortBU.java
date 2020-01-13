package c02_advanced_sort;

import c01_basic_sort.SortHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortBU {
    public void mergeSortBU(Comparable[] arr){
        mergeSortBU(arr,arr.length);
    }
    //对arr的n个元素进行自底向上的归并排序
    private void mergeSortBU(Comparable[] arr, int n) {
        //size 是每次归并的元素个数
        for (int size =1;size <= n;size += size){
            for (int i = 0;i + size < n;i += size + size){
                merge(arr,i,i + size -1,Math.min(i + size + size - 1,n - 1));
            }
        }
    }

    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = l;i <= r;i++){
            aux[i - l] = arr[i];
        }
        int i = l,j = mid + 1;
        for (int k = l;k <= r;k++){
            if (i > mid){
                arr[k] = aux[j - l];
                j ++;
            }else if (j > r){
                arr[k] = aux[i - l];
                i ++;
            }else {
                if (aux[i - l].compareTo(aux[j - l]) < 0){
                    arr[k] = aux[i - l];
                    i ++;
                }else {
                    arr[k] = aux[j - l];
                    j ++;
                }
            }
        }

    }
    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(100, 0, 1000);
        new MergeSortBU().mergeSortBU(integers);
        System.out.println(Arrays.toString(integers));
    }
}
