package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }


    @Override
    public boolean add(Object t) {
        boolean isAdded = list.add(t);
        if (isAdded)
            return true;
        else
            throw new IllegalStateException("Eror Adding Element");
    }

    @Override
    public boolean offer(Object t) {
        return  list.add(t);
    }

    @Override
    public T remove() {
        return this.poll();
    }

    @Override
    public T poll() {
        T data = this.peek();
        list.removeFirst();
        return data;
    }

    @Override
    public T element() {
        return this.peek();
    }

    @Override
    public T peek() {
        return list.getFirst();
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