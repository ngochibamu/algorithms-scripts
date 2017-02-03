package org.ngonidzashe.chibamu.impl;
import org.ngonidzashe.chibamu.api.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
	@author Ngonidzashe Chibamu
	Generic implementation of Singly Linked List
*/
public class SinglyLinkedList<T> implements List<T>{

	private final Lock lock = new ReentrantLock();

	class Node<T> {
	
		private T element;
		private Node<T> next;

		public Node(T e, Node<T> n){
			element = e;
			next = n;
		}

		public T getElement(){
			return element;
		}

		public void setElement(T e){
			element = e;
		}

		public Node<T> getNext(){
			return next;
		}

		public void setNext(Node<T> n){
			next = n;
		}

	}

	private Node<T> first = null;
	private Node<T> last = null;
	private int count = 0;

	public void addFirst(T data){

		try{

			lock.lock();

			Node<T> newest = new Node(data, first);
			if(isEmpty())
				last = newest;
			else
				newest.setNext(first);
		
			first = newest;
			count++;

		}finally {
			lock.unlock();
		}

		
	}

	public void addLast(T data){

		try {

			lock.lock();

			Node<T> newest = new Node(data, null);

			if(isEmpty()){
				last = first = newest;
			}else {
				last.setNext(newest);
				last = newest;
			}
			count++;
		}finally {
			lock.unlock();
		}

	}

	public void addBefore(T ref, T data){
		try {

			lock.lock();

			Node<T> current = first;
			if(first.getElement() == ref){
				Node<T> newNode = new Node<T>(data, first);
				first = newNode;
				count++;
				return;
			}
			while(current.getNext() != null){

				if(current.getNext().getElement() == ref){
					Node<T> newNode = new Node<T>(data, current.getNext());
					current.setNext(newNode);
					count++;
					break;
				}else {
					current = current.getNext();
				}
			}

		}finally {

			lock.unlock();
		}
	}

	public void addAfter(T ref, T data){

		try{

			lock.lock();				
			Node<T> current = first;
			while(current != null){

				if(current.getElement() == ref){
					Node<T> newNode = new Node<T>(data, current.getNext());
					current.setNext(newNode);
					count++;
					break;				
				}
				current = current.getNext();
			}
		}finally {
			lock.unlock();
		}
	}


	public boolean contains(T data){
		try{

			lock.lock();

			Node<T> current = first;
			if(isEmpty())
				return false;
			while(current != null){
				if(current.getElement() == data){
					return true;
				}
				current = current.getNext();
			}
			return false;
		}finally {
			lock.unlock();
		}
	}

	public void clear(){
		try{
			lock.lock();
			
			if(isEmpty())
				return;
			Node<T> current = first;
			while(current != null){
				Node<T> nextFirst = current.getNext();
				current.setNext(null);
				current = nextFirst;
			}		
			count = 0;
			first = last = null;
		}finally {
			lock.unlock();
		}
	}

	public void remove(T data){

		
			
			if(isEmpty())
				throw new IllegalStateException("List is empty, operation not allowed");
			try{
				lock.lock();
				Node<T> previous = first;
				Node<T> current = first;
				while(current != null){
					if(current.getElement() == data){
						previous.setNext(current.getNext());
						current = null;
						count--;
						break;
					}
					previous = current;
					current = current.getNext();
				}
			}finally {
				lock.unlock();
			}
	}

	

	public T removeFirst(){
		Node<T> oldFirst = null;

		try {

			lock.lock();
			if(isEmpty())
				throw new IllegalStateException("List is empty, operation not allowed");

			oldFirst = first;
			first = first.getNext();
			oldFirst.setNext(null);
			count--;
		}finally {
			lock.unlock();
		}
		return oldFirst.getElement();

	}
	public T removeLast(){
		Node<T> oldLast = null;
		Node<T> current = first;
		try{

			lock.lock();
			
			if(isEmpty())
				throw new IllegalStateException("List is empty, operation not allowed");

			while(current != null){
				if(current.getNext().getElement() == last.getElement()){
					oldLast = last;
					last = current;
					last.setNext(null);
					count--;
				}
				current = current.getNext();
			}
		}finally {
			lock.unlock();
		}
		return oldLast.getElement();
	}

	public T first(){
		if(isEmpty())
			return null;
		
		return first.getElement();
	}

	public T last() {
		if(isEmpty())
			return null;
		
		return last.getElement();
	}

	public boolean isEmpty(){

		return count() == 0;
	}

	public int count(){
		return count;
	}

	public String toString(){

		Node<T> current = first;
		String list = "[";
		while(current != null){
			list += current.getElement()+", ";
			current = current.getNext();
		}
		list += "]";
		return list;
	}

}