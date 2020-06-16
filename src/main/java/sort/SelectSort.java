package sort;

/**
 * 选择排序
 */
public class SelectSort {


    public static void main(String[] args){
        int[] arry = new int[]{5,4,3,2,1};
        sort(arry);
        prinf(arry);
    }


    /**
     *
     * @param arry
     */
    public static void sort(int[] arry){
       int pose = 0;
       while(pose < arry.length){
           int temp = arry[pose];//值
           int num = pose;//坐标
           for(int i = pose; i < arry.length; i++){
               if(temp > arry[i]){
                   temp = arry[i];
                   num = i;
               }
           }
           arry[num] = arry[pose];
           arry[pose] = temp;
           pose += 1;
       }
    }

    public static void prinf(int[] arry){
        for(int i = 0; i < arry.length; i ++){
            System.out.print(arry[i] + " ");
        }
        System.out.println();
    }
}
