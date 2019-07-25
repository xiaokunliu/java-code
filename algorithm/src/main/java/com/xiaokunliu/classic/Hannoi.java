package com.xiaokunliu.classic;

/**
 * Created by keithl on 16-6-16.
 */
public class Hannoi {

    public static void main(String[] args){
        char aName = 'A';
        char bName = 'B';
        char cName = 'C';
        int totalPlates = 10;
        //start moving
        Hannoi hannoi = new Hannoi();
        hannoi.hannoi(totalPlates,aName,bName,cName);
    }

    //using recursion

    /**
     * the situation sight:
     *      it have its series of numbers like:
     *      f(n) = 2f(n-1)+1,f(1) = 1
     *      A  B  C
     */
    /**
     * @param n         the plates number
     * @param aName     source position which have put the plates
     * @param bName     as proxy position which help source to target position
     * @param cName     target position which have put the plates
     */
    public void hannoi(int n,char aName,char bName,char cName){
        if(n <=0 ){
            System.out.println(String.format("the %s have not any plates,the plates num is %d",aName,n));
            return;
        }

        if(n == 1){
            System.out.println(String.format("move plateform from %s to %s have done",aName,cName));
            return;
        }

        //if over 1 then execute as follow:
        //move n-1 from A to B,C as proxy
        hannoi(n-1,aName,cName,bName);
        //move the last one from A to C
        System.out.println(String.format("move the last one[%s] from %s to %s",n,aName,cName));
        //move n-1 from B to C,the A as proxy
        hannoi(n-1,bName,aName,cName);
    }
}
