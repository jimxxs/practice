public class Max{
int[][] array = {{3, 2, 1}, {4, 6, 5}};

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
    return location;
}
public static void main(String[] args) {
    Max maxFinder = new Max();
        int[][] myArray = {{10, 5, 2}, {3, 8, 15}};

        maxFinder.findMin(myArray);
        maxFinder.findMax(myArray);
}
}