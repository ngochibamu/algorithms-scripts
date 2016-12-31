package org.ngonidzashe.chibamu.impl;

import org.ngonidzashe.chibamu.api.Stack;

/**
	Implementation of the array based stack
	@author Ngonidzashe Chibamu
*/
public class ArrayStack<T> implements Stack<T> {

	private int capacity;
	private T[] data;
	private int index = -1;

	public ArrayStack(int capacity){
		this.capacity = capacity;
		data = (T[]) new Object[capacity];
		index = 0;
	}

	public void push(T element){
		if(index == capacity)
			throw new IllegalStateException("Cannot insert into already full stack");

		data[++index] = element;
	}

	public T pop(){
		if(isEmpty())
			return null;

		T value = data[index];
		data[index--] = null;
		return value;
	}

	public int size(){
		return index;
	}

	public boolean isEmpty(){
		return index == -1;
	}

	public T top() {
		if(isEmpty())
			return null;
		return data[index];
	}
}