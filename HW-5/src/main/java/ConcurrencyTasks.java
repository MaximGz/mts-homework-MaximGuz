import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyTasks {
    // 2. Потокобезопасный счетчик
    public int atomicCounterMethod(int n, int threadNums) {
        Counter counter = new Counter();

        ExecutorService executor = Executors.newFixedThreadPool(threadNums);

        for (int i = 0; i < threadNums; i++) {
            executor.submit(() -> {
                for (int j = 0; j < n; j++) {
                    counter.increment();
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            //ждём пока отработают все потоки
        }

        return counter.getCount();
    }

    // 4. Параллельное вычисление факториала
    public BigInteger factorialMethod(int n, int threadNums) throws ExecutionException, InterruptedException {
        int[] arr = new int[n];
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int chunkSize = arr.length / threadNums;

        ExecutorService exec = Executors.newFixedThreadPool(threadNums);

        Future[] futures = new Future[threadNums];

        for (int i = 0; i < threadNums; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == threadNums - 1) ? n : startIndex + chunkSize;
            ;
            futures[i] = exec.submit(new СreateSegment(arr, startIndex, endIndex));
        }

        for (Future future : futures) {
            int[] value = (int[]) future.get();
            BigInteger i = BigInteger.valueOf(1);
            for (int v : value) {
                i = i.multiply(BigInteger.valueOf(v));
            }
            result = result.multiply(i);
        }
        exec.shutdown();
        return result;
    }

    //5. Параллельная проверка на простоту чисел.
    public List<Integer> ParallelCheckingSimplicity(int n, int threadNums) throws ExecutionException, InterruptedException {
        int[] arr = new Random().ints(n, 0, 100).toArray();
        int chunkSize = arr.length / threadNums;
        List<Integer> resultList = new ArrayList<Integer>();

        ExecutorService exec = Executors.newFixedThreadPool(threadNums);

        Future[] futures = new Future[threadNums];

        for (int i = 0; i < threadNums; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == threadNums - 1) ? n : startIndex + chunkSize;
            ;
            futures[i] = exec.submit(new СreateSegment(arr, startIndex, endIndex));
        }

        for (Future future : futures) {
            int[] initArr = (int[]) future.get();
            List<Integer> finalList = new ArrayList<Integer>();
            for (int v : initArr) {
                if (checkIfPrime(v))
                    finalList.add(v);
            }
            resultList.addAll(finalList);
        }
        exec.shutdown();
        return resultList;
    }

    //Проверить на простоту
    public static boolean checkIfPrime(int number) {
        if (number <= 1)
            return false;

        if (number == 2)
            return true;

        if (number % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
