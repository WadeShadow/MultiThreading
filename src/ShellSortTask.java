public class ShellSortTask implements Runnable {
    private static int[] array;
    private int start;
    private int increment;
    private static boolean instantiated = false;
    private Thread t;

    public ShellSortTask( int start, int increment) {
        this.start = start;
        this.increment = increment;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        for (int i = start; i < array.length; i += increment) {
            int tempVal = array[i];
            for (int j = i; j >= start + increment; j -= increment) {

                if (tempVal < array[j - increment]) array[j] = array[j - increment];
                else if (tempVal >= array[j - increment]) {
                    array[j] = tempVal;
                    break;
                }
                if(j-increment==start) array[j-increment] = tempVal;

            }
        }
    }

    public Thread getT() {
        return t;
    }

    public static void setArray(int[] array) {
        if (!instantiated) {
            ShellSortTask.array = array;
            instantiated = true;
        }
    }
}
