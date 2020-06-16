package sort;

import java.util.List;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] arry = new int[]{5,4,3,2,1};
        print(arry);
        sort(arry);
        print(arry);
    }

    public static void sort(int[] arry){
        boolean flag = true;
        int count = arry.length;
        while (flag){
            flag = false;
            for(int i = 1; i < count; i++){
                if(arry[i - 1] > arry[i]){
                    int temp = arry[i];
                    arry[i] = arry[i-1];
                    arry[i-1] = temp;
                    flag = true;
                }
            }
            count -= 1;
        }
    }

    public static void print(int[] arry){
        for(int i = 0; i < arry.length; i++){
            System.out.print(arry[i] + " ");
        }
        System.out.println();
    }
}
