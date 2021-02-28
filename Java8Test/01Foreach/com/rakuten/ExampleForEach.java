package com.rakuten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
The Java forEach is a utility method to iterate over a collection or stream and perform a certain action on each element of it.

*/
class ForEach4Stream{

	/**
	 * How to iterate using foreach and stream on list
	 */
	public void forEachUsesList() {
		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
		Consumer<Integer> action = System.out::println;
		numberList.stream().forEach(action);
	}

	/**
	 * Method to apply filter and print only even number using stream and foreach @ java1.8
	 */
	public void forEachPrintEven() {
		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
		Consumer<Integer> action = System.out::println;
		numberList.stream().filter(e -> e%2 ==0).forEach(action);
	}
	/**
	 * Foreach uses for Map on based on Entryset, values, keys @java1.8  
	 */
	public void forEachUsesMap() {
		Map<String,Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		
		//1. Using Entry.set
		Consumer<Map.Entry<String, Integer>> action = System.out::println;
		map.entrySet().stream().forEach(action);
		//2. Using Keys
		Consumer<String> actionKeys = System.out::println;
		map.keySet().forEach(actionKeys);
		//3. Using Entry Values
		Consumer<Integer> actionValues = System.out::println;
		map.values().forEach(actionValues);
 	}
	/**
	 * Create custom action based on Consumer Example @ java1.8
	 */
	public void customActionImpExmaple() {
		Map<String,Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Consumer<Map.Entry<String, Integer>> action = entry -> 
		{
			System.out.println("Key is "+entry.getKey());
			System.out.println("Value is "+entry.getValue());
		};
		map.entrySet().forEach(action);
	}
	
	
}

public class ExampleForEach {


	public static void main(String[] args) {
		
		ForEach4Stream forEach4Stream = new ForEach4Stream();
		System.out.println("-----------------forEachPrintEven--------------------");
		forEach4Stream.forEachPrintEven();
		System.out.println("-----------------forEachUsesList--------------------");
		forEach4Stream.forEachUsesList();
		System.out.println("-----------------forEachUsesMap--------------------");
		forEach4Stream.forEachUsesMap();
		System.out.println("-----------------customActionImpExmaple--------------------");
		forEach4Stream.customActionImpExmaple();

	}

}
