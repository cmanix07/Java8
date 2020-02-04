package com.rakuten;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 
 * @author chintamani.prasad
 * It demostrate how to use the boxed api for primitive variables.
 *  if you want to convert stream of objects to collection, then you can use one of the static methods in the Collectors class.
 *  //It works perfect !!
	List<String> strings = Stream.of("how", "to", "do", "in", "java").collect(Collectors.toList());
	
	The same process doesnÅft work on streams of primitives, however.

	//Compilation Error !!
	IntStream.of(1,2,3,4,5).collect(Collectors.toList());
 *
 * To work with primitive varibale, it must be boxed with wrapper class.
 */
class BoxedStreamApi{
	
	public void boxedApiUses() {
		//1.  Uses of IntStream
		System.out.println("----- 1. Uses of IntStream wrapped with boxed() ------ ");
		IntStream intStream = IntStream.of(1,2,3,4,5);
		List<Integer> intList = intStream.boxed().collect(Collectors.toList());
		System.out.println(intList);
		//2.  Uses of LongStream
		System.out.println("----- 2. Uses of LongStream wrapped with boxed() ------ ");
	    LongStream longStream = LongStream.of(1l,2l,3l,4l,5l);
	    List<Long> longList = longStream.boxed().collect(Collectors.toList());
	    System.out.println(longList);
	    //3.  Uses of DoubleStream
	    System.out.println("----- 2. Uses of DoubleStream wrapped with boxed() ------ ");
	    List<Double> doubleList = DoubleStream.of(1.1,2.2,3.3,4.4,5.5).boxed().collect(Collectors.toList());
	    System.out.println(doubleList);			    
	}
}

public class BoxedStreamApiExampleTest {

	public static void main(String[] args) {
		BoxedStreamApi boxedStreamApi = new BoxedStreamApi();
		boxedStreamApi.boxedApiUses();
	}

}
