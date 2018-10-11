package me.zadanie.MyLinkedListZadacha;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head_;
    private static int size;

    public MyLinkedList() {
        this.head_ = null;
        size = 0;
    }

    public void add (T element) {
         if (head_ == null) {
             head_ = new Node<T> (element);
             size++;
         } else {
             Node<T> current_ = head_;
             while (current_.next != null)
             {
                 current_ = current_.next;
             }
             current_.next = new Node<T> (element);
             size++;
         }
    }

    public int getSize() {
        return size;
    }

    public void add(int index, T element) {
        if (index >= size) {
            add(element);
        } else if (index == 0) {
            head_ = new Node<T>(element, head_);
            size++;
        } else {
            Node<T> current_ = head_;
            for (int i = 0; i < index - 1 ; i++)
            {
                current_ = current_.next;
            }
            current_.next = new Node<T> (element, current_.next);
            size++;
        }
    }

    public T get (int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node<T> current_ = head_;
            for (int i = 0; i < index; i++) {
                current_ = current_.next;
            }
            return current_.value;
        }
    }

    public T remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();

        } else {
            if (index == 0) {
                T value = head_.value;
                head_ = head_.next;
                size--;
                return value;
            } else {
                Node<T> current_ = head_;
                for (int i = 0; i < index - 1; i++) {
                    current_ = current_.next;
                }
                Node<T> newNode = current_.next;
                current_.next = newNode.next;
                size--;
                return newNode.value;
            }
        }
    }


    public void print(){

        if (head_ == null) {
            System.out.println("Список пуст");
        } else {
            Node<T> current_ = head_;
            while (current_ != null) {
                System.out.println(current_.value);
                current_ = current_.next;
            }

        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {

            private Node<T> current = head_;

            @Override
            public boolean hasNext() {
                if (current == null) {
                    return false; //add throw
                }
                return true;

            }

            @Override
            public T next() {
                T result = current.value;
                current = current.next;
                return result;
            }
        };
        return iter;
    }

    class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }

        Node(E value, Node<E> node) {
            this.value = value;
            this.next = node;

        }
    }


}
