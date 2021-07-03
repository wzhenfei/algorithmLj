public class 两个有序链表合并成一个2 {








    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }

        //虚拟一个头结点
        ListNode listNodet = new ListNode();
        //头结点所在的链表当前执行的位置节点
        ListNode listNodec=listNodet;

        while (l1!=null&&l2!=null){
            ListNode listNode=new ListNode();
            if (l1.val>l2.val){
                listNode.val=l2.val;
                listNodec.next=listNode;
                listNodec=listNode;

                //此时l2取了值，链表l2取值的节点去掉不参与今后的比较
                l2=l2.next;
            }else {
                listNode.val=l1.val;
                listNodec.next=listNode;
                listNodec=listNode;

                l1=l1.next;
            }
        }
        //当有链表的剩余值为null时，直接取剩下链表
        listNodec.next=(l1==null)?l2:l1;
        return listNodet.next;

    }






        static class ListNode {
        int val;
        ListNode next = null;
    }
zzzz   dev7.3分支
}