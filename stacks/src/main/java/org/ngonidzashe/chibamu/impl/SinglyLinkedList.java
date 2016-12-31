package org.ngonidzashe.chibamu.impl;

import org.ngonidzashe.chibamu.impl.Node;

/**
	Generic implementation of Singly Linked List
*/
public class SinglyLinkedList<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;

	public void addFirst(T data){

		Node<T> newest = new Node(data, head);
		if(size() == 0){
			
			head = newest;
			tail = newest;
		}else {
			newest.setNext(head);
			head = newest;
		}
		size++;
	}

	public void addLast(Node<T> node){

	}

	public boolean isEmpty(){
		return false;
	}

	public void removeFirst(){

	}

	public T first(){
		return null;
	}

	public T last() {
		return null;
	}

	public int size(){
		return size;
	}

}