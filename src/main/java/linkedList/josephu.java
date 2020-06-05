package linkedList;

import com.sun.deploy.perf.PerfRollup;

import java.util.LinkedList;
import java.util.List;

public class josephu {
    /**
     * 编号为1，2，.。。n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数
     * 数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，以此类推，直到所有人出列为止
     * 由此产生一个出队的编号的序号
     */
    public static void main(String[] args){
        PersonNodeList personNodeList = new PersonNodeList(10);
        personNodeList.list();
        List<Integer> a = josephuIdea(8,3,4);
        System.out.println("答案: " + a);
    }
    /**
     *
     * @param personNum 总人数
     * @param kPoint 从编号为kPoint的人开始报数
     * @param member 间隔member个人
     * @return
     */
    public static  List<Integer> josephuIdea(int personNum,int kPoint,int member){

        //出队列的人编码顺序
        List<Integer> result = new LinkedList<Integer>();
        //初始化循环链表
        PersonNodeList personNodeList = new PersonNodeList(personNum);
        //第一次出列的人编码
        int firstNo = (kPoint + member - 1) > personNum ?  (kPoint + member - 1) % personNum : (kPoint + member - 1);
        while(personNodeList.getFirstNode().next != null){
            PersonNodeList.PersonNode cur = personNodeList.getFirstNode();
            while(firstNo - 1 > 0){
                cur = cur.next;
                firstNo -= 1;
            }
            personNodeList.setFirstNode(cur.next);
            int no = PersonNodeList.delete(cur);
            firstNo = member;
            result.add(no);
            if(personNodeList.getFirstNode().next.no == personNodeList.getFirstNode().no){
                result.add(personNodeList.getFirstNode().no);
                break;
            }
        }
        return result;
    }
}
//循环链表
class PersonNodeList{
    private static PersonNode firstNode;
    //获取第一个节点
    public PersonNode getFirstNode(){
        return firstNode;
    }
    //给第一个节点赋值
    public void setFirstNode(PersonNode personNode){
        this.firstNode = personNode;
    }
    //创建一个有n个节点的循环链表的构造器
    public PersonNodeList(int n){
        for(int i = 1; i <= n; i++){
            if(i == 1){
                this.firstNode = new PersonNode(i);
            }else{
                add(new PersonNode(i));
            }
            //将链表首尾相连组成循环链表
            if(i == n){
                PersonNode cur = firstNode;
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next = firstNode;
            }
        }
    }
    //添加节点
    public static void add(PersonNode personNode){

        PersonNode cur = firstNode;
        while(cur.next != null && cur.next.no != firstNode.no){
            cur = cur.next;
        }
        cur.next = personNode;
    }
    //删除节点，并返回被删除的no
    public static int delete(PersonNode personNode){
        PersonNode cur = firstNode;
        if(cur.no == personNode.no){
            PersonNode temp = firstNode;
            //找到末尾节点
            while(temp.next.no != firstNode.no){
                temp = temp.next;
            }
            //将末尾节点的next指向第二位
            temp.next = firstNode.next;
            //将第二位变为第一位
            firstNode = cur.next;
            return personNode.no;
        }
        //找到被删除节点的前一个节点的位置
        while (cur.next.no != personNode.no){
            cur = cur.next;
        }
        //将被删除节点的前一个节点的next指向被删除节点的next
        cur.next = cur.next.next;
        return personNode.no;
    }
    //遍历节点
    public void list(){
        PersonNode cur = firstNode;
        while(cur.next != null){
            System.out.println(cur.toString());
            //到了尾部，终止遍历，否则一直循环
            if(cur.next.no == firstNode.no){
                break;
            }
            cur = cur.next;
        }
    }
    //结点
    class PersonNode{
        int no;
        PersonNode next;//下一个结点

        //构造器
        public PersonNode(int on){
            this.no = on;
        }
        @Override
        public String toString(){
            return "PersonNode : { no = " + no;
        }
    }

}
