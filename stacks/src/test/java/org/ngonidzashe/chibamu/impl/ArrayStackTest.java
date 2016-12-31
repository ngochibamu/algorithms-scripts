package org.ngonidzashe.chibamu.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.ngonidzashe.chibamu.api.Stack;


public class ArrayStackTest {
	
	

	@Before
	public void before() {
	}	

	@Test
	public void shouldShowStackHasSizeMoreThanOne(){
		Stack<Integer> stack = new ArrayStack<>(10);
		assertEquals(0, stack.size());
		stack.push(new Integer(5));
		assertEquals(1, stack.size());
	}

	@Test
	public void shouldRemovelastElementFromSTack(){
		Stack<String> stack = new ArrayStack<>(10);
		String name = new String("ngonidzashe");
		String lastName = new String("Chibamu");
		String middleName = new String("Dominic");
		stack.push(name);
		stack.push(lastName);
		stack.push(middleName);
		assertEquals(3, stack.size());

		String lastItem = stack.pop();
		assertEquals(middleName, lastItem);
		assertEquals(2, stack.size());

	}

	@Test
	public void shouldShowNoChangeInStackSize(){
		Stack<Long> stack = new ArrayStack<>(10);
		stack.push(20L);
		assertFalse(stack.isEmpty());
		long item = stack.top();
		assertEquals(20, item);
		assertFalse(stack.isEmpty());

	}

}