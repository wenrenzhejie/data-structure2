package c03_heap;

import com.sun.org.apache.regexp.internal.RE;

import javax.activation.MailcapCommandMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MaxHeap<T extends Comparable> {
    private T[] data;
    private int size;
    public MaxHeap(){
        this(100);
    }
    public MaxHeap(int capacity){
        data = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }
    public MaxHeap(T[] arr,int n){
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
        shiftUp(this.size);
    }
    private void shiftUp(int eleIndex) {
        int i = eleIndex;
        while (parent(i) >= 1){
            if (data[i].compareTo(data[parent(i)]) > 0){
                swap(this.data,i,parent(i));
                i = parent(i);
            }else {
                break;
            }
        }
    }
    //取出一个元素
    public T extractMax(){
        T max = this.data[1];
        swap(this.data,1,this.size);
        this.size --;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int index) {
        int i = index;
        while (leftChild(i) <= this.size){
            int j = leftChild(i);
            if (rightChild(i) <= this.size && this.data[rightChild(i)].compareTo(this.data[j]) > 0){
                j = rightChild(i);
            }
            if (this.data[i].compareTo(this.data[j]) < 0){
                swap(this.data,i,j);
                i = j;
            }else {
                break;
            }
        }
    }

    private void swap(T[] arr,int i,int j){
        T temp = arr[i];
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
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        System.out.println(maxHeap.getSize());
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        Integer[] integer = new Integer[]{60, 61, 4, 33, 86, 31, 10, 63, 82, 84};
        for (int i = 0;i < 10;i++){
//            int nextInt = random.nextInt(100);
//            list.add(nextInt);
            maxHeap.insert(integer[i]);
        }
        System.out.println(list.toString());
        System.out.println(Arrays.toString(maxHeap.data));
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.extractMax());
        }
    }


}
