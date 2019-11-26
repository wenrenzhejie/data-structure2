package c01_basic_sort;

import java.util.Arrays;

//冒泡排序
public class BubbleSort<T extends Comparable<T>> {
    public T[] bubbleSort(T[] array){
        for (int i = 1;i < array.length;i++){
            for (int j = 0;j < array.length - 1;j ++){
                if (array[j].compareTo(array[j + 1]) > 0){
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    //冒泡排序的优化版1
    public T[] bubbleSort1(T[] array){
        for (int i = 1;i < array.length;i++){
            //假设这一次冒泡前已经是有序数组
            boolean flag = true;
            for (int j = 0 ;j < array.length - i;j++){
                if (array[j].compareTo(array[j + 1]) > 0){
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return array;
    }
    //冒泡排序的优化版2(每次记录最后一次的交换位置，在此之后的元素下一轮不再考虑，因为最后的元素肯定是最大的)
    public T[] bubbleSort2(T[] array){
        int finalSwap = 0;
        for (int i = 1;i < array.length;i = array.length - finalSwap + 1){
            boolean flag = true;
            for (int j = 0;j < array.length - i;j++){
                if (array[j].compareTo(array[j + 1]) > 0){
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                    finalSwap = j + 1;
                }
            }
            if (flag){
                break;
            }
        }
        return array;
    }

    public static void main(String[] args){
        Integer[] integers = new BubbleSort<Integer>().bubbleSort2(SortHelper.generateArray(50, 0, 1000));
        System.out.println(Arrays.toString(integers));
    }

}
