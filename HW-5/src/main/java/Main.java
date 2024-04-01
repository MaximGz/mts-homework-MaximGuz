import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ConcurrencyTasks ct = new ConcurrencyTasks();
        var a = ct.factorialMethod(30, 10);
        System.out.println("Результат: " + a.intValue());

        var b = ct.atomicCounterMethod(900000, 10);
        System.out.println("Результат: " + b);

        var c = ct.ParallelCheckingSimplicity(100000, 10);
        System.out.println("Результат: " + c.toString());
    }
}