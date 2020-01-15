package c04_binary_tree;

import java.sql.PreparedStatement;

public class BinarySearch<T extends Comparable<T>>{
    public int binarySearch1(T[] arr,T target){
        int l = 0;
        int r = arr.length - 1;
        int mid = l + (r - l) / 2;
        while (arr[mid].compareTo(target) != 0){
            if (l == r){
                return -1;
            }
            if (arr[mid].compareTo(target) > 0){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
            mid = l + (r - l)/2;
        }
        return mid;
    }
    public int binarySearch2(T[] arr,T target){
        int l = 0,r = arr.length - 1;
        /*在[l...r]这个区间里查找*/
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0){
                return mid;
            }
            if (arr[mid].compareTo(target) > 0){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public int binarySearch(T[] arr,T target){
        return binarySearch(arr,0,arr.length - 1,target);
    }
    private int binarySearch(T[] arr,int l,int r, T target){
        int mid = l + (r - l) / 2;
        if (l > r){
            return -1;
        }
        if (arr[mid].compareTo(target) == 0){
            return mid;
        }
        if (arr[mid].compareTo(target) > 0){
            return binarySearch(arr,l,mid - 1,target);
        }else {
            return binarySearch(arr,mid + 1,r,target);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{10,30,50,60,80,100,120};
        BinarySearch<Integer> integerBinarySearch = new BinarySearch<>();
        int i = integerBinarySearch.binarySearch(integers, 120);
        System.out.println(i);
    }
}
