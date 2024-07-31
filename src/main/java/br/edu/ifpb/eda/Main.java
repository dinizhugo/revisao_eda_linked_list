package br.edu.ifpb.eda;

import br.edu.ifpb.eda.domain.ILinkedList;
import br.edu.ifpb.eda.domain.doubly_linked_list.CircularLinkedList;
import br.edu.ifpb.eda.domain.singly_linked_list.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================");

        System.out.println("Singly Linked List:");
        ILinkedList<String> lista = new LinkedList<>();
        lista.add("Teste0");
        lista.add("Teste1");
        lista.add("Teste2");
        lista.add(2, "Teste3");
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
        lista.remove(3);
        System.out.println(lista.get(3)); // Deve imprimir null ou lançar uma exceção
        System.out.println("=================");

        System.out.println("Singly Circular Linked List:");
        ILinkedList<String> lista2 = new CircularLinkedList<>();
        lista2.add("teste0");
        lista2.add("teste1");
        lista2.add("teste2");
        lista2.add(2, "teste3");
        System.out.println(lista2.get(0));
        System.out.println(lista2.get(1));
        System.out.println(lista2.get(2));
        System.out.println(lista2.get(3));
        lista2.remove(3);
        System.out.println(lista2.get(3)); // Deve imprimir null ou lançar uma exceção
        lista2.add(0, "teste3");
        System.out.println(lista2.get(0));
        System.out.println("=================");

        System.out.println("Doubly Circular Linked List:");
        ILinkedList<String> lista3 = new CircularLinkedList<>();
        lista3.add("Teste0");
        lista3.add("Teste1");
        lista3.add("Teste2");
        lista3.add(2, "Teste3");
        System.out.println(lista3.get(0));
        System.out.println(lista3.get(1));
        System.out.println(lista3.get(2));
        System.out.println(lista3.get(3));
        lista3.remove(3);
        System.out.println(lista3.get(3)); // Deve imprimir null ou lançar uma exceção
        lista3.add(0, "Teste3");
        System.out.println(lista3.get(0));
        System.out.println("=================");
    }
}
