public class Max{
int[][] array = {{3, 2, 1}, {4, 6, 5}};//The array variable is a 2D integer array that holds the input data.


/*Initializes min to the maximum integer value (Integer.MAX_VALUE) to ensure any value in the array will be smaller.
Initializes location to {-1, -1} to indicate an invalid location initially.
Iterates through each element of the array:
If the current element is smaller than the current min:
Updates min to the current element's value.
Updates location to the current element's indices (row and column).
Prints the minimum value and its location.
Returns the location of the minimum value. */

public int[] findMin(int[][] array) {
    int min = Integer.MAX_VALUE;
    int[] location = {-1, -1};
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if (array[i][j] < min) {
                min = array[i][j];
                location = new int[]{i, j};
            }
        }
    }
    System.out.println("Min Value: " + min + " at " + java.util.Arrays.toString(location));
    return location; 
}



/*Similar to findMin
 but initializes max to the minimum integer value (Integer.MIN_VALUE)
 and compares elements for greater values.
Prints the maximum value and its location.
Returns the location of the maximum value. */
public int[] findMax(int[][] array) {
    int max = Integer.MIN_VALUE;
    int[] location = {-1, -1};
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if (array[i][j] > max) {
                max = array[i][j];
                location = new int[]{i, j};
            }
        }
    }
    System.out.println("Max Value: " + max + " at " + java.util.Arrays.toString(location));
    return location;//Output: The method prints the found values and their locations to the console.
}


/*
Iterative Approach: The code uses nested loops to iterate through each element of the 2D array.
Comparison and Update: It compares each element with the current minimum or maximum and updates the values accordingly.
Location Tracking: It keeps track of the indices of the minimum and maximum elements. */
public static void main(String[] args) {
    Max maxFinder = new Max();
        int[][] myArray = {{10, 5, 2}, {3, 8, 15}};

        maxFinder.findMin(myArray);
        maxFinder.findMax(myArray);
}
}