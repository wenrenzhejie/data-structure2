package c01_basic_sort;

import java.util.Random;

public class SortHelper {
    public static Integer[] generateArray(int n,int rangeL,int rangeR){
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0;i < n;i++){
            array[i] = random.nextInt(rangeR - rangeL) + rangeL;
        }
        return array;
    }
}
