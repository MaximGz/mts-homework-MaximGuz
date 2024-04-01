import java.util.Arrays;
import java.util.concurrent.Callable;

public class СreateSegment implements Callable<int[]> {
    private final int[] array;
    private final int start;
    private final int end;

    public СreateSegment(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public int[] call() {
        int[] ar = new int[end - start];
        int j = 0;
        for(int i = start; i < end; i++) {
            ar[j] = array[i];
            j++;
        }
        return ar;
    }
}
