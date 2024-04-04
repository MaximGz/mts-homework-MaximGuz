public class CreateSegment {
    private final int[] array;
    private final int start;
    private final int end;

    public CreateSegment(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

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
