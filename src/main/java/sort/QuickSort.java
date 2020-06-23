package sort;

import java.util.Arrays;

/**
 * 快速排序是对冒泡排序的一种改进。基本思想是：通过一趟排序将要排序的数据分隔成独立的两个部分
 * 其中一个部分的数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left, int right){
        int l = left; //左下标
        int r = right; //右下标
        int pivot = arr[(l + r) / 2];
        int temp;//临时变量，交换时使用

        //while循环的目的是让比pivot值小的放在左边
        //比pivot值大的放在右边
        while(l < r){
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while(arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while(arr[r] > pivot){
                r -= 1;
            }
            //如果l >= r 说明pivot的左右两边的值，已经按照左边全部是小于等于pivot值
            //右边全部是大于等于pivot值
            if(l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--，前移
            if(arr[l] == pivot){
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++，后移
            if(arr[r] == pivot){
                l += 1;
            }
            //如果 l == r,必须l++,r--，否则会出现栈溢出
            if(l == r){
                l += 1;
                r -= 1;
            }
            //向左递归
            if(left < r){
                quickSort(arr,left,r);
            }
            //向右递归
            if(right > l){
                quickSort(arr,l,right);
            }
        }
    }
}
