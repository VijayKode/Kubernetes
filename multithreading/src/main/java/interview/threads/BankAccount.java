package interview.threads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankAccount {
   private double balance;

   public BankAccount(double balance) {
       this.balance = balance;
   }

   public void deposit(double money) {
       if(money > 0) {
           balance += money;
           System.out.println("Deposited Money "+money);
       } else {
           throw new RuntimeException("Invalid deposit amount");
       }
   }

    public void withdraw(double money) {
        if(money > 0) {
            if(balance >= money){
                balance-= money;
                System.out.println("Withdrawn Money "+money);
            } else {
                throw new RuntimeException("Insufficient Balance");
            }
        } else {
            throw new RuntimeException("Invalid withdrawal amount");
        }
    }

}
