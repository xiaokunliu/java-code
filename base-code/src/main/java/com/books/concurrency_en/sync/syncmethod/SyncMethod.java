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

        System.out.printf("Account : Initial Balance: %f\n",account.
                getBalance());
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
}
