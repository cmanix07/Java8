package com.rakuten;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chintamani.prasad
 *  Method refs are used to point out the methods in java using ::
 *  Static method
 *  instance method
 *  Constructor using new operators 
 *  are used pointed
 */
public class MethodReferenceExample {
	
	
	
	public void showListOfEmp(List<String> empList) {
		empList.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<String> empList = new ArrayList<String>(){
			{add("Chinta");add("mani");add("Prasad");}}; 
			
			MethodReferenceExample methodRefs = new MethodReferenceExample();
			methodRefs.showListOfEmp(empList);
	}

}
