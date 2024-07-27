package br.edu.ifpb.eda.domain.singly_linked_list;

import br.edu.ifpb.eda.domain.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {
    private int size;
    private Node<T> head;

    public LinkedList(int size) {
        this.size = size;
        this.head = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
            this.size++;
            return;
        }

        Node<T> currentNode = this.head;
        Node<T> previousNode = null;

        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(newNode);
        this.size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > this.size) { return; } //ERROR

        if (index == (this.size - 1)) { add(element); }

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
            this.size++;
            return;
        }

        int currentIndex = 0;
        Node<T> currentNode = this.head;
        Node<T> previousNode = null;

        while (currentIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        previousNode.setNext(newNode);
        newNode.setNext(currentNode);
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > this.size) { return; } //ERROR

        if (index == 0) {
            this.head = this.head.getNext();
            this.size--;
            return;
        }

        int currentIndex = 0;
        Node<T> currentNode = this.head;
        Node<T> previousNode = null;

        while (currentIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        previousNode.setNext(currentNode.getNext());
        this.size--;
    }

    @Override
    public Node<T> getNode(int index) {
        if (index < 0 || index > this.size) { return null; } //ERROR

        Node<T> currentNode = this.head;
        int currentIndex = 0;

        while (currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    @Override
    public T getElement(int index) {
        return getNode(index).getElement();
    }

    public int getSize() {
        return size;
    }


    private Node<T> getHead() {
        return head;
    }

}
