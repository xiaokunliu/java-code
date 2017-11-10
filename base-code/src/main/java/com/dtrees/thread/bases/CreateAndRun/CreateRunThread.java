package com.dtrees.thread.bases.CreateAndRun;

/**
 * Created by keithl on 2017/9/23.
 */

public class CreateRunThread {
    /**
     *
     1. Create a class named Calculator that implements the Runnable interface
     2. Declare a private int attribute named number and implement the constructor of the class that initializes its value.
     3. Implement the run() method. This method will execute the instructions of the thread that we are creating, so this method will calculate the multiplication table of the number.
     4. Now, implement the main class of the application. Create a class named Main that contains the main() method.
     5. Inside the main() method, create a for loop with 10 iterations. Inside the loop, create an object of the Calculator class, an object of the Thread class, pass the Calculator object as a parameter, and call the start() method of the thread object.
     6. Run the program and see how the different threads work in parallel.
     */

    public static void main(String[] args) {
        for (int i=1; i<=10; i++){
            Calculator calculator=new Calculator(i);
            Thread thread=new Thread(calculator);
            thread.start();
        }
    }
}