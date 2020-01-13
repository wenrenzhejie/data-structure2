package c02_advanced_sort;

import c01_basic_sort.SortHelper;

import java.util.Arrays;
//自顶向上的归并排序
public class MergeSort<T extends Comparable<T>> {
    public void mergeSort(T[] arr,int n){
        mergeSort(arr,0,n - 1);
    }
    private void mergeSort(T[] arr,int l,int r){
        if (l == r){
            return;
        }
        int mid = l + (r - l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        //合并再排序
        merge(arr,l,mid,r);
    }
    private void merge(T[] arr, int l, int mid, int r) {
        T[] aux = (T[]) new Object[r - l + 1];
        for (int i = l;i <= r;i++){
            aux[i - l] = aux[i];
        }
        int i = l,j = mid + 1;
        for (int k = l;k <= r;k++){
            if (i > mid){
                arr[k] = aux[j - l];
                j ++;
            }else if (j > r){
                arr[k] = aux[i - l];
                i ++;
            }
            if (aux[i - l].compareTo(aux[j - l]) > 0){
                arr[k] = aux[j - l];
                j ++;
            }else {
                arr[k] = aux[i - l];
                i ++;
            }
        }

    }
    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(10, 0, 1000);
        System.out.println(Arrays.toString(integers));
        new MergeSort<Integer>().mergeSort(integers,integers.length - 1);
        System.out.println(integers.toString());
    }
}
