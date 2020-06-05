

public class DoubleLinkedListDemo {

    public static void main(String[] args){
        DoubleHeroNode node1 = new DoubleHeroNode(1,"1号","1号昵称");
        DoubleHeroNode node2 = new DoubleHeroNode(2,"2号","2号昵称");
        DoubleHeroNode node3 = new DoubleHeroNode(3,"3号","3号昵称");
        DoubleHeroNode node4 = new DoubleHeroNode(4,"4号","4号昵称");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByNo(node4);
        doubleLinkedList.addByNo(node3);
        doubleLinkedList.addByNo(node2);
        doubleLinkedList.addByNo(node1);

        doubleLinkedList.list();

    }
}

//创建一个双向链表的类
class DoubleLinkedList{

    //先初始化一个表头节点，头节点不要动，不存放具体数据
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");
    //返回头节点
    public DoubleHeroNode getHead(){
        return head;
    }

    //遍历双向链表
    public void list(){
        DoubleHeroNode heroNode = head.next;
        while(heroNode != null){
            System.out.println(heroNode.toString());
            heroNode = heroNode.next;
        }
    }

    //添加节点
    public void add(DoubleHeroNode doubleHeroNode){
        DoubleHeroNode heroNode = head;
        while (heroNode.next != null){
            heroNode = heroNode.next;
        }
        heroNode.next = doubleHeroNode;
        doubleHeroNode.pre = heroNode;
    }

    //根据编码大小按顺序增加节点
    public void addByNo(DoubleHeroNode doubleHeroNode){
        DoubleHeroNode heroNode = head;
        while (heroNode.next != null){
            if(heroNode.no < doubleHeroNode.no && heroNode.next.no > doubleHeroNode.no){
                doubleHeroNode.pre = heroNode;
                doubleHeroNode.next = heroNode.next;
                heroNode.next.pre = doubleHeroNode;
                heroNode.next = doubleHeroNode;
                return;
            }
            heroNode = heroNode.next;
        }
        heroNode.next = doubleHeroNode;
//        doubleHeroNode.pre = heroNode;
        return;

    }

    //修改一个节点的信息
    public void update(DoubleHeroNode doubleHeroNode){
        DoubleHeroNode heroNode = head.next;
        boolean isUpdate = false;
        while(heroNode != null){
            if(heroNode.no == doubleHeroNode.no){
                heroNode.name = doubleHeroNode.name;
                heroNode.nickName = doubleHeroNode.nickName;
                isUpdate = true;
                System.out.println("双向链表节点信息修改成功");
                break;
            }
            heroNode = heroNode.next;
        }
        if(!isUpdate){
            System.out.println("没有找到所要修改的节点信息");
        }
    }

    //从双向链表中删除节点信息
    public void delete(int no){

        DoubleHeroNode heroNode = head.next;
        boolean isDelete = false;
        while(heroNode != null){
            if(heroNode.no == no){
                heroNode.pre.next = heroNode.next;
                //若不是最后一个节点，则执行
                if(heroNode.next != null){
                    heroNode.next.pre = heroNode.pre;
                }
                isDelete = true;
                System.out.println("删除节点成功");
                break;
            }
            heroNode = heroNode.next;
        }
        if(!isDelete){
            System.out.println("没有找到要删除的节点信息");
        }

    }
}


//创建一个双向链表的类
class DoubleHeroNode{

    int no;
    String name;
    String nickName;
    DoubleHeroNode next;//指向后一个节点
    DoubleHeroNode pre;//指向前一个节点
    //构造器
    public DoubleHeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return "DoubleHeroNode [no=" + no + "name= " + name + "nickName=" + nickName;
    }
}
