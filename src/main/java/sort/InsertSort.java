package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 把n个待排序得元素看成为一个有序表和一个无序表
 * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素
 * 排序过程中每次从无序表中取出第一个元素，把他的排序码依次与有序表元素得排序码进行比较
 * 将它插入到有序表得适当位置，使之成为新的有序表
 */
public class InsertSort {

    // 101，34，119，1
    public static void main(String[] args){
        int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1};
        sort(arr);
    }



    //插入排序
    public static void sort(int[] arry){
        int insertVal,insertIndex;
        for(int i = 1; i < arry.length; i++){
            insertVal = arry[i];
            insertIndex = i-1;
            while(insertIndex >=0 && insertVal < arry[insertIndex]){
                arry[insertIndex + 1] = arry[insertIndex];
                insertIndex--;
            }
            arry[insertIndex + 1] = insertVal;
            System.out.println(Arrays.toString(arry));
        }
    }
}
