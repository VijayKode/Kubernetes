package interview.threads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Depositor implements Runnable {
    private final BankAccount bankAccount;
    private Double amountToDeposit;

    public Depositor(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("Inside Dep run");

        synchronized (bankAccount) {
            bankAccount.deposit(amountToDeposit);
            System.out.println("money deposited");
            bankAccount.notify();
            System.out.println("notified to withdraw");
        }

    }
}
