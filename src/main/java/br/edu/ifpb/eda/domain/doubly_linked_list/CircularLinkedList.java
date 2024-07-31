package br.edu.ifpb.eda.domain.doubly_linked_list;

import br.edu.ifpb.eda.domain.ILinkedList;

public class CircularLinkedList<T> implements ILinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        } else {
            newNode.setNext(this.head);
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > this.size) { return; }

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
                newNode.setNext(newNode);
                newNode.setPrevious(newNode);
            } else {
                newNode.setNext(this.head);
                newNode.setPrevious(this.tail);
                this.tail.setNext(newNode);
                this.head.setPrevious(newNode);
                this.head = newNode;
            }
            this.size++;
            return;
        }

        if (index == this.size) {
            newNode.setNext(this.head);
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.head.setPrevious(newNode);
            this.tail = newNode;
            this.size++;
            return;
        }

        Node<T> currentNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }

        newNode.setNext(currentNode.getNext());
        newNode.setPrevious(currentNode);
        currentNode.getNext().setPrevious(newNode);
        currentNode.setNext(newNode);
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) { return; }

        if (index == 0) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getNext();
                this.tail.setNext(this.head);
                this.head.setPrevious(this.tail);
            }
            this.size--;
            return;
        }

        if (index == this.size - 1) {
            if (this.tail == this.head) {
                this.tail = null;
                this.head = null;
            } else {
                this.tail = this.tail.getPrevious();
                this.tail.setNext(this.head);
                this.head.setPrevious(this.tail);
            }
            this.size--;
            return;
        }

        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        currentNode.getPrevious().setNext(currentNode.getNext());
        currentNode.getNext().setPrevious(currentNode.getPrevious());

        this.size--;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) { return null; }

        int currentIndex = 0;
        Node<T> currentNode = this.head;

        while (currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode.getElement();
    }

    public int getSize() {
        return size;
    }

    private Node<T> getHead() {
        return head;
    }

    private Node<T> getTail() {
        return tail;
    }
}
