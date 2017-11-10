package com.dtrees.thread.bases.interrupt;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by keithl on 2017/9/23.
 */

public class ControlInteruptedThread {

    // 控制线程中断
    /**
     * 背景:线程中执行的任务被切分为多个方法协作完成,而且存在递归方法的调用,这时候就需要
     * 一种方法技巧来控制线程中断,为此,Java提供了抛出InterruptedException的中断异常
     * 处理机制,当出现线程中断时,可以在run方法中catch异常并做相应的异常处理
     */

    // 执行demo的步骤
    /*
        1.Create a class called FileSearch and specify that it implements the Runnable interface.
        2.Declare two private attributes, one for the name of the file we are going to search for and one for the initial folder. Implement the constructor of the class, which initializes these attributes
        3.Implement the run() method of the FileSearch class. It checks if the attribute fileName is a directory and, if it is, calls the method processDirectory(). This method can throw an InterruptedException exception, so we have to catch them
        4.Implement the directoryProcess() method. This method will obtain the  les and sub folders in a folder and process them. For each directory, the method will make a recursive call passing the directory as a parameter. For each  le, the method will call the fileProcess() method. After processing all  les and folders, the method checks if Thread has been interrupted and, in this case, throws an InterruptedException exception.
        5.Implement the processFile() method. This method will compare the name of the  le it's processing with the name we are searching for. If the names are equal, we will write a message in the console. After this comparison, Thread will check if it has been interrupted and, in this case, it throws an InterruptedException exception.
        6.Now, let's implement the main class of the example. Implement a class called Main that contains the main() method.
        7.Create and initialize an object of the FileSearch class and Thread to execute its task. Then, start executing Thread.
        8.Wait for 10 seconds and interrupt Thread.
        9.Run the example and see the results.
     */
    public static void main(String[] args) {

        FileSearch fileSearch = new FileSearch("/Users/wind/projects/java/java-code/","pom.xml");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt(); // interrupt the thread
    }
}

class FileSearch implements Runnable{

    private String initPath;
    private String fileName;

    public FileSearch(String initPath,String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        System.out.println(file.isDirectory());
        if (file.isDirectory()){
            try {
                proceesDirectory(file);
            }catch (InterruptedException e){
                System.out.printf("%s: The search has been interrupted",Thread.currentThread().getName());
            }
        }
    }

    private void proceesDirectory(File file) throws InterruptedException{
        File[] filesList = file.listFiles();
        if (filesList != null && filesList.length > 0){
            for (File f:filesList){
                if (f.isDirectory()){
                    proceesDirectory(f);
                }else if (f.isFile()){
                    processFile(f);
                }
            }
        }
    }

    private void processFile(File f) throws InterruptedException{
        if (fileName.equals(f.getName())){
            System.out.printf("%s : %s\n",Thread.currentThread().getName() ,f.getAbsolutePath());
        }

        //check current main thread have been interrupted
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}