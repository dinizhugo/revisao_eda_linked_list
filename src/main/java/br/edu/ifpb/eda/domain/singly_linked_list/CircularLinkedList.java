package br.edu.ifpb.eda.domain.singly_linked_list;

import br.edu.ifpb.eda.domain.ILinkedList;

public class CircularLinkedList<T> implements ILinkedList<T> {

    private int size;
    private Node<T> head;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
            newNode.setNext(this.head);
            this.size++;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.getNext() != this.head) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
        newNode.setNext(this.head);
        this.size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= this.size) { return; } // error

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            if (this.head == null) {
                this.head = newNode;
                newNode.setNext(this.head);
            }else {
                newNode.setNext(this.head);
                this.head = newNode;
            }
        } else {
            Node<T> currentNode = this.head;
            int currentIndex = 0;

            while (currentIndex != index - 1) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) { return; } // error

        if (index == 0) {
            this.head = this.head.getNext();
        } else {
            Node<T> currentNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            currentNode.getNext().setNext(null);
        }
        this.size--;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) { return null; } // error

        Node<T> currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getElement();
    }


    public int getSize() {
        return size;
    }

    private Node<T> getHead() {
        return head;
    }
}
