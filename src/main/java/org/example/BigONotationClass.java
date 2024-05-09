package org.example;

public class BigONotationClass {

}

class question1{
    /*
    // Method with O(1) time complexity
int getElement(int[] array, int index) {
    if (index < 0 || index >= array.length) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }
    return array[index]; // Accessing an element in an array by index takes constant time
    // Regardless of the size of the array, accessing an element by index is a direct operation
    // It doesn't depend on the size of the array; it directly computes the memory address of the element
    // Therefore, the time complexity of this operation is O(1) or constant time
}
     */
    ///////
    /*
    // Method with O(1) time complexity
int happy(int n, int m) {
    return n; // This statement executes only once, regardless of the value of 'n' or 'm'
    // It doesn't involve any loops or recursive calls, and its execution time is constant
    // Therefore, the time complexity of this method is O(1) or constant time
    // It doesn't depend on the input size or any other factors; it always takes the same amount of time to execute
}
     */
    ///////
    /*
    o(n)
    int happy(int n, int m){
    if(n < 10) return n;
    else if(n < 100);
    return happy (n -2, m);
    else return happy(n /2, m)
     */
////////////
    /*
    o(n^2)
    void sunny(int n){
    j = 0;
    while(j < n){
    for(int i = 0; i < n; ++i{
    sout("i = " + i)}
    for(int k = 0; k < i ++k)sout("k" + k);

    }
    j = j + 1
   }
     */
    ////////
    /*
    Factorial (n!):
java
Copy code
int factorial(int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}
Explanation: This recursive method calculates the factorial of a number n.
The time complexity of this method is O(n!) because each
recursive call leads to n-1 subsequent calls until n reaches 1.
     */
    //////////
    /*
    Logarithmic (log n):
java
Copy code
int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
Explanation: This method performs binary search on a sorted array arr to find the
index of a target element. The time complexity of binary search is O(log n)
because with each iteration of the loop, the search space is divided by half.
     */
 ///////////
    /*
    Quadratic (n^2):
java
Copy code
void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; ++i) {
        for (int j = 0; j < n - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
Explanation: This method implements the bubble sort algorithm to sort an array arr. The time complexity of bubble sort is O(n^2) because it
has two nested loops, and for each element in the array, it performs comparisons and swaps.
     */
////////////
    /*
Exponential (2^n):
java
Copy code
int powerOfTwo(int n) {
    if (n == 0) {
        return 1;
    }
    return 2 * powerOfTwo(n - 1);
}
Explanation: This recursive method calculates 2^n by recursively multiplying 2 by itself n times.
The time complexity of this method is O(2^n) because each recursive call doubles
the number of recursive calls, resulting in an exponential growth in the number of function calls.
     */
    /////
}
