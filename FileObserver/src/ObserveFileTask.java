import java.io.File;

public class ObserveFileTask implements Runnable {
    private File directory;
    private int filesInDirectory;
    private Thread t;

    public ObserveFileTask(File directory) {
        if(directory==null) throw new IllegalArgumentException("Null pointer as a directory");
            this.filesInDirectory = directory.listFiles().length;
        this.directory = directory;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        int currentLength;
        while (directory.exists()) {
            currentLength = directory.listFiles().length;
            if (filesInDirectory < currentLength) {

                System.out.println((currentLength - filesInDirectory ) + " files were added to the directory: " + directory.getName());
            }
            if(filesInDirectory>currentLength){
                System.out.println((filesInDirectory-currentLength  ) + " files were removed from directory: " + directory.getName());
            }
            filesInDirectory = currentLength;
            try{
                Thread.sleep(1000);

            }catch(InterruptedException ex){
                System.out.println("Interrupted exception "+ ex);
            }
        }
    }

    public Thread getT() {
        return t;
    }
}
