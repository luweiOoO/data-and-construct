package recurion;

import java.net.URLEncoder;

public class Queue8 {

    //先定义一个max，表示共有多少个皇后
    static int max = 8;
    //定义数组array，保存皇后放置位置得结果，比如arr = {0,4,7,5,2,6,1,3}
    static int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args){
        check(0);

        System.out.println("总数量: " + count);
    }

    //编写一个方法，放置第n个皇后
    private static void check(int n){
        if(n == max){ //n=8,其实8个皇后已经放好
            print();
            count += 1;
            return;
        }
        //依次放入皇后，并判断是否冲突
        for(int i = 0; i < max; i++){
            //先把当前这个皇后放在该行第一列
            array[n] = i;
            //判断当前放置皇后为第i列时，是否冲突
            if(judge(n)){//不冲突
                //接着放n+1个皇后
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后，放置在本行得 后移得一个位置
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放得皇后冲突
    /**
     * @param n 表示第n个皇后
     * @return
     */
    private static boolean judge(int n){
        for(int i = 0; i < n; i++){
            //判断第n个皇后是否和前面得皇后在同一列或同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放得位置输出
    private static void print(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
