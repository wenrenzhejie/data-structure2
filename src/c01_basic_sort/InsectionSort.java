package c01_basic_sort;

import java.util.Arrays;
import java.util.TreeMap;

//插入排序(后面的元素与其前面的元素相比),对有序的数组插入排序的算法效率很高
public class InsectionSort<T extends Comparable<T>> {
    public T[] insectSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }
    //插入排序的改进版本(减少交换的次数)
    public T[] insectSort2(T[] array){
        for (int i = 1;i < array.length;i++){
            T temp = array[i];
            for (int j = i - 1;j >= 0;j --){
                if (array[j].compareTo(temp) > 0){
                    array[j + 1] = array[j];
                    if (j == 0){
                        array[0] = temp;
                    }
                }else {
                    array[j + 1] = temp;
                    break;
                }
            }
        }
        return array;
    }
    //对insectSort2代码思想的更好的代码写法
    public T[] insectSort3(T[] array){
        for (int i = 1;i < array.length;i ++){
            T temp = array[i];
            //k用来保存array[i]应该保存的位置
            int k = i;
            for (int j = i;j > 0;j--){
                if (array[j - 1].compareTo(temp) > 0){
                    array[j] = array[j - 1];
                    k = j-1;
                }else {
                    break;
                }
            }
            array[k] = array[i];
        }
        return array;
    }
    public static void main(String[] args){
        Integer[] integers = new InsectionSort<Integer>().insectSort2(SortHelper.generateArray(50, 0, 100));
        System.out.println(integers.length);
        System.out.println(Arrays.toString(integers));
    }
}
