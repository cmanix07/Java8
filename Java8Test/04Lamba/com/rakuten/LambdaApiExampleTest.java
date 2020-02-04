package com.rakuten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author chintamani.prasad
 * It demonstrate the basic uses of lambda expression.
 *  1.Lambda expressions are nameless functions given as constant values, and written exactly in the place where itfs needed, typically as a parameter to some other function.
 *  e.g: (parameters) -> expression or (parameters) -> { statements; } or () -> expression
 *  2. Basically every lambda expression also must be convertible to some type to be accepted as method parameters. 
 *  Well, that type in which lambda expressions are converted, are always of functional interface type.
 *  3. In simple words, a lambda expression is an instance of a functional interface. But a lambda expression itself does not contain the information about 
 *  which functional interface it is implementing; that information is deduced from the context in which it is used.
 */
class LambdaExpression {

	public void lambdaExpExamples() {
		// 1. Iterating over list and performing lambda expression based operation.
		System.out.println("1. ------ Iterating over list and performing lambda expression based operation. -------");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.forEach(p -> System.out.println(p));
		// 2. Create new thread with runnable interface.
		System.out.println("2. ------  Create new thread with runnable interface. -------");
		new Thread(() -> System.out.println("New thread is running")).start();
	}

	public void sortEmployeeByName() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Ayushi"));
		empList.add(new Employee("Vijay"));
		empList.add(new Employee("Chintamani"));
		empList.add(new Employee("Aadhya"));
		empList.add(new Employee("Archana"));

		System.out.println("-- Before sorting the employee --" + empList);
		// empList.forEach(e -> System.out.println(e));
		// Method reference
		empList.sort(Employee::nameCompare);
		System.out.println("-- After sorting the employee --" + empList);

		empList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		System.out.println("SOrted employee shortest form of lambda: " + empList);
	}


	public int performMathOps(int a, int b, MathematicsOperations mathOps) {
		return mathOps.calulate(a, b);
	}
	public void fetchMessage(String msg, GreetingHelper greetingHelper) {
		greetingHelper.sayHello(msg);
	}

}
class Employee{
	String name;
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param e1
	 * @param e2
	 * @return
	 */
	public static int nameCompare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	@Override
	public String toString() {
		return name;
	}
	
	
}

interface MathematicsOperations{
	public int calulate(int a, int b);
}
interface GreetingHelper{
	public void sayHello(String s);
	default void numericaOps(int num) {
		System.out.println("Not a greetings: "+num);
	}
}
public class LambdaApiExampleTest {

	public static void main(String[] args) {
		LambdaExpression lambdaExpression = new LambdaExpression();
		lambdaExpression.lambdaExpExamples();
		lambdaExpression.sortEmployeeByName();
		
		//Lambda example  interface
		//Instead of implementing the methods of both interface and perform operation it is written in short using lambda.
		MathematicsOperations sum = (a, b) -> (a + b);
		MathematicsOperations sub = (a, b) -> a - b;
		MathematicsOperations mul = (a, b) -> a * b;
		MathematicsOperations div = (a, b) -> a / b;
		
		System.out.println("Sum is: "+lambdaExpression.performMathOps(50, 10, sum));
		System.out.println("Sub is: "+lambdaExpression.performMathOps(50, 10, sub));
		System.out.println("Mul is: "+lambdaExpression.performMathOps(50, 10, mul));
		System.out.println("Div is: "+lambdaExpression.performMathOps(50, 10, div));
		
		GreetingHelper greetings = msg -> System.out.println("Hello " + msg);
		lambdaExpression.fetchMessage("Chinta", greetings);

	}

}
