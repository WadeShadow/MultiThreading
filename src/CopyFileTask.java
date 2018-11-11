import java.io.*;

public class CopyFileTask implements Runnable {
    private File sourceFile;
    private String fileDest;
    private Thread t;

    public CopyFileTask(File sourceFile, String fileDest) {
        this.sourceFile = sourceFile;
        this.fileDest = fileDest;
        t = new Thread(this);
    }

    @Override
    public void run() {
        File destFile = new File(fileDest, sourceFile.getName());
        if(destFile.exists()){
            System.out.println("File "+destFile.getName()+" exists. Copying aborted to prevent the loss of data");
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))){
            String str;
            while((str = reader.readLine())!=null){
                writer.write(str);
            }
        }catch (FileNotFoundException ex){
            System.out.println("There are no such files " + ex);
        }catch (IOException ex){
            System.out.println("I/O Exception " + ex);
        }

    }

    public Thread getThread() {
        return t;
    }
}
