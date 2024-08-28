import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class InsSortInt {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("randInts.txt"));
        ArrayList<Integer> arr1 = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arr1.add(scanner.nextInt());
        }
        scanner.close();
        
        Integer[] arr = new Integer[arr1.size()];
        arr1.toArray(arr);

        insertionSort(arr);
        
        System.out.println("Smallest: "+arr[0]+"\nLargest: "+arr[arr.length-1]);
    }

    public static int insertionSort(Integer[] arr) {
        int steps = 0;
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int current = i-1;
            while (current >= 0 && arr[current] > element) {
                arr[current + 1] = arr[current];
                current--;
                steps++;
            }
            arr[current+1] = element;
        }
        return steps;
    }
}