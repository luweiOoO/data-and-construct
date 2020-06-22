package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 把记录按下标的一定增量分组，对每组使用直接插入排序算法排序
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分为一组，算法便终止
 */
public class ShellSort {

    public static void main(String[] args){
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //使用逐步推导的方式来编写希尔排序
    public static void sort(int[] arr){

        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                for(int j = i - gap; j >= 0; j -= gap){
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

    }
}
