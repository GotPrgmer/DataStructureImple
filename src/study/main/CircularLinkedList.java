package study.main;

public class CircularLinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    public static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;
        private Node(E item){
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     *  환형 링크드 리스트는 테일 노드와 헤드 사이에 새 노드를 삽입한다.
     *
     * @param data
     */
    public void appendNode(E data){
        /* 노드 추가 */
        //헤드 노드가 없을 경우
        Node<E> newNode = new Node<>(data);
        if(first == null){
            first = newNode;
            first.next = first;
            first.prev = first;
        }
        else{
            last = first.prev;
            last.next.prev = newNode;
            last.next = newNode;

            newNode.next = first;
            newNode.prev = last;
        }
    }
    /**
     * 노드 검색
     *
     * */
    public Node<E> getNodeAt(int idx){
        Node<E> curNode = first;
        while(curNode != null && --idx>=0 ){
            curNode = curNode.next;
        }
        return curNode;
    }
    /**
     * 노드 삭제
     *
     * */
    public void removeNode(int idx){
        Node<E> remove = getNodeAt(idx);
        if(first == remove){
            first.prev.next = remove.next;
            first.next.prev = remove.prev;
            first = remove.next;
            remove.prev = null;
            remove.next = null;
        }
        else{
            Node<E> tmp = remove;
            remove.prev.next = remove.next;
            remove.next.prev = tmp.prev;

            remove.prev = null;
            remove.next = null;
        }
    }

    /**
     * 노드 삽입
     *
     * */

    public void insertAfter(E data, int idx) {
        Node<E> curNode = getNodeAt(idx);
        Node<E> newNode = new Node<>(data);

        newNode.next = curNode.next;
        newNode.prev = curNode;
        if(curNode.next != null){
            curNode.next.prev = newNode;
        }
        curNode.next = newNode;
    }

    /**
     * 노드 개수 세기
     *
     * */
    public int getNodeCount(){
        int cnt = 0;
        Node<E> curNode = first;
        while(curNode != null){
            curNode = curNode.next;
            cnt ++;
            //무한루프 방지
            if(curNode == first){
                break;
            }
        }
        return cnt;
    }
}
