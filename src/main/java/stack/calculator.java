package stack;

/*
用栈实现综合计算器
 */
public class calculator {

    public static void main(String[] args){

        String a = "30+2*6-2";
        System.out.println(result(a));
    }

    /**
     * 计算表达式
     */
    public static int result(String expression){
        //存放数字的栈
        ArrayStack numberStack = new ArrayStack(100);
        //存放运算符的栈
        ArrayStack symbolStack = new ArrayStack(100);

        //判断前一位是否为数字
        boolean preIsNumber = false;
        for(int i = 0; i < expression.length(); i++){
            String tmp = expression.substring(i,i+1);
            int priority = getPriority(tmp);
            //若符号为运算符
            if(priority !=0 ){
                //若符号栈为空，则直接入栈并返回
                if(symbolStack.isEmpty()){
                    symbolStack.push(priority);
                    preIsNumber = false;
                    continue;
                }
                //若符号栈非空，则取出栈顶元素与该运算符比较，若栈顶优先级小于该运算符，则将该运算符放入栈顶
                if(priority > symbolStack.firstNum()){
                    symbolStack.push(priority);
                }else {//若栈顶元素优先级大于等于该运算符，将栈顶元素和两个数取出计算将结果存入数据栈，再将该运算符存入运算符栈
                    int tempSymbal = symbolStack.pop();
                    int nextPop = consult(numberStack,tempSymbal);//数据栈弹出两个数据与符号栈弹出的数据进行运算
                    numberStack.push(nextPop);//将运算结果入栈
                    symbolStack.push(priority);//将运算符入栈
                }
                preIsNumber = false;
            }else{
                //若前一位入栈的为数字，则将栈顶数字取出进位再加当前数据后入栈
                if(preIsNumber){
                    int temp = numberStack.pop();
                    numberStack.push(temp * 10 + Integer.parseInt(tmp));
                }else{//若前一位入栈的为运算符，则该数字直接入栈
                    preIsNumber = true;
                    numberStack.push(Integer.valueOf(tmp));//将数据入栈
                }

            }
        }
        while(!symbolStack.isEmpty()){
            int k = consult(numberStack,symbolStack.pop());
            numberStack.push(k);
        }
        return numberStack.pop();
    }

    //传入两个数字和优先级符号，计算结果并返回
    public static int consult(ArrayStack arrayStack, int symbal){
        int secondNum = arrayStack.pop();
        int firstNum = arrayStack.pop();
        if(symbal == 1){
            return firstNum + secondNum;
        }else if(symbal == 2){
            return firstNum - secondNum;
        }else if(symbal == 3){
            return firstNum * secondNum;
        }
        else if(symbal == 4){
            return firstNum / secondNum;
        }
        return 0;
    }

    /**
     * 计算符号优先级，加减优先级返回1,2，乘除优先级返回3,4
     * 若为数字，则返回0
     */
    public static int getPriority(String symbol){
        if(symbol.equals("+")){
            return 1;
        }else if(symbol.equals("-")){
            return 2;
        }else if(symbol.equals("*")){
            return 3;
        }else if(symbol.equals("/")){
            return 4;
        }else{
            return 0;
        }
    }
}
