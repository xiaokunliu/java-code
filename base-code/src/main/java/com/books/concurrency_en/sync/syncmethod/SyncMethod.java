package com.books.concurrency_en.sync.syncmethod;

public class SyncMethod {

    /**
     the use of the  synchronized keyword to control the concurrent access to a
     method. Only one execution thread will access one of the methods of an object declared with
     the  synchronized keyword. If another thread tries to access any method declared with the
     synchronized keyword of the same object, it will be suspended until the first thread finishes
     the execution of the method.
     */

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account : Initial Balance: %f\n",account.getBalance());
//        Start the threads
        companyThread.start();
        bankThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * We can use the  synchronized keyword to protect the access to a block of code instead
     of an entire method. We should use the  synchronized keyword in this way to protect the
     access to the shared data, leaving the rest of operations out of this block, obtaining a better
     performance of the application. The objective is to have the critical section (the block of code
     that can be accessed only by one thread at a time) be as short as possible. We have used the
     synchronized keyword to protect the access to the instruction that updates the number
     of persons in the building, leaving out the long operations of this block that don't use the
     shared data. When you use the  synchronized keyword in this way, you must pass an object
     reference as a parameter. Only one thread can access the  synchronized code (blocks or
     methods) of that object. Normally, we will use the  this keyword to reference the object that is
     executing the method
     *  synchronized (this) {
         // Java code
         }
     */
}
