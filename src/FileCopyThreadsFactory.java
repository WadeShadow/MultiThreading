import java.io.File;

public class FileCopyThreadsFactory {
    String directoryLocation;
    String destinationLocation;
    CopyFileTask[] fileCopiers;
    private int threadsNum;

    public FileCopyThreadsFactory(String directoryLocation, String destinationLocation) {
        this.directoryLocation = directoryLocation;
        this.destinationLocation = destinationLocation;
        File file = new File(directoryLocation);
        if (!file.isDirectory()) {
            System.out.println("Not a directory, cannot copy");
            return;
        }
        File[] files = file.listFiles();
        if (files == null) {
            System.out.println("Empty directory, nothing to copy");
            return;
        }
        threadsNum = files.length;
        fileCopiers = new CopyFileTask[threadsNum];
        for (int i = 0; i < files.length; i++) {
            fileCopiers[i] = new CopyFileTask(files[i], destinationLocation);
        }
    }

    public void executeThreads() {

        for (int i = 0; i < threadsNum; i++) {
            fileCopiers[i].getThread().start();
        }
        try {
            for (int i = 0; i < threadsNum; i++) {
                fileCopiers[i].getThread().join();
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception " + ex);
        }

    }
}
