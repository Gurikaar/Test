package Java_Chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Count the number of names that start with alphabet A

		// Regular
		// 1 way of writing
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arjun");
		names.add("Beema");
		names.add("Chanakya");
		names.add("Duryodhana");
		names.add("Arav");
		names.add("Aradhya");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);

			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);

		// Streams and Lambda
		// There is no life for intermediate operation if there is no terminate operator
		// terminal operator will operate only if the intermediate operator (like
		// filter) returns true

		// 2nd way of writing
		ArrayList<String> name = new ArrayList<String>();
		name.add("Arjun");
		name.add("Beema");
		name.add("Chanakya");
		name.add("Duryodhana");
		name.add("Arav");
		name.add("Aradhya");

		Long isdata = name.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(isdata);

		// 3rd way of writing
		// Create stream
		// using filter with stream API

		Long d = Stream.of("Arjun", "Beema", "Chanakya", "Duryodhana", "Arav", "Aradhya").filter(s -> s.startsWith("A"))
				.count();
		System.out.println(d);

		// 4th way
		// Print all the ArrayList using streams

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		System.out.println();

		// 5th way >> gives only one result
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
		
		System.out.println();
		
		//6th Method >> Using MAP
		//print names which has last letter as "v" with upper case 
		// Map >> we use it for manipulation of strings 
		
		names.stream().filter(s -> s.endsWith("v")).map(s -> s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println();
		
		//7th Method >> Using MAP
		//print names with upper case 
		
		names.stream().map(s -> s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println();
		
		//8th Method >> Using MAP
		// Here we are converting arrays to arraylist and using the streams 
		//print names which has first letter as "A" with upper case and sorted
		//One line sorted 
		
		List<String> names1= Arrays.asList("Arjun", "Beema", "Chanakya", "Duryodhana", "Arav", "Aradhya");
		
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println();
		//9th Method
		//Merge Array 'A' and Array 'B' and then sort 
		
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Man");
		names2.add("DON");
		names2.add("Women");

		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		
		//comment out if you wanna execute the below step (bcz I'm gonna use this in the 10th method. Bcz I can't modify stream
		//Exception thrown if I don't coment this inoreder to execute 10th meyhod 
		//Illegal stale exception: stream has already been operated upon or closed
		//Basically if your using a single stream then once you can use, because once it's created cannot be modified. 
		// if your running 9thbmethod comment 10th method and vise versa 
		
		//newStream.sorted().forEach(s->System.out.println(s));
		
		System.out.println();
		//10th Method 
		// Check whether a names is present in the list 
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Women")); //this gives boolean 
		Assert.assertTrue(flag);
		
		System.out.println();
		
		//11th method >> Stream collect 
		// collect the data in the list and know what is there in the first list 
		//other way to do this is to use limit
		
		List<String> ls = names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		System.out.println();
		
		//12th way 
		// print unique number from the array 
		//sort the number 
		//sort the number and give me 3rd index
		
		List<Integer> value =Arrays.asList(3,5,2,4,7,4,9,1);
		
		value.stream().distinct().sorted().forEach(s-> System.out.println(s));
		
		System.out.println();
		
		List<Integer> sortednum=value.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortednum.get(2)); //indexing starts with 0 so for the third index I should give 2 
		

	}

}
