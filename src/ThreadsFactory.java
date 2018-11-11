import javax.sound.midi.Soundbank;

public class ThreadsFactory {
   /* private FactorialTask[] threadsArray;

    public ThreadsFactory(int n){


        threadsArray = new FactorialTask[n];
        for (int i = 0; i<threadsArray.length;++i){
            threadsArray[i] = new FactorialTask();
        }
    }

    public void startThreads(){
        for (int i = 0; i < threadsArray.length; ++i) {
            threadsArray[i].getThread().start();
        }
    }*/

    private Thread[] threadsArray;

    public ThreadsFactory(int n, Runnable task) {
        threadsArray = new Thread[n];
        try {
            for (int i = 0; i < threadsArray.length; ++i) {
                threadsArray[i] = new Thread(task.getClass().newInstance());            //It should be useful for tasks without parameters in constructor like factorialTasl
            }
        }catch (IllegalAccessException ex){
            System.out.println("Illegal access exception " + ex);
        }catch (InstantiationException ex){
            System.out.println("Instantiation exception " + ex);
        }
    }

    public void startThreads() {
        for (int i = 0; i < threadsArray.length; ++i) {
            threadsArray[i].start();
        }
    }
}
