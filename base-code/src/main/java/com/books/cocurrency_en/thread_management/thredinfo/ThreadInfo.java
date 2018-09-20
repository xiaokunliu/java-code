package com.books.cocurrency_en.thread_management.thredinfo;

import com.books.cocurrency_en.thread_management.CreateAndRun.Calculator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * Created by keithl on 2017/9/23.
 */

public class ThreadInfo {

    //线程基本信息
//    ID: This attribute stores a unique identifier for each Thread
//    Name: This attribute store the name of Thread
//    Priority: This attribute stores the priority of the Thread objects.
//              Threads can have a priority between one and 10, where one is the lowest priority and 10 is the highest one.
//              It's not recommended to change the priority of the threads, but it's a possibility that you can use if you want
//    Status: This attribute stores the status of Thread.
//           In Java, Thread can be in one of these six states: new, runnable, blocked, waiting, time waiting, or terminated.


    public static void main(String[] args) throws Exception{
        /**
         * 基本步骤:
         1.Create a class named Calculator and specify that it implements the Runnable interface.
         2.Declare an int private attribute named number and implement the constructor of the class that initializes this attribute.
         3.Implement the run() method. This method will execute the instructions of the thread that we are creating, so this method will calculate and print the multiplication table of a number.
         4.Now, we implement the main class of this example. Create a class named Main and implement the main() method.
         5.Create an array of 10 threads and an array of 10 Thread.State to store the threads we are going to execute and their status.
         6.Create 10 objects of the Calculator class, each initialized with a different number, and 10 threads to run them. Set the priority of  ve of them to the maximum value and set the priority of the rest to the minimum value
         7.Create a PrintWriter object to write to a  le on the evolution of the status of the threads
         8.Write on this file the status of the 10 threads. Now, it becomes NEW
         9.Start the execution of the 10 threads.
         10.Until the 10 threads end, we are going to check their status. If we detect a change in the status of a thread, we write them on the  le.
         */

        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];

        for (int i=0; i<10; i++){
            threads[i]=new Thread(new Calculator(i));
            if ((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }

        //  创建一个文件写字符串的流对象,用于记录线程执行的状态
        FileWriter file = new FileWriter("log.txt");
        PrintWriter pw = new PrintWriter(file);

        // 开始记录状态,此时的状态是NEW
        for (int i=0; i<10; i++){
            pw.println("Main : Status of Thread "+i+" : "  + threads[i].getState());
            status[i]=threads[i].getState();
        }
        pw.flush();

        // 启动线程
        for (int i=0; i<10; i++){
            threads[i].start();
        }

        // 记录线程状态并写到日志文件中
        boolean finish=false;
        while (!finish) {
            for (int i=0; i<10; i++){
                System.out.println(threads[i].getState());
                if (threads[i].getState()!=status[i]) {
                    writeThreadInfo(pw, threads[i],status[i]);
                    status[i]=threads[i].getState();
                }
            }
            finish=true;
            for (int i=0; i<10; i++){
                finish=finish &&(threads[i].getState() == State.TERMINATED);
            }
        }
        pw.close();
        file.close();
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");
    }
}