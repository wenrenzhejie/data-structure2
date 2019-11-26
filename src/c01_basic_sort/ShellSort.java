package c01_basic_sort;

import java.util.Arrays;

//希尔排序
public class ShellSort<T extends Comparable<T>> {
    public void shellSort(T[] array){
        for (int gap = array.length / 2;gap > 0;gap /= 2){
            for (int i = 0;i < gap;i++){
                insectSort(array,i,gap);
            }
        }
    }
    private void insectSort(T[] array,int begin,int gap){
        for (int i = begin + gap;i < array.length;i += gap){
            T temp = array[i];
            int k = i;
            for (int j = i;j >= gap;j -= gap){
                if (array[j - gap].compareTo(temp) > 0){
                    array[j] = array[j - gap];
                    k = j - gap;
                }else {
                    break;
                }
            }
            array[k] = temp;
        }
    }

    public static void main(String[] args){
        Integer[] integers = SortHelper.generateArray(50, 0, 1000);
        new ShellSort<Integer>().shellSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
