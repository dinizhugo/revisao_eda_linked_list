package br.edu.ifpb.eda.domain.doubly_linked_list;

import br.edu.ifpb.eda.domain.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
        }
        this.tail = newNode;
        this.size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > this.size) { return; } // error

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.setNext(this.head);
                this.head.setPrevious(newNode);
                this.head = newNode;
            }
            this.size++;
            return;
        }

        if (index == (this.size)) {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
            this.tail = newNode;
            this.size++;
            return;
        }

        int currentIndex = 0;
        Node<T> currentNode = this.head;

        while (currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        newNode.setNext(currentNode);
        newNode.setPrevious(currentNode.getPrevious());
        currentNode.getPrevious().setNext(newNode);
        currentNode.setPrevious(newNode);
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) { return; } // error

        if (index == 0) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getNext();
                if (this.head != null) {
                    this.head.setPrevious(null);
                }
            }
            this.size--;
            return;
        }

        if (index == (this.size - 1)) {
            this.tail = this.tail.getPrevious();
            if (this.tail != null) {
                this.tail.setNext(null);
            }
            this.size--;
            return;
        }

        int currentIndex = 0;
        Node<T> currentNode = this.head;

        while (currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        currentNode.getPrevious().
                setNext(currentNode.getNext());
        currentNode.getNext().
                setPrevious(currentNode.getPrevious());
        this.size--;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) { return null; } // error

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
