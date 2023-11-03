import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        RadixSort radixSort = new RadixSort();
        SelectionSort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();

        int[] sizes = {10000, 100000, 1000000};
        int repetitions = 15;

        for (int size : sizes) {
            System.out.println("Sorting arrays of size: " + size);
            int[] array = new int[size];
            long totalTimeBubble = 0;
            long totalTimeInsertion = 0;
            long totalTimeMerge = 0;
            long totalTimeQuick = 0;
            long totalTimeRadix = 0;
            long totalTimeSelection = 0;
            long totalTimeShell = 0;

            for (int i = 0; i < repetitions; i++) {
                fillArray(array);
                totalTimeBubble += sortAndTime(array.clone(), bubbleSort);
                fillArray(array);
                totalTimeInsertion += sortAndTime(array.clone(), insertionSort);
                fillArray(array);
                totalTimeMerge += sortAndTime(array.clone(), mergeSort);
                fillArray(array);
                totalTimeQuick += sortAndTime(array.clone(), quickSort);
                fillArray(array);
                totalTimeRadix += sortAndTime(array.clone(), radixSort);
                fillArray(array);
                totalTimeSelection += sortAndTime(array.clone(), selectionSort);
                fillArray(array);
                totalTimeShell += sortAndTime(array.clone(), shellSort);
            }

            System.out.println("Average time for BubbleSort: " + (totalTimeBubble / (double) repetitions) + " ns");
            System.out.println("Average time for InsertionSort: " + (totalTimeInsertion / (double) repetitions) + " ns");
            System.out.println("Average time for MergeSort: " + (totalTimeMerge / (double) repetitions) + " ns");
            System.out.println("Average time for QuickSort: " + (totalTimeQuick / (double) repetitions) + " ns");
            System.out.println("Average time for RadixSort: " + (totalTimeRadix / (double) repetitions) + " ns");
            System.out.println("Average time for SelectionSort: " + (totalTimeSelection / (double) repetitions) + " ns");
            System.out.println("Average time for ShellSort: " + (totalTimeShell / (double) repetitions) + " ns");
        }
    }

    public static void fillArray(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(1, 1000000);
        }
    }

    public static long sortAndTime(int[] array, Object sortAlgorithm) {
        long startTime = System.nanoTime();
        if (sortAlgorithm instanceof BubbleSort) {
            BubbleSort.bubbleSort(array, array.length); // Pass array and its length
        } else if (sortAlgorithm instanceof InsertionSort) {
            ((InsertionSort) sortAlgorithm).sort(array); // Pass only the array
        } else if (sortAlgorithm instanceof MergeSort) {
            new MergeSort().sort(array, 0, array.length - 1); // Pass array, start index, and end index
        } else if (sortAlgorithm instanceof QuickSort) {
            new QuickSort().sort(array, 0, array.length - 1); // Pass array, start index, and end index
        } else if (sortAlgorithm instanceof RadixSort) {
            RadixSort.radixsort(array, array.length); // Pass array and its length
        } else if (sortAlgorithm instanceof SelectionSort) {
            ((SelectionSort) sortAlgorithm).sort(array); // Pass only the array
        } else if (sortAlgorithm instanceof ShellSort) {
            ((ShellSort) sortAlgorithm).sort(array); // Pass only the array
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
