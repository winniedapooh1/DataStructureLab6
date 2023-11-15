package lab6assign5_template;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * the major methods are the make change and everything seems to be running soomthly
 */

public class ChangeDispenser {

    //public wrapper
    //NOTE - your wrapper method does NOT have to be a void method.
    public static void makeChange(int amount) {
        //add your code

        //Hints:
        //Use a list to store the denomination values of coins in decreasing order.
	//Use a second list to store the names of coins in the same order as their denomination value list.
        ArrayList<Integer> coinVal = new ArrayList<>();
        coinVal.add(100);
        coinVal.add(50);
        coinVal.add(25);
        coinVal.add(10);
        coinVal.add(5);
        coinVal.add(1);
        ArrayList<String> coinName = new ArrayList<>();
        coinName.add("DOLLAR");
        coinName.add("HALF-DOLAR");
        coinName.add("QUARTER");
        coinName.add("DIME");
        coinName.add("NICKLE");
        coinName.add("PENNY");
        int count = 0;
        int index = 0;
        makeChangePriv(amount,coinVal,coinName,index);
        //call the private recursive counterpart and pass the corresponding
        //   arguments.
    }
    private static void makeChangePriv(int n,ArrayList<Integer> coinVal,ArrayList<String> coinName, int i){
        int remainder = 0;
        if(n == 0){
            return;
        }else{
            if(i ==3){
                System.out.println(n/coinVal.get(coinVal.size() -1)  + " " + coinName.get(coinName.size() -1));
            } else {
                if (n / coinVal.get(i) > 1) {
                    System.out.println(n / coinVal.get(i) + " " + coinName.get(i) + "s");
                    remainder = n % coinVal.get(i);
                    coinVal.remove(i);
                    coinName.remove(i);
                    if (i < coinVal.size()) {
                        makeChangePriv(remainder, coinVal, coinName, i + 1);
                    }
                } else {
                    System.out.println(n / coinVal.get(i) + " " + coinName.get(i));
                    remainder = n % coinVal.get(i);
                    coinVal.remove(i);
                    coinName.remove(i);
                    if (i < coinVal.size()) {
                        makeChangePriv(remainder, coinVal, coinName, i + 1);
                    }
                }
            }
        }
    }
    //private recursive counterpart
    //NOTE - your recursive method does NOT have to be a void method.
    // example:
    // private static void makeChange(parameter list) {
    //   HintS -
    //       Your recursive method uses the coin value list and the coin name list. 
    //       In each call to the recursive method, the count of the first coin in the list 
    //          (coin in largest denomination value) is calculated and printed out. 
    //       Then the first coin is removed from the lists. 
    //       The remaining amount of money is calculated. 
    //       The coin lists and the remaining amount are passed to the next recursive call. 
    //       The recursion ends when no money is left.
    //}
    
    public static void main(String[] args) {

        //add your code to do the following:
        Scanner uI = new Scanner(System.in);
        System.out.println("Please enter a amount");
        double amount = uI.nextDouble();
        uI.nextLine();
        if(amount % 1 == 0){
            System.out.println("Please enter a amount");
            amount = uI.nextDouble();
            uI.nextLine();
            while(amount % 1 == 0){
                System.out.println("Please enter a amount");
                amount = uI.nextDouble();
                uI.nextLine();
            }
        }
        int cents = (int)(amount * 100);
        makeChange(cents);
        //prompt the user to enter the amount in dollars and cents
        //get the amount
        //convert the amount to all cents
        //call the public wrapper method
        
        //NOTE -
        // test your code using $2.91, $0.91, $0.78, $0
    }

}
