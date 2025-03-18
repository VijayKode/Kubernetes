package interview.atm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Depositor implements Runnable {
    private final Atm atm;
    private Double amountToDeposit;

    public Depositor(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        System.out.println("Inside Dep run");
        int i = 1;
        while(i<5) {
            atm.deposit(amountToDeposit);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }

    }
}
