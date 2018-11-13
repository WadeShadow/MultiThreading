
public class ArraySumTask implements Runnable{
    private static int[] intArray;
    private int begin;
    private int end;
    private static int sum;
    private static boolean isInitialized = false;
    private Thread t;
    private int privateSum;


    public ArraySumTask( int begin, int end){
        privateSum = 0;
        this.begin = begin;
        this.end = end;
        this.t = new Thread(this);
    }


    @Override
    public void run() {
        try {

            for (int i = begin; i < end ; ++i) {
                privateSum+=intArray[i];
            }
            sum+=privateSum;
        }catch (Throwable t){
            System.out.println("uncaught exception is detected!!!");
        }
    }

    public Thread getThread() {
        return t;
    }

    public static void setIntArray(int[] intArray) {
        if(isInitialized)
        {
            System.out.println("Is already initialized");
            return;
        }
        ArraySumTask.intArray = intArray;
        isInitialized = true;
    }

    public static int getSum() {
        return sum;
    }
}
