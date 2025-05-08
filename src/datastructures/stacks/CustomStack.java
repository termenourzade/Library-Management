package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }


    @Override
    public boolean add(Object t) {
        boolean isAdded = list.add(t);
        if (isAdded)
            return true;
        else
            throw new IllegalStateException("Error Adding Element");
    }

    @Override
    public boolean offer(Object t) {
        return this.add(t);
    }

    @Override
    public T remove() {
        return this.poll();
    }

    @Override
    public T poll() {
        T element = list.getLast();
        list.removeLast();
        return element;
    }

    @Override
    public T element() {
        return this.peek();
    }

    @Override
    public T peek() {
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}