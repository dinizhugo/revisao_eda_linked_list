package br.edu.ifpb.eda.domain;

public interface ILinkedList<T> {
    void add(T element);
    void add(int index, T element);
    void remove(int index);
    T get(int index);
}
