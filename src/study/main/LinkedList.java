package study.main;

import java.util.*;

public class LinkedList<E> {

    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;

        }
    }

    public Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
    }

    public void addFirst(E e){
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        }
        else{
            f.prev = newNode;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<>(last, e, null);
        last = newNode;
        if(l == null){
            first = newNode;
        }
        else{
            l.next = newNode;
        }
        size++;
    }

    //특정 위치에 추가
    public void add(int index, E e){
        if (index == size){
            addLast(e);
        }
        else{
            Node<E> succ = node(index);
            Node<E> pred = succ.prev;
            Node<E> newNode = new Node<>(pred, e, succ);
            succ.prev = newNode;
            if (pred == null) {
                first = newNode;
            }else{
                pred.next = newNode;
            }
            size++;
        }
    }

    public E unlink(Node<E> x){
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;
        //x의 앞 노드 재설정 후 x의 전 노드 초기화
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        //x뒤 노드 재설정 후 x의 다음노드 초기화
        if(next == null){
            last = prev;
        }
        else{
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }
    public Node<E> node(int index){
        Node<E> x;
        if (index < (size >> 1)){
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else{
            x = last;
            for (int i = size - 1; i> index;i--){
                x = x.prev;
            }
        }
        return x;
    }
    public E removeFirst(){
        if (first == null) throw new NoSuchElementException();
        return unlink(first);
    }
    public E removeLast(){
        if (last==null) throw new NoSuchElementException();
        return unlink(last);
    }

    public boolean contains(E e){
        for (Node<E> x = first; x != null ;x = x.next){
            if(e.equals(x.item)){
                return true;
            }

        }
        return false;

    }
    public int size(){
        return size;
    }


}
