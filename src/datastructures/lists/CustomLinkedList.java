package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) {
        if (t == null)
            throw new NullPointerException("Element cannot be null");
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        }else if (size == 1){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail = head.next;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null){
            throw new NullPointerException("Element cannot be null");
        }
        if (head == null) {
            head = tail = new Node<>(t);
        } else if (size == 1) {
            tail = new Node<>(t);
            head.next = tail;
            tail.prev = head;
        } else {
            Node<T> newNode = new Node<>(t);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new NoSuchElementException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0)
            throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i <size; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index)
                break;
            current = current.next;
        }
        try {
            current.data = (T) element;
        }catch (ClassCastException e){
            throw new ClassCastException("invalid input");
        }

        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        try {
            this.addLast((T) o);
            return true;
        }catch (ClassCastException e){
            throw new ClassCastException("invalid input");
        }
    }

    @Override
    public boolean contains(Object o) {
        T data;
        try {
            data = (T) o;
        }catch (ClassCastException e){
            throw new ClassCastException("invalid input");
        }
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        T data;
        try {
            data = (T) o;
        }catch (ClassCastException e){
            throw new ClassCastException("invalid input");
        }
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)){
                try {
                    current.prev.next = current.next;
                }catch (NullPointerException e){
                    head = current.next;
                }
                try {
                    current.next.prev = current.prev;
                }catch (NullPointerException e){
                    tail = current.prev;
                }
                return true;
            }
        }
        return false;

    }


}