
public class ThreadsMain {
    public static void main(String args[]) {

        /*ThreadsFactory threadsFactory = new ThreadsFactory(100, new FactorialTask());                             //Creates 100 threads of the specified task
        threadsFactory.startThreads();*/                                                                                                            //Runs the threads


       /* int[] array = new int[40000000];
        for (int i = 0; i < array.length; ++i) {
            Double a = (Math.random() * 300 - 150);             // Randomize an array of a lot of elements
            array[i] = a.intValue();
        }

        int sum = 0;
        int threadNum = 3;                                                      //Some useful variables
        double threadtime, simpletime;

        ArraySumTaskFactory arraySumTaskFactory = new ArraySumTaskFactory(array, threadNum);                //Initialization of threads

        long time = System.nanoTime();
        arraySumTaskFactory.startThreads();
        threadtime = System.nanoTime() - time;                                                                                                        //Executing threads
        System.out.println("sum is " + ArraySumTask.getSum());


        time = System.nanoTime();
        for (int i = 0; i < array.length; i++) {                                                                                                            //Executing simple algorithm
            sum += array[i];
        }
        simpletime = System.nanoTime() - time;
        System.out.println("sum is " + sum);


        System.out.println(threadtime / simpletime);                                                                                    //Check usefulness*/


     /*  FileCopyThreadsFactory copyThreadsFactory = new FileCopyThreadsFactory("SourceDir", "DestDir");      //Creates threads for each file in source directory that copy files in it
       copyThreadsFactory.executeThreads();*/

       /* ObserveFileTask observer = new ObserveFileTask(new File("SourceDir"));      //Observes changes in SourceDir directory with an interval of 1 second
        observer.getT().start();*/

        int[] array = new int[40];
        for (int i = 0; i < array.length; ++i) {
            Double a = (Math.random() * 300 - 150);
            array[i] = a.intValue();
        }
        ShellSortFactory factory = new ShellSortFactory(array.length/2, array);
        factory.executeThreads();
        factory.printArray();
    }

}
