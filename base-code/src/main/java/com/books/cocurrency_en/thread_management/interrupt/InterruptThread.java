package com.books.cocurrency_en.thread_management.interrupt;


/**
 * Created by keithl on 2017/9/23.
 */

public class InterruptThread {

    // 线程中断

    // 开始步骤
    /**
     * 1. Create a class called PrimeGenerator that extends the Thread class
     * 2. Override the run() method including a loop that will run indefinitely. In this loop, we are going to process consecutive numbers beginning at one. For each number, we will calculate if it's a prime number and, in that case, we are going to write it to the console
     * 3. After processing a number, check if the thread has been interrupted by calling the isInterrupted() method. If this method returns true, we write a message and end the execution of the thread.
     * 4. Implement the isPrime() method. It returns a boolean value indicating if the number that is received as a parameter is a prime number (true) or not (false).
     * 5. Now, implement the main class of the example by implementing a class called Main and implementing the main() method.
     * 6. Create and start an object of the PrimeGenerator class.
     * 7. Wait for 5 seconds and interrupt the PrimeGenerator thread.
     * 8. Run the example and see the results
     */

    /*
    Note:The Thread class has another method to check whether Thread has been interrupted or not.
    It's the static method, interrupted(), that checks whether the current executing thread has been interrupted or not.
    Importance:
    There is an important difference between the isInterrupted() and the interrupted() methods.
    The first one doesn't change the value of the interrupted attribute,but the second one sets it to false.
    As the interrupted() method is a static method, the utilization of the isInterrupted() method is recommended.(isInterrupted()方法只是一种判断标识)
     */
    public static void main(String[] args) {

        Thread task=new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();// 中断线程执行
    }
}


class PrimeGenerator extends Thread{

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            if (this.isInterrupted()) {
                System.out.printf("The Prime Generator Thread[%s] has been Interrupted\n",Thread.currentThread().getName());
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <=2) {
            return true;
        }
        for (long i=2; i<number; i++){
            if ((number % i)==0) {
                return false;
            }
        }
        return true;
    }

}