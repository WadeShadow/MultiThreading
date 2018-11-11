public class ArraySumTaskFactory {
    ArraySumTask[] arraySumTask;
    int threadNum;

    public ArraySumTaskFactory(int[] array, int threadNum) {
        this.threadNum = threadNum;
        ArraySumTask.setIntArray(array);
        arraySumTask = new ArraySumTask[threadNum];
        for (int i = 0; i < threadNum - 1; i++) {
            arraySumTask[i] = new ArraySumTask((i * array.length) / threadNum, (i + 1) * array.length / threadNum);
        }
        arraySumTask[threadNum - 1] = new ArraySumTask((threadNum - 1) * array.length / threadNum, array.length);
    }

    public void startThreads() {
        try {
            for (int i = 0; i < threadNum; i++) {
                arraySumTask[i].getThread().start();
            }
            try {
                for (int i = 0; i < threadNum; i++) {
                    arraySumTask[i].getThread().join();
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        } catch (Throwable t){
        System.out.println("uncaught exception is detected!!!");
    }
    }
}



