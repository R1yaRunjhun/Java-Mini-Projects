import java.io.*;
import java.util.Scanner;

class InterestCalculator{
    public static void main(String args []) throws Exception
    {
        int choice,days,age,months;
        double Amount, interest;
        Scanner scanner = new Scanner(System.in);
        
        do{
            System.out.println("MAIN");
            System.out.println("--------");
            System.out.println("1.Interest Calculator - SB");
            System.out.println("2.Interest Calculator - FD");
            System.out.println("3.Interest Calculator - RD");
            System.out.println("4.Exit");
            System.out.print("Enter your option(1....4): ");
            choice= scanner.nextInt();
            try{
            switch(choice)
            {
                case 1:
                
                    System.out.print("Enter the Average amount in your account: ");
                    Amount= scanner.nextDouble();
                    if(Amount<0){throw new IllegalArgumentException();}
                    System.out.println("11.Interest Calculator - NRI");
                    System.out.println("12.Interest Calculator - Normaal");
                    System.out.print("Enter your account type(11/12): ");
                    int Type = scanner.nextInt();
                    switch(Type)
                    {
                        case 11:
                        interest = 6; 
                        SBAccount SBA1 = new SBAccount(Amount,interest);                       
                        System.out.println("Interest gained:"+ SBA1.calculateInterest());
                        break;

                        case 12:
                        interest = 4.00;
                        SBAccount SBA2 = new SBAccount(Amount,interest);
                        System.out.println("Interest gained:"+ SBA2.calculateInterest());
                        break;
                    }
               
                break;

                case 2:                   
                    System.out.print("Enter The FD amount:");
                    Amount = scanner.nextDouble();
                    System.out.print("Enter the number of days:");
                    days = scanner.nextInt();                    
                    System.out.print("Enter your age:");
                    age = scanner.nextInt();
                    if(age<0){throw new IllegalArgumentException("Invalid Number of age.");}
                    if(days<0){throw new IllegalArgumentException("Invalid Number of days.");}
                    if(Amount<0){throw new IllegalArgumentException("Invalid Amount.");}
                    interest=1;
                    FDAccount FDA1 =new FDAccount(Amount,interest,days,age);
                    System.out.println("Interest gained:"+ FDA1.calculateInterest());
                    break;

                case 3:
                    System.out.print("Enter The RD amount:");
                    Amount = scanner.nextDouble();
                    System.out.print("Enter the number of months:");
                    months = scanner.nextInt();
                    System.out.print("Enter your age:");
                    age = scanner.nextInt();
                    if(age<0){throw new IllegalArgumentException("Invalid Number of age.");}
                    if(months<0){throw new IllegalArgumentException("Invalid Number of months.");}
                    if(Amount<0){throw new IllegalArgumentException("Invalid Amount.");}
                    interest=1;
                    RDAccount RDA1 =new RDAccount(Amount,interest,months,age);
                    System.out.println("Interest gained:"+ RDA1.calculateInterest());
                    break; 

                case 4:
                    System.out.println("Program Terminated..");
                    break;
            } 
            }catch( IllegalArgumentException e){
                    System.out.print(e.getMessage()+" Please enter non-negative value");                    
            }
        }while(choice != 4);

    }

}

abstract class Account{
    double interestRate, amount;
    Account(double a,double b){
        amount = a;
        interestRate = b;
    }
    abstract double calculateInterest();
}

class SBAccount extends Account{
    SBAccount(double a,double b)
    {
        super(a,b);
    }
    double calculateInterest(){
        return(interestRate*0.01*amount );
        
    }
}

class FDAccount extends Account{
    int noofDays, ageofACHolder;
    FDAccount(double a,double b,int c,int d){
        super(a,b);
        noofDays = c;
        ageofACHolder = d;}

   
    
    double calculateInterest(){
        if(amount<10000000){
            if(ageofACHolder<60){
                if(noofDays>=7&&noofDays<=14)          {this.interestRate=4.50;}
                else if(noofDays>=15&&noofDays<=29)    {this.interestRate=4.75;}
                else if(noofDays>=30&& noofDays<=45)    {this.interestRate=5.50;}
                else if(noofDays>=45&&noofDays<=60)    {this.interestRate=7.00;}
                else if(noofDays>=61&&noofDays<=184)   {this.interestRate=7.50;}
                else if(noofDays>=185&&noofDays<=365)  {this.interestRate=8.00;}
            }

            else if(ageofACHolder>=60){
                if(noofDays>=7&&noofDays<=14)          {this.interestRate=5.00;}
                else if(noofDays>=15&&noofDays<=29)    {this.interestRate=5.20;}
                else if(noofDays>=30&&noofDays<=45)    {this.interestRate=6.00;}
                else if(noofDays>=45&&noofDays<=60)    {this.interestRate=7.50;}
                else if(noofDays>=61&&noofDays<=184)   {this.interestRate=8.00;}
                else if(noofDays>=185&&noofDays<=365)  {this.interestRate=8.50;}
            }
        }
        else if(amount>=10000000){
            if(noofDays>=7&&noofDays<=14)          {this.interestRate=6.50;}
            else if(noofDays>=15&&noofDays<=29)    {this.interestRate=6.75;}
            else if(noofDays>=30&&noofDays<=45)    {this.interestRate=6.75;}
            else if(noofDays>=45&&noofDays<=60)    {this.interestRate=8.00;}
            else if(noofDays>=61&&noofDays<=184)   {this.interestRate=8.50;}
            else if(noofDays>=185&&noofDays<=365)  {this.interestRate=10.00;}
            
        }
        return(interestRate*0.01*amount );
    }
}

class RDAccount extends Account{
    int noofMonths, ageofACHolder;
    RDAccount(double a,double b,int c,int d)
    {
        super(a,b);
        noofMonths = c;
        ageofACHolder = d;
    }
    

    double calculateInterest(){
        if(ageofACHolder<60){
            if(noofMonths==6)          {this.interestRate=7.50;}
            else if(noofMonths==9)    {this.interestRate=7.75;}
            else if(noofMonths==12)    {this.interestRate=8.00;}
            else if(noofMonths==15)    {this.interestRate=8.25;}
            else if(noofMonths==18)   {this.interestRate=8.50;}
            else if(noofMonths==21)  {this.interestRate=8.75;}
        }
    
        else if(ageofACHolder>=60){
            if(noofMonths==6)          {this.interestRate=8.00;}
            else if(noofMonths==9)    {this.interestRate=8.25;}
            else if(noofMonths==12)    {this.interestRate=8.50;}
            else if(noofMonths==15)    {this.interestRate=8.75;}
            else if(noofMonths==18)   {this.interestRate=9.00;}
            else if(noofMonths==21)  {this.interestRate=9.25;}
        }       

    return(interestRate*0.01*amount);
    }
}