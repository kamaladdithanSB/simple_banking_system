///a online shopping app,having credit card,upi and so on gateway
/// let each payment type handle its own logic!
package OOPS.abstraction;

import java.util.Scanner;

abstract class payment{
    double amount;//instance variable
    payment(double amount){//parameterized constructor
        this.amount = amount;//this constructor is initalizing the instance variable
    }
    abstract void makepayemnt();//abstract method
    void generatereciept(){
        System.out.println("receipt generated for : "+amount);
    }
}

class creditcardpayment extends payment{
    creditcardpayment(double amount){
        super(amount);//immediate parent class reference
    }
    void makepayemnt(){//providing body to abstract method
        System.out.println("paying "+" "+amount+" " +"using CREDIT CARD");
    }
}

class upipayement extends payment{
    upipayement(double amount){//parameterized construct
        super(amount);//using super kw to invoke parameterized constructor
    }
    void makepayemnt(){
        System.out.println("payment"+amount+"using UPI");
    }
}

class debitcard extends payment{
    debitcard(double amount){//parameterized construct
        super(amount);//using super kw to invoke parameterized constructor
    }
    void makepayemnt(){
        System.out.println("payment"+amount+"using DEBIT CARD");
    }
}

public class bankpaymentsystem{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the amount: ");
        int m = s.nextInt();
        System.out.println("enter the mode of transaction: ");
        System.out.println("option 1:CREDIT CARD");
        System.out.println("option 2:DEBIT CARD");
        System.out.println("option 3:UPI");
        int type = s.nextInt();

    
        payment credit = new creditcardpayment(m);
        payment upi = new upipayement(m);
        payment debit = new debitcard(m);
        
        if(type==1){
            credit.makepayemnt();
        credit.generatereciept();
        }
        else if(type==3){

        upi.makepayemnt();
        upi.generatereciept();
        }
        else{
            debit.makepayemnt();
            debit.generatereciept();
        }

        s.close();

    }
}