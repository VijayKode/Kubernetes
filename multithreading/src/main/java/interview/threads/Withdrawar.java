package interview.threads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Withdrawar implements Runnable {
    private final BankAccount bankAccount;
    private double moneyToWithdraw;

    public Withdrawar(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {

        synchronized (bankAccount) {
            System.out.println("Inside with run");

            if(bankAccount.getBalance()<moneyToWithdraw) {
                System.out.println("money is insufficient waiting for 5 sec to deposit");
                try {
                    bankAccount.wait(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            bankAccount.withdraw(moneyToWithdraw);
        }

    }
}
