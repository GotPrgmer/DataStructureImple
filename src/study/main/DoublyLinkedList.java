package study.main;

public class DoublyLinkedList<E> {

   public Node<E> first;
   public Node<E> last;

    public static class Node<E>{
        E item;
        Node<E> next;

        Node<E> prev;

        Node(E item){
            this.item = item;
            this.next = null;
            this.prev = null;

        }

    }

    public void appendNode(E data){
        //헤드 노드가 NULL이라면 새로운 노드가 HEAD
        Node<E> newNode = new Node<>(data);
        if(first==null){
            first = newNode;
        }
        else{
            Node<E> tail = first;
            while(tail.next != null){
                tail = tail.next;
            }
        tail.next = newNode;
        newNode.prev = tail;
        }

    }
    public Node<E> getNodeAt(int idx){
        Node<E> cur = first;
        while(cur != null && --idx >=0){
            cur = cur.next;
        }
        return cur;
    }

    public void removeNode(int idx){
        Node<E> remove = getNodeAt(idx);
        if(first == remove){
            first = remove.next;
            if(first!=null){
                first.prev = null;
            }
            remove.prev = null;
            remove.next = null;
        }
        else{
            Node<E> tmp = remove;
            remove.prev.next = tmp.next;
            if(remove.next != null){
                remove.next.prev = tmp.prev;
            }
            remove.prev = null;
            remove.next = null;
        }

    }

    public void insertAfter(E data, int idx) {
        Node<E> curNode = getNodeAt(idx);
        Node<E> newNode = new Node<>(data);

        // 새 노드의 연결 설정
        newNode.prev = curNode;
        newNode.next = curNode.next;

        // 기존 노드와의 연결 갱신
        if (curNode.next != null) {
            curNode.next.prev = newNode;
        }
        curNode.next = newNode;
    }
    public int getNodeCount(){
        int cnt = 0;
        Node<E> cur = first;
        while(cur != null){
            cur = cur.next;
            cnt ++;
        }
        return cnt;
    }



}
