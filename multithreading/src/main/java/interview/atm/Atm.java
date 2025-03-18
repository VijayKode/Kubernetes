package interview.atm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Atm {

    private final ReentrantLock depLock = new ReentrantLock();
    private final ReentrantLock withLock = new ReentrantLock();
//
//    private final Condition deposited = depLock.newCondition();
    private final Condition canWithdraw = withLock.newCondition();
    double moneyAvailable = 0;



    public void deposit(double money) {
        System.out.println("Depositing money "+ money);
        depLock.lock();
        moneyAvailable+=money;
        System.out.println("Depositing money completed. Available balance "+ moneyAvailable);
        depLock.unlock();
        System.out.println("Released deposited lock");
        System.out.println("Depositing money completed. Available balance "+ moneyAvailable);

        withLock.lock();
        canWithdraw.signal();
        withLock.unlock();

    }

    public void withdraw(double money) throws InterruptedException {
        System.out.println("Withdrawing money "+ money);
        withLock.lock();
        while(money > moneyAvailable) {
            System.out.println("Waiting.Insufficient money.Available Balance "+ moneyAvailable);
            canWithdraw.await();
        }
        moneyAvailable -= money;
        System.out.println("Withdrawing money done.Available balance"+ moneyAvailable);
        withLock.unlock();
        System.out.println("Released withdraw lock");
        //canWithdraw.signal();
        System.out.println("Signalled for withdraw");

    }
}
