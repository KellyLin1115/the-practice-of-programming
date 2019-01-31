package chapter2.item2;

import java.util.Random;

public class QuickSort {

    private static Random rand = new Random();

    private QuickSort() {}

    public static void sort(Comparable[] array) {
        int n = array.length;
        sort(array, 0, n-1);

    }

    private static void sort(Comparable[] array, int lo, int hi) {
        if(lo >= hi) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j+1, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] array, int lo, int hi) {
        //Pick a random pivot in case input array is sorted
        int randPick =lo + Math.abs(rand.nextInt()) % (hi - lo + 1);
        swap(array, lo, randPick);
        Comparable pivot = array[lo];

        int i = lo;
        int j = hi + 1;
        while(true) {
             //If array[i] or array[j] equals pivot, stop and swap once j done.
             //If not, the cost time will be O（N2）when all the values equal pivot in the array
            while(array[++i].compareTo(pivot) < 0) if(i == hi) break;
            while(array[--j].compareTo(pivot) > 0) if(j == lo) break;
            if(i >= j) break;
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }
    private static void swap(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] array = {3, 45, 6, 8, 34, 2, 5, 6, 9, 10, 10, 10};
        sort(array);
        for(Integer item: array)
            System.out.print(item + " ");

    }
}
