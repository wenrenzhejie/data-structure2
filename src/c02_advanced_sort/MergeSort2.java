package c02_advanced_sort;

import c01_basic_sort.SortHelper;

import java.util.Arrays;
//自顶向上的归并排序
public class MergeSort2 {
    public void mergeSort(Comparable[] arr){
        mergeSort(arr,0,arr.length - 1);
    }
    private void mergeSort(Comparable[] arr,int l,int r){
        /*if (l == r){
            return;
        }*/
        //采用插入排序进行优化)(小数组使用插入排序)
        if (r - l <= 15){
            insectionSort(arr,l,r);
            return;
        }
        int mid = l +(r - l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        //归并排序的第一层优化
        if (arr[mid].compareTo(arr[mid + 1]) > 0){
            merge(arr,l,mid,r);
        }
    }

    private void insectionSort(Comparable[] arr, int l, int r) {
        for (int i = l + 1;i <= r;i++){
            Comparable e = arr[i];
            int j = i;
           for (j = i;j > l && arr[j - 1].compareTo(e) > 0;j --){
                arr[j] =arr[j - 1];
           }
           arr[j] = e;
        }
    }

    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux =  new Comparable[r - l + 1];
        for(int i = l;i <= r;i++){
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
                if (aux[i - l].compareTo(aux[j - l]) > 0){
                    arr[k] = aux[j - l];
                    j ++;
                }else {
                    arr[k] = aux[i - l];
                    i ++;
                }
            }
        }
    }

    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(100, 0, 1000);
        System.out.println(Arrays.toString(integers));
        new MergeSort2().mergeSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
