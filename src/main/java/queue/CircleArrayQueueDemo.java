package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args){

        System.out.println("测试数组模拟环形队列的案例~~~");


        //创建一个队列
        CircleArray circleArray = new CircleArray(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");

            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
//                case 'h':
//                    try {
//                        int res = circleArray.headQueue();
//                        System.out.printf("取出的头数据是%d",res);
//                    }catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
            System.out.println("程序退出---");
        }

    }
}

class CircleArray{

    private int maxSize; //队列最大容量
    //front含义做一个调整:front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
    //front的初始值=0
    private int front;
    //rear含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
    //rear的初始值=0
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据


    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        int[] arr = new int[maxSize];
        this.arr = arr;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~~~~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear 后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1、先把front对应的值保留到一个临时变量
        //2、将front 后移，考虑取模
        //3、将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列为空，没有数据~~~~");
            return;
        }
        //思路; 从front开始遍历，遍历多少个元素
        for(int i = front; i < front + size(); i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}
