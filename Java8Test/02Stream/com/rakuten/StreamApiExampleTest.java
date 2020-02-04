package com.rakuten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chintamani.prasad
 * Uses of basic method of stream API @ Java1.8
 * A Stream in Java can be defined as a sequence of elements from a source that supports aggregate operations on them.
 * Sources of data in stream collecation & Array
 * A Stream is a conceptually fixed data structure, in which elements are computed on demand.
 *
 */
class StreamApiUses{
	
	/**
	 * Different ways to create a stream
	 */
	public void buildStreams() {
		//Using Stream.of(val1, val2, val3Åc.)
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		System.out.println("1: -----------elebration of StreamBuilder using Stream.of(values)---------- ");
		stream.forEach(e -> System.out.println(e));
		//Using Stream.of(arrayElements)
		stream = Stream.of(new Integer[]{1,2,3,4,5,6});
		System.out.println("2: -----------elebration of StreamBuilder using Stream.of(arrays)---------- ");
		stream.forEach(e -> System.out.println(e));
		//Using List.stream
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		System.out.println("3: -----------elebration of StreamBuilder using list.stream()---------- ");
		list.stream().forEach(e -> System.out.println(e));
		//Using Stream.generate & Stream.iterate
		Stream<Date> dateStream = Stream.generate(() -> {return new Date();});
		System.out.println("4: -----------elebration of StreamBuilder using Stream.generate & Stream.iterate---------- ");
		dateStream.distinct().limit(1).forEach(p -> System.out.println(p));

		//Using String char or token
		System.out.println("5: -----------elebration of StreamBuilder using char or token---------- ");
		IntStream intStream = "12345_abcdef".chars();
		intStream.forEach(p->System.err.println(p));
		//or
		Stream<String> tokenStream = Stream.of("ab$c$c$d".split("\\$"));
		tokenStream.forEach(p->System.out.println(p));
	}
	/**
	 * Demonstration of conversion of stream to collections
	 */
	public void convertStream2Collections() {
		//1. Convert Stream to List :: Stream.collect( Collectors.toList() )
		System.out.println("1: ----- Convert Stream to List :: Stream.collect( Collectors.toList() ) -----");
		List<Integer>list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Stream<Integer> stream = list.stream();
		List<Integer> evenNumList = stream.filter(p->p%2==0).collect(Collectors.toList());
		System.out.println(" "+evenNumList);
		//2. Convert Stream to Array :: Stream.toArray(EntryType[]::new )
		Stream<Integer> intArrStream = list.stream();
		System.out.println("1: ----- 2. Convert Stream to Array :: Stream.toArray(EntryType[]::new ) -----");
		Integer[] intArray = intArrStream.filter(p->p%2==0).toArray(Integer[]::new);
		System.out.println(intArray);
		Stream.of(intArray).forEach(p->System.out.println(p));
	}
	
	/**
	 * Core operation on streams - intermediate operation & Terminal operation
	 */
	public void performStreamOperations() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Chintamani");
		memberNames.add("Izhar");
		memberNames.add("Tarun");
		memberNames.add("Sachin");
		memberNames.add("Ayushi");
		memberNames.add("Abhinav");
		memberNames.add("Jaydeep");
		memberNames.add("Hemendra");
		
		//1: Stream.filter
		System.out.println("1:--------- Demonstration of stream.filter operations--------- ");
		Stream<String> stream = memberNames.stream().filter(p->p.startsWith("A"));
		stream.forEach(p->System.out.println(p));
		stream.close();
		// directly u can use as 
		 memberNames.stream().filter(p->p.startsWith("A")).forEach(System.out::println);
		//2. Stream.map
		 System.out.println("2:--------- Demonstration of Stream.map operations--------- ");
		 memberNames.stream().filter(p->p.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
		//3. Stream.sorted
		 System.out.println("3:--------- Demonstration of Stream.sorted operations--------- ");
		 //sorted does only create a sorted view of the stream without manipulating the ordering of the backed collection. The ordering of memberNames is untouched.
		 memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println); 
		 
		//4. Terminal Operations : stream.forEach, stream.collect, stream.match, stream.count, stream.reduce
		 System.out.println("4:--------- Demonstration of Terminal Operation Stream.collect operations--------- ");
		 List<String>namesInUpperCase =  memberNames.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
		 System.out.println(namesInUpperCase);
		 System.out.println("5:--------- Demonstration of Terminal Operation Stream.count operations--------- ");
		 Long totalMatchedMembers = memberNames.stream().filter(p->p.startsWith("A")).count();
		 System.out.println(totalMatchedMembers);
		 System.out.println("6:--------- Demonstration of Terminal Operation Stream.reduce operations--------- ");
		 Optional<String> reduced = memberNames.stream().reduce((s1,s2)->s1+"#"+s2);
		 reduced.ifPresent(System.out::println);
		 
	}
}

public class StreamApiExampleTest {

	public static void main(String[] args) {
		StreamApiUses streamApi = new StreamApiUses(); 
		streamApi.buildStreams();
		streamApi.convertStream2Collections();
		streamApi.performStreamOperations();
	}

}
