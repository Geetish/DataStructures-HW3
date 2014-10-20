/*************************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Homework 3 SortedLinkedList implementation with Recursion
 * 
 *************************************************************/

import java.io.*;
import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		
		MyArray words = new MyArray(10);
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("F:\\childrensbible.txt"));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] wordsFromText = line.split("\\W");
				for(String word:wordsFromText)
					words.add(word.toLowerCase());
			}
		} catch(FileNotFoundException e) {
			System.err.println("Cannot find the file");
		} finally {
			if(scanner!= null) scanner.close();
		}
		
		String[] unsorted = new String[words.size()];
		for(int i=0; i<unsorted.length; i++) {
			unsorted[i] = words.get(i);
		}
		
		SortedLinkedList sortedWords = new SortedLinkedList(unsorted);
		
		if(sortedWords.contains("god"))
			System.out.println("god is found");
		else 
			System.out.println("not found");
		
		System.out.println("Number of words in the file is (SortedLL): "+sortedWords.size());
		//sortedWords.display();
		
		for(int i=0; i<9;i++) {
			sortedWords.removeFirst();
		}
		
		
		sortedWords.removeAt(0);
		
		System.out.println("Number of words in the file is (SortedLL): "+sortedWords.size());
		
		sortedWords.display();
		
	}

}