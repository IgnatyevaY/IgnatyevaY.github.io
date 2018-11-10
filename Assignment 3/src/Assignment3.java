//Yekaterina Ignatyeva

import java.util.*;
import java.io.*;

public class Assignment3 {
	public static void main(String [] args) throws IOException {
		File input = new File("C:\\Users\\katya_000\\Desktop\\CISC3130\\3 WordFrequency - HashMaps\\Assignment 3\\src\\input.txt");
		System.out.println(input.exists());
		HashMap<String, Integer> result = WordFrequency(input);
		System.out.println(result.entrySet());
		List<String> sorted = sort(result);
		listed(sorted, result);
		
	}

			

	
	//Counts the total of words within the file
	public static int WordCount(File song) throws FileNotFoundException {
		Scanner scan = new Scanner(song);
		int size = 0;
		//increments integer size by one per word until it reaches NULL
		while (scan.hasNext()) { 
			scan.next();
			size++;
		}
		System.out.println("Total Words: " + size +"\n"); 
		scan.close();
		return size;
	}
	
	public static List<String> sort(HashMap<String, Integer> tosort){
		   List<String> freq = new ArrayList<>();

		    for (String key : tosort.keySet()) {
		      freq.add(key);
		    }

		        // sorts the keyList from highest to lowest based on the value associated with each key
		     Collections.sort(freq, new Comparator<String>() {
		        // sorts from highest to lowest
		       public int compare(String s1, String s2) {
		           return tosort.get(s2) - tosort.get(s1);
		        }
		      });
		      return freq;
		      }
	
	public static void listed(List<String> input, HashMap<String, Integer> tosort ) throws FileNotFoundException {
		File output = new File("C:\\Users\\katya_000\\Desktop\\CISC3130\\3 WordFrequency - HashMaps\\Assignment 3\\src\\output.txt");
		PrintStream out = new PrintStream(output);
	      // iterate over the sorted list writing each one out to the outputFile
	      for (String key : input) {
	        // write to outputFile in the style of 'frequency: word'
	        out.println(tosort.get(key) + ": " + key + "\n");
	      }
	}
	
	public static HashMap<String, Integer> WordFrequency(File song) throws FileNotFoundException {
		Scanner scan = new Scanner(song);
		HashMap<String, Integer> wordfreq = new HashMap<String, Integer>();
		int num = 1;
		while (scan.hasNext()) {
			String temp = scan.next().toLowerCase();
			temp = temp.replaceAll("[,!.\"()]", "");
			if(wordfreq.containsKey(temp)) {
				wordfreq.replace(temp, wordfreq.get(temp)+1);
				num++;
			}else {
				num = 1;
				wordfreq.put(temp, num);
			}	
		}
		scan.close(); 
		return wordfreq;
	}	

}
		

