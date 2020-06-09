package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] atgs){
        //先定义一个逆波兰表达式
        //(3+4)*5-6  => 3 4 + 5 * 6 -
        //4*5-8+60+8/2  => 4 5 * 8 - 60 + 8 2 / +
        //为了方便 数字和符号用空格隔开
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> list = getListString(suffixExpression);
//        System.out.println(list);
//        int rsult = caluclate(list);
//        System.out.println(rsult);

        String temp = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        String temp1 = "4 * 5 - 8 + 60 + 8 / 2";
        String temp2 = "2 * ( 3 + 4 + 5 ) + ( 3 + 4 - 5 ) * 3";
        String temp3 = "2 * ( 3 + ( 1 * 2 - 3 ) + 5 ) + ( 3 + 4 - 5 ) * 3";
        System.out.println(toCorry(temp3));

        System.out.println(caluclate(getListString(toCorry(temp3))));
    }

    //将一个逆波兰表达式转换为一个arrayList
    public static List<String> getListString(String suffixExpression){

        String[] strings = suffixExpression.split(" ");
        List<String> stringList = new ArrayList<String>();
        for (String s : strings){
            stringList.add(s);
        }
        return stringList;
    }

    //完成对逆波兰表达式的计算
    public static int caluclate(List<String> ls){
        //创建栈,只需要一个栈
        Stack<String> stack = new Stack<String>();
        //遍历list
        for(String s : ls){
            //使用正则表达式取出数
            if(s.matches("\\d+")){//匹配的是多位数
                //入栈
                stack.push(s);
            }else{
                //pop出两个数并运算再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(s.equals("+")){
                    res = num1 + num2;
                }else if(s.equals("-")){
                    res = num1 - num2;
                }else if(s.equals("*")){
                    res = num1 * num2;
                }else if(s.equals("/")){
                    res = num1 / num2;
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 将中缀表达式转换为后缀表达式
     * 1 + ( ( 2 + 3 ) * 4 ) - 5   => 1 2 3 + 4 * + 5 -
     *
     * 转换步骤
     * 1、创建两个栈，一个存放中间结果，一个存放运算符
     * 若为数字，则直接进中间结果栈
     * 若为符号：
     *     若为左括号，直接入运算符栈
     *     若为右括号，则运算符栈弹出至遇到左括号
     *     若为运算符
     *          若运算符栈顶元素为左括号，则直接入栈
     *          若运算符栈顶元素优先级比该运算符优先级低，则该运算符直接入栈
     *          若运算符栈顶元素优先级比该运算符优先级高，则栈顶元素出栈后入栈进中间结果，该运算符进栈
     */
    public static String toCorry(String middleExpression){
        String suffixExpression = "";
        Stack<String> resultStack = new Stack<String>();
        Stack<String> symbolStack = new Stack<String>();
        String symbal = "+-*/()";
        //按空格分隔将表达式转换为数组
        String[] middleArray = middleExpression.split(" ");
        for(String temp : middleArray){
            if(symbal.contains(temp)){
                if(temp.equals(")")){
                    resultStack.push(symbolStack.pop());
                    symbolStack.pop();
                }else{
                    if(temp.equals("*") || temp.equals("/")){
                        if(!symbolStack.empty()){
                            String preSymbal = symbolStack.pop();
                            if("()+-".contains(preSymbal)){
                                symbolStack.push(preSymbal);
                                symbolStack.push(temp);
                            }
                        }else{
                            symbolStack.push(temp);
                        }

                    }else if(temp.equals("(")){
                        symbolStack.push(temp);
                    }else{
                        if(!symbolStack.empty()){
                            String preSymbal = symbolStack.pop();
                            if("()".contains(preSymbal)){
                                symbolStack.push(preSymbal);
                                symbolStack.push(temp);
                            }else{
                                resultStack.push(preSymbal);
                                symbolStack.push(temp);
                            }
                        }else{
                            symbolStack.push(temp);
                        }
                    }
                }
            }else{
                resultStack.push(temp);
            }
        }
        while (!symbolStack.empty()){
            resultStack.push(symbolStack.pop());
        }
        while(!resultStack.empty()){
            suffixExpression = resultStack.pop() + " " + suffixExpression;
        }
        return suffixExpression.substring(0,suffixExpression.length() - 1);
    }
}
