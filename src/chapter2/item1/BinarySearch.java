package chapter2.item1;

public class BinarySearch {
    private BinarySearch() {}

    public static int search(Comparable[] array, Comparable item) {
        int low, high, mid, cmp;
        low = 0;
        high = array.length - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            cmp = array[mid].compareTo(item);
            if (cmp > 0)
                high = mid - 1;
            else if (cmp < 0)
                low = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1,3,6,8,11,15,23,45,78, 79};
        String[] array2 = {"apple", "box", "egg", "find", "found", "zoo"};
        System.out.println("15: " + search(array1, 15));
        System.out.println("14: " + search(array1, 14));
        System.out.println("79: " + search(array1, 79));
        System.out.println("1: " + search(array1, 1));
        System.out.println("apple: " + search(array2, "apple"));
        System.out.println("boo: " + search(array2, "boo"));
        System.out.println("egg: " + search(array2, "egg"));
    }
}
