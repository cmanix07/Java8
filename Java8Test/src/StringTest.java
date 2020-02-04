import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class StringTest {
	
	private static String join(Collection<String> list) {
	    return String.join(",", list
	            .stream()
	            .map(name -> ("'" + name + "'"))
	            .collect(Collectors.toList()));
	}
	
	
	
	public static String convertUsingJava8(Collection<String> list)
	{
	    return String.join(",", list);
	}

	public static void main(String[] args) {
		
		Collection<String> list = Arrays.asList("A","B","C");
		System.out.println("======> "+StringUtils.join(list));
		System.out.println(convertUsingJava8(list));
	}

}
