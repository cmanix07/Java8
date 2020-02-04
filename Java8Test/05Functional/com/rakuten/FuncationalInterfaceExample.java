/**
 * 
 */
package com.rakuten;

/**
 * @author chintamani.prasad
 * Functional Interface permit exactly one abstract method inside them. 
 * These interfaces are also called Single Abstract Method interfaces (SAM Interfaces)
 * Annotation:@FunctionalInterface only imply that single abstract method allowed into interface otherwise throw compile time error.
 * But, we can add multiple default method or overridden abstract method from parent interface/class.
 */

@FunctionalInterface
public interface FuncationalInterfaceExample {
	
	/**
	 * It is the single abstract method of FuncationalInterfaceExample.class so it is a functional interface.
	 */
	public void firstWorkOfFunctionalInterface();
	
	default void doMywork1() {
		System.out.println("Added the first default method which didn't break the rule of SAM.");
	}
	default void doMywork2() {
		System.out.println("Added the second default method which didn't break the rule of SAM.");
	}
	
	//Overridden the abstract toString method from Object class which also not break rule of functional Interface.
	@Override
	String toString();
	
	//If added another abstract method then functional interface throw compile time error.
	//public void doMyWorkInFunctionalInterfaceError();

}
