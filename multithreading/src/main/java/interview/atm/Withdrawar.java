package interview.atm;

import interview.threads.BankAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Withdrawar implements Runnable {
    private final Atm atm;
    private double moneyToWithdraw;

    public Withdrawar(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void run() {

        try {
            int i=1;
            while(i<5) {
                atm.withdraw(moneyToWithdraw);
                i++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
