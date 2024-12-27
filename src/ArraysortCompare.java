import java.util.Arrays;
import java.util.Random;

public class ArraysortCompare {
    public static void main(String[] args) {
        int size = 10_000;
        int[] array = generateRandomArray(size);
        System.out.println("Original array: " + arrayToString(array));

        //copy array to selection sort
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        //time selection sort take
        long startTime = System.currentTimeMillis();
        selectionSort(arrayToSort);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("time selection - " + timeElapsed);

        //copy array to bubble sort
        int[] arrayToBubble = Arrays.copyOf(array, array.length);

        //time bubble sort take
        long startTime1 = System.currentTimeMillis();
        bubbleSort(arrayToBubble);
        long endTime1 = System.currentTimeMillis();
        long timeElapsed1 = endTime1 - startTime1;
        System.out.println("time bubble - " + timeElapsed1);

        //copy array to bubble sort
        int[] arrayToArrSort = Arrays.copyOf(array, array.length);

        //time need for Arrays.sort
        long startTime2 = System.currentTimeMillis();
        Arrays.sort(arrayToArrSort);
        System.out.println("Arrays.sort sorted : " + arrayToString(arrayToArrSort));
        long endTime2 = System.currentTimeMillis();
        long timeElapsed2 = endTime2 - startTime2;
        System.out.println("time arrays.sort - " + timeElapsed2);

    }

    private static void selectionSort(int[] firstArray) {
        for (int i = 0; i < firstArray.length; i++) {
            int minIndex = min(firstArray, i, firstArray.length);

            int tmp = firstArray[i];
            firstArray[i] = firstArray[minIndex];
            firstArray[minIndex] = tmp;
        }

        System.out.println("Selection sorted : " + arrayToString(firstArray));
    }

    private static void bubbleSort(int[] secondArray) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < secondArray.length; i++) {
                if (secondArray[i] < secondArray[i - 1]) {
                    swap(secondArray, i, i - 1);
                    needIteration = true;
                }
            }
        }

        System.out.println("Bubble sorted : " + arrayToString(secondArray));
    }

    //additional methods

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private static int min(int[] array, int start, int end) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}


