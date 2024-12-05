package study.main;

public class CircularLinkedListTest {
    public static void main(String[] args){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for(int i = 0;i<5;i++){
            list.appendNode(i);
        }
        int cnt = list.getNodeCount();
        for(int i = 0;i<cnt;i++){
            System.out.println("List의 노드 데이터 값 : " + list.getNodeAt(i).item);
        }
        list.insertAfter(3000,2);
        cnt = list.getNodeCount();
        CircularLinkedList.Node<Integer> curNode = list.getNodeAt(0);

        for(int i = 0; i<cnt*2;i++){
            if(i == 0) {
                curNode = list.getNodeAt(0);
            }
            else{
                curNode = curNode.next;
            }
            System.out.println("List의 노드 데이터 값 : " + curNode.item);
        }

        System.out.println("모든 노드를 메모리에서 제거");
        cnt = list.getNodeCount();
        for(int i = 0;i<cnt;i++){
            curNode = list.getNodeAt(0);
            if(curNode != null){
                list.removeNode(0);
            }
        }

    }

}
