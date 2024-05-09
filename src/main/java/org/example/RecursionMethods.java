package org.example;

import java.util.*;

public class RecursionMethods {
    public static void printPermutations(String str, String ans) {
        // Base case: if the input string is empty, print `ans`
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // Take out one character from the string
            char ch = str.charAt(i);
            // Remaining string after removing the `i-th` character
            String ros = str.substring(0, i) + str.substring(i + 1);
            // Recursive call: add `ch` to the answer and use the remaining string
            printPermutations(ros, ans + ch);
        }
    }
    public static boolean isStringPalaindrome(String msg){
        int i = 0;
        if(msg.length() == 1){
            return  true;
        }else if(msg.charAt(0) != msg.charAt(msg.length() - 1)) {
            return false;
        }
        return isStringPalaindrome(msg.substring( ++i, msg.length() - 1));
    }
    public static int sum(int n){
        if(n <= 1){
            return 1;
        }else {
         return  n + sum(n - 1);
        }
    }

    public static void printCountDown(int n){
        if(n <= 1 ){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printCountDown(n - 1);
    }
    public static void towersOfHanoi(int n, char source, char auxiliary, char destination) {
        //2^n
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        towersOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        towersOfHanoi(n - 1, auxiliary, source, destination);
    }
    public static void main(String[] args) {
        int numDisks = 3; // Change the number of disks as needed
        towersOfHanoi(numDisks, 'A', 'B', 'C');

        printCountDown(5);

        System.out.println(sum(5));


        System.out.println(isStringPalaindrome("kayak"));
        System.out.println(isStringPalaindrome("radar"));
        System.out.println(isStringPalaindrome("uisdsad"));
        System.out.println(isStringPalaindrome("lol"));


        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2):");
        graph.dfs(2);
    }
}
 class Factorial {

     // Method to compute and print factorial expression
     public static void printFactorialExpression(int n) {
         System.out.print(n + "! = ");
         for (int i = n; i >= 1; i--) {
             System.out.print(i);
             if (i != 1) {
                 System.out.print(" * ");
             }
         }
         System.out.println();
     }

     // Method to compute and return factorial value
     public static int computeFactorial(int n) {
         if (n <= 1) {
             return 1;
         }
         return n * computeFactorial(n - 1);
     }
 }
class Graph {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    // Constructor to initialize the graph
    public Graph(int vertices) {
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    // DFS method
    public void dfs(int start) {
        // Base case: if the node is already visited, return
        if (visited.contains(start)) {
            return;
        }

        // Visit the node
        visited.add(start);
        System.out.println("Visited: " + start);

        // Recur for all the vertices adjacent to this vertex
        List<Integer> neighbors = adjList.get(start);
        if (neighbors != null) {
            for (int next : neighbors) {
                if (!visited.contains(next)) {
                    dfs(next);
                }
            }
        }
    }
}
   class FibonacciCalculator {

public static int calculateFibonacci(int n) {
        // Base case: Fibonacci numbers at positions 0 and 1 are 0 and 1, respectively
        if (n == 0) {
        return 0;
        } else if (n == 1) {
        return 1;
        }

        // Recursive case: sum of the previous two Fibonacci numbers
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }

public static void main(String[] args) {
        int position = 0;
        int fibonacciNumber = calculateFibonacci(position);
        System.out.println("The Fibonacci number at position " + position + " is: " + fibonacciNumber);
        position = 3;
        fibonacciNumber = calculateFibonacci(position);
        System.out.println("\nThe Fibonacci number at position " + position + " is: " + fibonacciNumber);
        position = 9;
        fibonacciNumber = calculateFibonacci(position);
        System.out.println("\nThe Fibonacci number at position " + position + " is: " + fibonacciNumber);
        }
}
class ArraySortChecker {

    public static boolean isSorted(int[] arr) {
        return isSorted(arr, 0);
    }

    private static boolean isSorted(int[] arr, int index) {
        // Base case: if the index reaches the end of the array,
        // the array is sorted
        if (index == arr.length - 1) {
            return true;
        }

        // Recursive case: check if the element at the current index
        // is greater than the next element,
        // and recursively call the method with the next index
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }
}
class ExponentiationCalculator {

    public static double calculateExponentiation(double base, int exponent) {
        // Base case: any number raised to the power of 0 is 1
        if (exponent == 0) {
            return 1;
        }

        // Recursive case: multiply the base with the exponentiation of (base, exponent-1)
        return base * calculateExponentiation(base, exponent - 1);
    }

    public static void main(String[] args) {
        double base = 3.5;
        int exponent = 4;
        double result = calculateExponentiation(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}
class StringReverser {
    public static String reverseString(String str) {
        // Base case: if the string is empty or has only one character, it is already reversed
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }

        // Recursive case: reverse the substring starting from the second character and concatenate the first character
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static int calculateGCD(int num1, int num2) {
        // Base case: if the second number is 0, the GCD is the first number
        if (num2 == 0) {
            return num1;
        }

        // Recursive case: calculate the GCD by recursively calling the method with num2 as the new num1 and the remainder as num2
        int remainder = num1 % num2;
        return calculateGCD(num2, remainder);
    }
}
    class ArrayElementCounter {
public static<T> int countOccurrences(T[]arr,T target){
        return countOccurrences(arr,target,0);
        }

private static<T> int countOccurrences(T[]arr,T target,int index){
        // Base case: if the index reaches the end of the array, return 0
        if(index==arr.length){
        return 0;
        }

        // Recursive case: check if the element at the current index is equal to the target,
        // and recursively call the method with the next index and add 1 if it is equal
        int count=countOccurrences(arr,target,index+1);
        if(arr[index].equals(target)){
        count++;
        }

        return count;
        }
        }
class ArrayProductCalculator {

    public static int calculateProduct(int[] arr) {
        return calculateProduct(arr, 0, arr.length - 1);
    }

    private static int calculateProduct(int[] arr, int left, int right) {
        // Base case: if the left and right indices are equal,
        // return the single element as the product

        if (left == right) {
            return arr[left];
        }

        // Recursive case: divide the array into two halves, recursively
        // calculate the product in each half,and return the product of
        //the two calculated products

        int mid = (left + right) / 2;
        int productLeft = calculateProduct(arr, left, mid);
        int productRight = calculateProduct(arr, mid + 1, right);

        return productLeft * productRight;
    }
}
  class   DigitSumCalculator {

        public static int calculateDigitSum ( int number){
            // Base case: if the number is a single digit, return the number itself
            if (number < 10) {
                return number;
            }

            // Recursive case: calculate the sum of the last digit and the digit sum of the remaining number
            int lastDigit = number % 10;
            int remainingNumber = number / 10;

            return lastDigit + calculateDigitSum(remainingNumber);
        }

    }
class ArraySortsChecker {

    public static boolean isSorted(int[] arr) {
        return isSorted(arr, 0);
    }

    private static boolean isSorted(int[] arr, int index) {
        // Base case: if the index reaches the end of the array,
        // the array is sorted
        if (index == arr.length - 1) {
            return true;
        }

        // Recursive case: check if the element at the current index
        // is greater than the next element,
        // and recursively call the method with the next index
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }
}