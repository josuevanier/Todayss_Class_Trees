package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionsFromDoc {
}

class WordCountFile{
    public  void main(String[] args) {

        String fileName = "input.txt";
        String word = "word";

        try{
            String line;
            BufferedReader bufferedReader  = new BufferedReader(new FileReader(fileName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sampled.txt"));
            int count = 0;
            while ((line = bufferedReader.readLine()) != null ){

                String[] regex = line.split("\\s+");
                for(String words : regex){
                    String wordTrimed = words.trim();
                    if(wordTrimed.equals(word)) count++;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
class removeWords{
    public  void main(String[] args) {
        String inputFile = "input.file";
        String searchWord = "example";

        try{
            Scanner scanner  = new Scanner(new File(inputFile));
            PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"));
            while(scanner.hasNext()){
                String currentWord = scanner.next().trim();
                if(currentWord.equalsIgnoreCase(searchWord)){

                    printWriter.println(currentWord + " ");
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
// Write a generic method to find the repeated object in the range [begin, end) of a list.

class findRepeatedObjectIntheRangeBeginEnd {
    public static <T> T findRepeatedObject(List<T> list, int begin, int end) {
        Map<T, Long> countMap = list.subList(begin, end).stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        return countMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }
}
//Write a java program using streams to get the longest string from the list: use lambda expressions

class longestStringWithStreamAndLambda{
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Apple");
        strings.add("Appled");
        strings.add("Applesadada");
        strings.add("Ap");

        String longestStringValue = strings.stream().max((s1, s2)-> Integer.compare(s1.length(), s2.length())).orElse(null);

        System.out.println(longestStringValue);
    }
}

class ToFindTheSumOfAlltheNumberInAGivenRange{
    public static void main(String[] args) {
       int start = 1;
       int end = 5;
       IntStream inputStream = IntStream.range(start,end);
        // Calculate the product of all numbers in the range
        int product = inputStream.reduce(1, (x, y) -> x * y); // 1 initial value of the product

        System.out.println(product);
    }
}
class   StreamSortAndSum {
    public static void main(String[] args) {
        // Sample ArrayList of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 7));

        // Sorting the ArrayList using streams
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        // Printing the sorted numbers
        System.out.println("Sorted numbers: " + sortedNumbers);

        // Summing the sorted numbers using streams
        int sum = sortedNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // Printing the sum
        System.out.println("Sum of sorted numbers: " + sum);
    }
}