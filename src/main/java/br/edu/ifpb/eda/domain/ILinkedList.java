package br.edu.ifpb.eda.domain;

import br.edu.ifpb.eda.domain.singly_linked_list.Node;

public interface ILinkedList<T> {
    void add(T element);
    void add(int index, T element);
    void remove(int index);
    Node<T> getNode(int index);
    T getElement(int index);
}
