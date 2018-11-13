import java.math.BigInteger;

public class FactorialTask implements Runnable {
    private static int threadCount = 0;
    private int threadNum;
    private BigInteger numFactorial;
    private Thread t ;

    public FactorialTask() {
        super();
        t = new Thread(this);
        threadNum = threadCount++;
        numFactorial = new BigInteger("1");
    }

    public Thread getThread() {
        return t;
    }

    public BigInteger getNumFactorial() {
        return numFactorial;
    }
    @Override
    public void run()   {

        for (int i = 2; i <= threadNum; ++i) {
            numFactorial=numFactorial.multiply(new BigInteger(Integer.toString(i)));
        }
        System.out.println("n = "+ threadNum + ": "+numFactorial);
    }
}
