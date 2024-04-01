import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {
    private final int[] array;
    private final int start, end;

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    private int threshold = 1_000_000;

    public ParallelMergeSort(int[] array, int threshold) {
        this(array, 0, array.length, threshold);
    }

    public ParallelMergeSort(int[] array, int start, int end, int threshold) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (end - start <= threshold) {
            Arrays.sort(array, start, end);
            System.out.println("Thread " + Thread.currentThread().getName() + " start from " + start + " to " + end);
        } else {
            int mid = start + (end - start) / 2;
            ParallelMergeSort left = new ParallelMergeSort(array, start, mid, threshold);
            ParallelMergeSort right = new ParallelMergeSort(array, mid, end, threshold);

            invokeAll(left, right);
            merge(mid);
        }
    }

    private void merge(int mid) {
        if (array[mid - 1] <= array[mid]) {
            return; // the arrays are already correctly sorted, so we can skip the merge
        }
        int[] tmp = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            tmp[k++] = (array[i] <= array[j]) ? array[i++] : array[j++];
        }

        while (i < mid) {
            tmp[k++] = array[i++];
        }

        while (j < end) {
            tmp[k++] = array[j++];
        }

        System.arraycopy(tmp, 0, array, start, tmp.length);
    }

    public static void main(String[] args) {
        int[] array = fillRandList(50,100);
        ParallelMergeSort task = new ParallelMergeSort(array, 10);
        task.invoke();
    }

    public static int[] fillRandList(int listSize, int randRange) {
        Random rnd = new Random();
        int[] array = new int[listSize  ];
        for (int i = 0; i < listSize; i++) {
            array[i] = rnd.nextInt(randRange);
        }
        return array;
    }
}
