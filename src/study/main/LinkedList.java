package study.main;

import java.util.*;

public class LinkedList<E> {

    public static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
            this.next = null;

        }
    }

    public Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = first;
        first = newNode;

        if(first.next == null){
            last = first;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(size == 0){
            addFirst(e);
            return;
        }
        last.next = newNode;
        last = newNode;
        size++;

    }

    //특정 위치에 추가
    public void add(int index, E e){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(e);
            return;
        }
        if(index == size){
            addLast(e);
            return;
        }
        Node<E> prevNode = node(index-1);

        Node<E> nextNode = prevNode.next;

        Node<E> newNode = new Node<E>(e);
        prevNode.next = null;
        prevNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    public boolean unlink(Object value){
        Node<E> prevNode = first;
        boolean hasValue = false;
        Node<E> x = first;

        for(; x!= null;x = x.next){
            if(value.equals(x.item)){
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        if( x == null){
            return false;
        }
        if(x.equals(first)){
            remove();
            return true;
        }
        else{
            prevNode.next = x.next;
            if(prevNode.next == null){
                first = prevNode;
            }
            x.item = null;
            x.next = null;
            size--;
            return true;
        }
    }
    public Node<E> node(int index){
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = first;
        for(int i = 0; i< index;i++){
            x = x.next;
        }
        return x;
    }

    public E remove(){
        Node<E> firstNode = first;
        if(firstNode == null) {
            throw new NoSuchElementException();
        }


        E element = firstNode.item;
        Node<E> nextNode = first.next;
        first.item = null;
        first.next = null;
        first = nextNode;
        size--;
        if(size == 0){
            last = null;
        }
        return element;

    }
    public int size(){
        return size;
    }


}
