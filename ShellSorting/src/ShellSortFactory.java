import javax.xml.transform.Source;

public class ShellSortFactory {
    private  int increment;
    private int[] array;
    private ShellSortTask[] shellSortThreads;

    public ShellSortFactory(int increment, int[] array) {
        this.increment = increment;
        this.array = array;

        ShellSortTask.setArray(array);
        shellSortThreads = new ShellSortTask[increment];
        for (int i = 0; i < increment; i++) {
            shellSortThreads[i] = new ShellSortTask(i, increment);
        }
    }

    public void executeThreads(){
        do{
            for (int i = 0; i < increment; i++) {
                shellSortThreads[i].getT().start();
            }
            try {
                for (int i = 0; i < increment; i++) {
                    shellSortThreads[i].getT().join();
                }
            } catch (InterruptedException ex) {
                System.out.println("Interrupted Exception " + ex);
            }
            increment/=2;
            for (int i = 0; i < increment; i++) {
                shellSortThreads[i] = new ShellSortTask(i, increment);
            }
        }while(increment!=0);
    }

    public int[] getArray() {
        return array;
    }

    public void printArray(){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
