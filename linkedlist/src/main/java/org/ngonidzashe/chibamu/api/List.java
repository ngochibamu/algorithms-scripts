package org.ngonidzashe.chibamu.api;

/**
	An implementation of a simple stack using an array, not a good idea though.
	
	@author Ngonidzashe Chibamu
*/
public interface List<T> {

	
	/**
		adds new data to the beginning of the list
		@param data to be added
	*/
	void addFirst(T data);

	/**
		adds new data to the end of the list
		@param data to be added
	*/
	void addLast(T data);

	/**
		inserts element after a specific element
		@param ref - reference element
		@param data element to be added
	*/
	void addAfter(T ref, T data);

	/**
		inserts element before a specific element
		@param ref reference element
		@param data element to be added
	*/
	void addBefore(T ref, T data);

	/**
		checks if list contains specified element
		@param data element to be looked for
		@return true or false
	*/
	boolean contains(T data);

	/**
		removes all elements fromlist 
	*/
	void clear();

	/**
		removes a specific element from the list
		@param data element to be added
	*/
	void remove(T data);

	/**
		removes first element from the list
		@returns element removed from the list
	*/
	T removeFirst();

	/**
		removes last element from the list
		@return element removed from the list
	*/
	T removeLast();

	/**
		checks if list is empty or not
		@return true if list is empty, otherwise false
	*/
	boolean isEmpty();
}