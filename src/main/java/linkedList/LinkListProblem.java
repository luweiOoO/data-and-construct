package linkedList;

import java.util.Stack;

public class LinkListProblem {

}

class LinkListQuestion{

    //计算链表中有效节点的个数
    public static int getLength(HeroNode heroNode){
        if(heroNode.next == null){
            return 0;//空链表
        }
        int length = 0;
        while(heroNode.next != null){
            length += 1;
            heroNode = heroNode.next;
        }

        return length;
    }

    //查询单链表中倒数第K个节点
    public static HeroNode getKNode(HeroNode head, int index){
        int length = getLength(head);
        HeroNode node = head.next;
        int count = 0;
        while(node != null){
            if(count == (length - index)){
                break;
            }
            count += 1;
            node = node.next;
        }
        return node;
    }


    //单链表反转
    public static void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }

        //定义一个辅助的指针(变量),帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//定义当前节点[cur]的下一个节点
        HeroNode reverHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while(cur != null){
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverHead.next;//将cur的下一个节点指向新的链表的最前端
            reverHead.next = cur;//将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向reverseHead.next,实现单链表的反转
        head.next = reverHead.next;
    }

    //从尾到头打印单链表(要求方式1、反向遍历。方式2：stack栈)
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;//空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        //将栈中的节点进行打印
        while(stack.size() > 0){
            System.out.println("取出栈中数据:  " + stack.pop());
        }
    }


    //合并两个有序的单链表，合并之后的链表依然有序
    public void addLinkList(HeroNode oneNode,HeroNode twoNode){

    }
}
