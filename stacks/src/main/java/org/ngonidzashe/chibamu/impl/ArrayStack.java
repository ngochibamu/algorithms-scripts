package org.ngonidzashe.chibamu.impl;

import org.ngonidzashe.chibamu.api.Stack;

/**
	Implementation of the array based stack
	@author Ngonidzashe Chibamu
*/
public class ArrayStack<T> implements Stack<T> {

	private int capacity;
	private T[] data;
	private int size = -1;

	public ArrayStack(int capacity){
		this.capacity = capacity;
		data = (T[]) new Object[capacity];
		size = 0;
	}

	public void push(T element){
		if(size == capacity)
			throw new IllegalStateException("Cannot insert into already full stack");

		data[++size] = element;
	}

	public T pop(){
		if(isEmpty())
			return null;

		T value = data[size];
		data[size--] = null;
		return value;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == -1;
	}

	public T top() {
		if(isEmpty())
			return null;
		return data[size];
	}
}