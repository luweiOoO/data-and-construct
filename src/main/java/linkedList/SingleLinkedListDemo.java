package linkedList;


import sun.plugin.javascript.navig4.Link;

public class SingleLinkedListDemo {

    public static void main(String[] args){

        //创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        //加入
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.addByNo(hero1);

        HeroNode heroNode = new HeroNode(4,"小卢","玉麒麟~~~");
        singleLinkedList.update(heroNode);


        singleLinkedList.list();
        System.out.println("单链表节点个数：" + LinkListQuestion.getLength(singleLinkedList.getHead()));

        System.out.println("反向遍历节点");
        LinkListQuestion.reversePrint(singleLinkedList.getHead());

        System.out.println("反转链表");
        LinkListQuestion.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();


        System.out.println("获得第K个节点" + LinkListQuestion.getKNode(singleLinkedList.getHead(),1));
        singleLinkedList.delete(2);
        singleLinkedList.list();

    }
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    //添加节点到单向链表
    public void add(HeroNode node){
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode heroNode){
        HeroNode temp = head;
        while(temp != null){
            if(temp.no == heroNode.no){
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    //删除节点信息
    public void delete(int no){
        HeroNode temp = head;
        while(temp.next != null){
            if(temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //按照编码顺序添加节点到单向链表
    public void addByNo(HeroNode node){
        HeroNode hNode = head;
        if(hNode.next == null){
            hNode.next = node;
            return;
        }
        while(hNode.next != null){
            if(hNode.no < node.no && hNode.next.no > node.no){
                node.next = hNode.next;
                hNode.next = node;
                return;
            }
            if(hNode.no == node.no){
                System.out.println("重复编码，不允许加入");
                return;
            }
            hNode = hNode.next;
        }
        hNode.next = node;
        return;
    }

    //显示链表
    public void list(){
        HeroNode temp = head;
        System.out.println(temp);
        while(temp.next != null){
            temp = temp.next;
            System.out.println(temp);
        }
//        System.out.println(temp);
    }
}

//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    int no;//
    String name;
    String nickName;
    HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int hNo, String name,String nickName){
        this.no = hNo;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return "HeroNode[no = " + no + ",name = " + name + ",nickname = " + nickName;
    }

}
