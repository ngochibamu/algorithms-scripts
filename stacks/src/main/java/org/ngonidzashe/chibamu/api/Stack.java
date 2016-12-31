package org.ngonidzashe.chibamu.api;

/**
	An implementation of a simple stack using an array, not a good idea though.
	
	@author Ngonidzashe Chibamu
*/
public interface Stack<T> {

	/**
		Push/insert element at the top of stack
		@param e the last element to be inserted
	*/

	void push(T element);


	/**
		Remove last element inserted from the top of the stack
		@return the element removed from the top of the stack
	*/

	T pop();

	/**
		Returns the element at the top of the stack, but does not remove it
		@return element on top of the stack
	*/
	T top();

	/**
		Returns the size of the stack
		@returns size of the stack
	*/
     int size();

     /**
		checks if the stack is empty or not.
		@return true or false
     */
    boolean isEmpty();
}