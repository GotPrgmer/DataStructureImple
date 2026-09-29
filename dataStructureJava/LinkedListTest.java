package study.main;

public class LinkedListTest {
    public static void main(String[] args){
        int count = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("노드 5개 추가");
        for(int i = 0;i<5;i++){
            linkedList.addLast(i);
        }
        linkedList.addFirst(-1);
        linkedList.addFirst(-2);

        System.out.println("리스트 출력");
        count = linkedList.size();
        for(int i=0;i<count;i++){
            System.out.println(linkedList.node(i).item);
        }
        System.out.println("리스트의 세 번째 노드 뒤에 새 노드 삽입");
        linkedList.add(2, 3000);

        System.out.println("리스트 출력");
        count = linkedList.size();
        for(int i = 0;i<count;i++){
            System.out.println(linkedList.node(i).item);
        }
        System.out.println("모든 노드를 메모리에서 제거");
        for(int i=0;i<count;i++){
            if (linkedList.node(0) != null) {
                linkedList.unlink(linkedList.node(i));
            }
        }

    }
}
