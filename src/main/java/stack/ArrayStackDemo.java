package stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args){
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop){
            System.out.println("show : 表示显示栈");
            System.out.println("edit : 退出栈");
            System.out.println("push : 添加数据到栈");
            System.out.println("pop : 弹出栈顶元素");
            System.out.println("请输入你的选择");
            key = scanner.next();
            if ("show".equals(key)) {
                arrayStack.list();

            } else if ("push".equals(key)) {
                System.out.println("请输入一个数");
                int value = scanner.nextInt();
                arrayStack.push(value);

            } else if ("pop".equals(key)) {
                try {
                    int res = arrayStack.pop();
                    System.out.println("取出栈顶数据：" + res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            } else if ("edit".equals(key)) {
                scanner.close();
                loop = false;


            } else {
            }
            System.out.println("程序退出~~~~");

        }
    }
}


//定义一个ArrayStack 表示栈
class ArrayStack{

    private int maxSize; // 栈的大小
    private  int[] stack; //数组，数组模拟栈，数据就放在该数组
    private int top = -1; //top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        if (top == maxSize - 1){
            return true;
        }
        return false;
    }

    //栈空
    public boolean isEmpty(){
        if (top == -1){
            return true;
        }
        return false;
    }

    //入栈 push
    public void push(int value){
        //判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 pop
    public int pop(){
        //判断栈是否空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空,没有数据");
        }
        int result = stack[top];
        top --;
        return result;
    }

    //遍历栈,需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据 ~~~");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >=0; i--){
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}
