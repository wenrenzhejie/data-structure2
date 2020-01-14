package c03_heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class IndexMaxHeap<T extends Comparable> {
    private T[] data;
    private int[] indexs;
    private int size;
    public IndexMaxHeap(){
        this(100);
    }
    public IndexMaxHeap(int capacity){
        data = (T[]) new Comparable[capacity + 1];
        indexs = new int[capacity + 1];
        this.size = 0;
    }
    public IndexMaxHeap(T[] arr, int n){
        this.data = (T[]) new Comparable[n + 1];
        this.size = n;
        for (int i = 0;i < n ;i++){
            data[i + 1] = arr[i];
        }
        for (int i = parent(this.size);i >= 1;i--){
            shiftDown(i);
        }

    }
    //添加一个元素
    public void insert(T ele){
        this.size ++;
        this.data[this.size] = ele;
        this.indexs[this.size] = this.size;
        shiftUp(this.size);
    }
    private void shiftUp(int eleIndex) {
        int i = eleIndex;
        while (parent(i) >= 1){
            if (this.data[this.indexs[i]].compareTo(this.data[this.indexs[parent(i)]]) > 0){
                swap(this.indexs,i,parent(i));
                i = parent(i);
            }else {
                break;
            }
        }
    }
    //取出一个元素
    public T extractMax(){
        T max = this.data[this.indexs[1]];
        swap(this.indexs,1,this.size);
        this.size --;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int index) {
        int i = index;
        while (leftChild(i) <= this.size){
            int j = leftChild(i);
            if (rightChild(i) <= this.size && this.data[this.indexs[rightChild(i)]].compareTo(this.data[this.indexs[j]]) > 0){
                j = rightChild(i);
            }
            if (this.data[this.indexs[i]].compareTo(this.data[this.indexs[j]]) < 0){
                swap(this.indexs,i,j);
                i = j;
            }else {
                break;
            }
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int leftChild(int i){
        return 2 * i;
    }
    private int rightChild(int i){
        return 2 * i + 1;
    }
    private int parent(int i){
        return i / 2;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    public static void main(String[] args){
        IndexMaxHeap<Integer> maxHeap = new IndexMaxHeap<>();
//        System.out.println(maxHeap.getSize());
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0;i < 10;i++){
            int nextInt = random.nextInt(100);
            list.add(nextInt);
            maxHeap.insert(nextInt);
        }
        System.out.println(list.toString());
        System.out.println(Arrays.toString(maxHeap.data));
        System.out.println(Arrays.toString(maxHeap.indexs));
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.extractMax());
        }
    }


}
