package study.main;

public class DoublyLinkedListTest {
    public static void main(String[] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for(int i = 0;i<5;i++){
            list.appendNode(i);
        }
        int cnt = 0;
        cnt = list.getNodeCount();
        for(int i =0; i<cnt;i++){
            DoublyLinkedList.Node<Integer> curNode = list.getNodeAt(i);
            System.out.println("List : " + i + "번째 노드 " + curNode.item);
        }
        list.insertAfter(3000,2);
        cnt = list.getNodeCount();
        System.out.println(cnt);
        for(int i = 0;i<cnt;i++){
            DoublyLinkedList.Node<Integer> curNode = list.getNodeAt(i);
            System.out.println("List : " + i + "번째 노드 " + curNode.item);
        }

        cnt = list.getNodeCount();
        for(int i = 0; i<cnt;i++){
            DoublyLinkedList.Node<Integer> curNode = list.getNodeAt(0);
            if(curNode != null){
                list.removeNode(0);
            }

        }
    }
}
