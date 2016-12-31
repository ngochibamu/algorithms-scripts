package org.ngonidzashe.chibamu.impl;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


public class SinglyLinkedListTest {

	
	@Test
	public void shouldAddFirstNode(){
		SinglyLinkedList<Node<Integer>> list = new SinglyLinkedList<>();

		Node<Integer> next = new Node(new Integer(11), null);
		Node<Integer> node = new Node(new Integer(10), next);
		list.addFirst(node);
		assertThat(list.size(), is(equalTo(1)));
	}

	@Test
	public void shouldAddLastNode(){
		assertThat(false, is(not(equalTo(false))));
	}

	@Test
	public void shouldRemoveNode(){
		assertThat(false, is(not(equalTo(false))));
	}

	@Test
	public void shouldReturnFirstNode(){
		assertThat(false, is(not(equalTo(false))));
	}

	@Test
	public void shouldReturnLastNode(){
		assertThat(false, is(not(equalTo(false))));
	}
}