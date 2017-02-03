package org.ngonidzashe.chibamu.impl;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class SinglyLinkedListTest {

	static String addisAbaba = new String("Addis Ababa");
	static String nairobi = new String("Nairobi");
	static String kamplala = new String("kamplala");
	static String dodoma = new String("Dodoma");
	static String lusaka = new String("Lusaka");
	static String harare = new String("Harare");
	static String pretoria = new String("Pretoria");
	static String joburg = new String("Joburg");
	
	
	@Test
	public void shouldAddFirstTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		int currentSize = towns.count();
		assertThat(towns.first(), is(nullValue()));
		assertThat(towns.last(), is(nullValue()));
		towns.addFirst(joburg);
		assertThat(towns.count(), is(equalTo(currentSize + 1)));
		assertThat(towns.first(), is(equalTo(joburg)));
		assertThat(towns.last(), is(equalTo(joburg)));
	}
	
	

	@Test
	public void shouldAddLastTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		int currentSize = towns.count();
		assertThat(towns.first(), is(nullValue()));
		assertThat(towns.last(), is(nullValue()));
		towns.addLast(harare);
		assertThat(towns.count(), is(equalTo(currentSize + 1)));
		assertThat(towns.last(), is(equalTo(harare)));
		towns.addLast(dodoma);
		assertThat(towns.last(), is(not(equalTo(harare))));
	}

	@Test
	public void shouldAddAfterTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.addFirst(kamplala);
		towns.addFirst(harare);
		towns.addFirst(joburg);
		towns.addFirst(dodoma);
		towns.addFirst(pretoria);
		int currentSize = towns.count();
		towns.addAfter(joburg, new String("Maputo"));
		assertThat(towns.count(), is(equalTo(currentSize + 1)));
	}

	@Test
	public void shouldAddBeforeTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.addFirst(kamplala);
		towns.addFirst(harare);
		towns.addFirst(joburg);
		towns.addFirst(dodoma);
		towns.addFirst(pretoria);
		int currentSize = towns.count();
		towns.addBefore(pretoria, addisAbaba);
		assertThat(towns.first(), is(equalTo(addisAbaba)));
		assertThat(towns.count(), is(equalTo(currentSize + 1)));

	}

	

	@Test
	public void shouldRemoveTest(){
		SinglyLinkedList<Character> towns = new SinglyLinkedList<>();
		towns.addFirst('G');
		towns.addFirst('F');
		towns.addFirst('D');
		towns.addFirst('C');
		towns.addFirst('B');
		towns.addFirst('A');
		int currentSize = towns.count();
		towns.addAfter('D','E');
		assertThat(towns.count(), is(equalTo(currentSize + 1)));
		assertThat(towns.last(), is(equalTo('G')));
		towns.remove('E');
		assertThat(towns.count(), is(equalTo(currentSize)));
	}

	@Test
	public void shouldRemoveFirstTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.addFirst(nairobi);
		towns.addLast(dodoma);
		assertThat(towns.last(), is(equalTo(dodoma)));
		assertThat(towns.first(), is(equalTo(nairobi)));
		String removedTown = towns.removeFirst();
		assertThat(removedTown,is(equalTo(nairobi)));
		assertThat(towns.count(), is(equalTo(1)));
	}

	@Test
	public void shouldRemoveLastTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.addFirst(pretoria);
		towns.addFirst(harare);
		towns.addAfter(harare, nairobi);
		assertThat(towns.count(), is(equalTo(3)));
		String lastTown = towns.removeLast();
		assertThat(lastTown,is(equalTo(pretoria)));
		assertThat(towns.count(), is(equalTo(2)));
	}

	@Test
	public void shouldClearListTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.addFirst(kamplala);
		towns.addFirst(harare);
		towns.addFirst(joburg);
		towns.addFirst(dodoma);
		towns.addFirst(pretoria);
		towns.addLast(new String("Lilongwe"));
		int size = towns.count();
		assertThat(size, is(equalTo(6)));
		towns.clear();
		int newSize = towns.count();
		assertThat(size, is(not(equalTo(newSize))));
		assertThat(towns.count(), is(equalTo(0)));
		assertThat(towns.isEmpty(), is(equalTo(true)));

	}
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionRemoveFirstOnEmptyListTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.removeFirst();		
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionRemoveLastOnEmptyListTest (){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.removeLast();
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionRemoveOnEmptyListTest(){
		SinglyLinkedList<String> towns = new SinglyLinkedList<>();
		towns.remove(null);
	}
}